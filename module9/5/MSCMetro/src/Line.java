import java.util.List;

public class Line {
    private String number;
    private String name;
    private List<Station> stations;

    public Line(String number, String name, List<Station> stations) {
        this.number = number;
        this.name = name;
        this.stations = stations;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }
}
