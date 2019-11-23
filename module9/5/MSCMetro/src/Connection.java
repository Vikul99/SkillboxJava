import java.util.List;

public class Connection {
    private Station station;
    private List<Station> connectedStations;

    public Connection(Station station, List<Station> connectedStations) {
        this.station = station;
        this.connectedStations = connectedStations;
    }

    public Station getStation() {
        return station;
    }

    public List<Station> getConnectedStations() {
        return connectedStations;
    }
}
