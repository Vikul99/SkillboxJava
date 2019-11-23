import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String LINK = "https://ru.wikipedia.org/wiki/Список_станций_Московского_метрополитена";
    public static final String FILE_NAME = "data/MSCMetro.json";
    public static final String LINE_NAME_REGEX = "\"[а-яА-я]+?.+?\\s[а-яА-я]+\\s?[а-яА-я]+\"";


    public static void main(String[] args) {
        try {
            Element table = Jsoup.connect(LINK).maxBodySize(0).get()
                    .select("table:has(span[title='Сокольническая линия'])").first();

            List<Line> linesWithStations = getLinesWithStations(getLines(table), getStations(table));

            JSONObject metro = new JSONObject();
            JSONArray lines = getJsonLines(linesWithStations);
            JSONObject stations = getJsonStations(linesWithStations);
            JSONArray connections = getJsonConnections(getConnections(table));
            metro.put("stations", stations);
            metro.put("lines", lines);
            metro.put("connections", connections);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Files.write(Paths.get(FILE_NAME), gson.toJson(metro).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

//======================================================================================

        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());
            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            System.out.println("Количество станций на каждой линии: ");
            stationsObject.keySet().stream()
                    .sorted(Comparator.comparingInt(s ->
                            Integer.parseInt(((String)s).replaceAll("[^\\d]", "")))
                    )
                    .forEach(lineNumberObject ->
            {
                JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
                int stationsOnLineCount = stationsArray.size();
                System.out.println(lineNumberObject + " : " + stationsOnLineCount);
            });
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Map<String, String> getLines(Element table) {
        TreeMap<String, String> lines = new TreeMap<>();
        Elements rows = table.select("tr");
        for (int i = 1; i < rows.size(); i++) {
            Elements cols = rows.get(i).select("td");
            String lineNumber = cols.get(0).select("span:first-child").text();
            if (lineNumber.charAt(0) == '0') {
                lineNumber = lineNumber.substring(1);
            }
            Matcher m = Pattern.compile(LINE_NAME_REGEX).matcher(cols.get(0).html());
            if (m.find()) {
                String lineName = m.group().substring(1, m.group().length() - 1);
                lines.put(lineNumber, lineName);
            }
        }
        return lines;
    }

    public static List getStations(Element table) {
        List<Station> stations = new ArrayList<>();
        Elements rows = table.select("tr");
        for (int i = 1; i < rows.size(); i++) {
            Elements cols = rows.get(i).select("td");
            String lineNumber = cols.get(0).select("span:first-child").text();
            if (lineNumber.charAt(0) == '0') {
                lineNumber = lineNumber.substring(1);
            }
            String station = cols.get(1).select("span a").text();
            stations.add(new Station(lineNumber, station));
        }
        return stations;
    }

    public static List getLinesWithStations(Map<String, String> lines, List<Station> stations) {
        List<Line> linesWithStations = new ArrayList<>();
        for (String lineNumber: lines.keySet()) {
            List<Station> stationsOnLine =  new ArrayList<>();
            for (Station station: stations) {
                if (station.getLine().equals(lineNumber)) {
                    stationsOnLine.add(station);
                }
            }
            linesWithStations.add(new Line(lineNumber, lines.get(lineNumber), stationsOnLine));
        }
        return linesWithStations;
    }

    public static List getConnections(Element table) {
        List<Station> stations = getStations(table);
        List<Connection> connections = new ArrayList<>();

        Elements rows = table.select("tr");
        for (int i = 1; i < rows.size(); i++) {
            Elements cols = rows.get(i).select("td");

            Matcher m = Pattern.compile("ю+\\s+[А-ёяа-ёя]+?\\s[А-ёяа-ёя]+").matcher(cols.get(3).html());
            Set<String> tmp = new TreeSet<>();
            while (m.find()) {
                for (Station station: stations) {
                    if (m.group().substring(2).contains(station.getName())) {
                        tmp.add(station.getName());
                        tmp.remove("");
                    }
                }
            }

            List<String> connectedStationName = new ArrayList<>();
            connectedStationName.addAll(tmp);

            String[] connectedLineNumbers = cols.get(3).text().split("\\s");
            List<Station> connectedStations =  new ArrayList<>();

            for (int j = 0; j < connectedLineNumbers.length && j < connectedStationName.size(); j++) {
                if (!connectedLineNumbers[j].equals("") && connectedLineNumbers[j].charAt(0) == '0') {
                    connectedLineNumbers[j] = connectedLineNumbers[j].substring(1);
                }
                if (!connectedLineNumbers[j].equals("") && connectedStationName.size() > 0) {
                    connectedStations.add(new Station(connectedLineNumbers[j], connectedStationName.get(j)));
                }
            }

            if (connectedStations.size() > 0) {
                connections.add(new Connection(stations.get(i - 1), connectedStations));
            }
        }
        return connections;
    }

    public static JSONArray getJsonLines(List<Line> linesWithStations) {
        JSONArray lines = new JSONArray();
        for (Line line: linesWithStations) {
            JSONObject l = new JSONObject();
            l.put("number", line.getNumber());
            l.put("name", line.getName());
            lines.add(l);
        }
        return lines;
    }

    public static JSONObject getJsonStations(List<Line> linesWithStations) {
        JSONObject stations = new JSONObject();
        for (Line line: linesWithStations) {
            JSONArray list = new JSONArray();
            line.getStations().forEach(station -> list.add(station.getName()));
            stations.put(line.getNumber(), list);
        }
        return stations;
    }

    public static JSONArray getJsonConnections(List<Connection> connections) {
        JSONArray allConnections = new JSONArray();
        for (Connection connection: connections) {
            JSONArray oneConnection = new JSONArray();
            JSONObject mainStation = new JSONObject();
            mainStation.put("line", connection.getStation().getLine());
            mainStation.put("station", connection.getStation().getName());
            connection.getConnectedStations().forEach(station -> {
                JSONObject connectedStation = new JSONObject();
                connectedStation.put("line", station.getLine());
                connectedStation.put("station", station.getName());
                oneConnection.add(connectedStation);
            });
            oneConnection.add(mainStation);
            allConnections.add(oneConnection);
        }
        return allConnections;
    }

    public static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
