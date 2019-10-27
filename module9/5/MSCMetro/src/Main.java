import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String LINK = "https://ru.wikipedia.org/wiki/Список_станций_Московского_метрополитена";
    public static final String FILE_NAME = "data/MSCMetro.json";
    public static final String LINE_NAME_REGEX = "\"[а-яА-я]+?.+?\\s[а-яА-я]+\\s?[а-яА-я]+\"";


    public static void main(String[] args) {
        try {
            Element table = Jsoup.connect(LINK).maxBodySize(0).get().select("table").get(3);
            Elements rows = table.select("tr");

            TreeMap<String, String> lineMap = new TreeMap<>();
            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements cols = row.select("td");
                String lineNumber = cols.get(0).text().substring(0, cols.get(0).text().length() - 2);
                Matcher m = Pattern.compile(LINE_NAME_REGEX).matcher(cols.get(0).html());
                if (m.find()) {
                    lineMap.put(lineNumber, m.group().substring(1, m.group().length() - 1));
                }
            }

            JSONObject obj = new JSONObject();
            obj.put("stations", getStations(lineMap, rows));
            obj.put("lines", getLines(lineMap));
            Files.write(Paths.get(FILE_NAME), obj.toJSONString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray getLines(Map<String, String> lineMap) {
        JSONArray lines = new JSONArray();
        for (String lineNumber: lineMap.keySet()) {
            JSONObject line = new JSONObject();
            line.put("number", lineNumber);
            line.put("name", lineMap.get(lineNumber));
            lines.add(line);
        }
        return lines;
    }

    public static JSONObject getStations(Map<String, String> lineMap , Elements rows) {
        JSONObject stations = new JSONObject();
        for (String lineNumber: lineMap.keySet()) {
            JSONArray list = new JSONArray();
            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements cols = row.select("td");
                String currLine = cols.get(0).text().substring(0, cols.get(0).text().length() - 2);
                if (lineNumber.equals(currLine)) {
                    String station = cols.get(1).text();
                    list.add(station);
                }
            }
            stations.put(lineNumber, list);
        }
        return stations;
    }
}
