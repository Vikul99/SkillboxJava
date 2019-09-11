import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RouteCalculatorTest extends TestCase {

    RouteCalculator calculator;
    StationIndex stationIndex;
    Line lineOne;
    Line lineTwo;
    Line lineThree;
    Station a;
    Station z;
    Station e;
    Station d;
    Station k;
    Station b;
    Station c;
    Station f;
    Station g;

    /**
     * Z - A ----- E          (line1: Z - A - E - D - K )
     *     |       |          (line2: A - B - C - D)
     *     B - C - D - K      (line3: C - F - G)
     *         |
     *         F - G
     */

    @Override
    protected void setUp() throws Exception {
        stationIndex = new StationIndex();

        lineOne = new Line(1, "Первая");
        lineTwo = new Line(2, "Вторая");
        lineThree = new Line(3, "Третья");

        a = new Station("A", lineOne);
        z = new Station("Z", lineOne);
        e = new Station("E", lineOne);
        d = new Station("D", lineOne);
        k = new Station("K", lineOne);

        b = new Station("B", lineTwo);
        c = new Station("C", lineTwo);

        f = new Station("F", lineThree);
        g = new Station("G", lineThree);

        lineOne.addStation(z);
        lineOne.addStation(a);
        lineOne.addStation(e);
        lineOne.addStation(d);
        lineOne.addStation(k);

        lineTwo.addStation(a);
        lineTwo.addStation(b);
        lineTwo.addStation(c);
        lineTwo.addStation(d);

        lineThree.addStation(c);
        lineThree.addStation(f);
        lineThree.addStation(g);

        stationIndex.addStation(a);
        stationIndex.addStation(z);
        stationIndex.addStation(e);
        stationIndex.addStation(d);
        stationIndex.addStation(k);
        stationIndex.addStation(b);
        stationIndex.addStation(c);
        stationIndex.addStation(f);
        stationIndex.addStation(g);

        stationIndex.addLine(lineOne);
        stationIndex.addLine(lineTwo);
        stationIndex.addLine(lineThree);

        List<Station> connectionStations = new ArrayList<>();
        connectionStations.add(a);
        connectionStations.add(b);
        stationIndex.addConnection(connectionStations);
        connectionStations.clear();

        connectionStations.add(c);
        connectionStations.add(d);
        connectionStations.add(f);
        stationIndex.addConnection(connectionStations);
        connectionStations.clear();

        calculator = new RouteCalculator(stationIndex);
    }

    public void testCalculateDuration() {
        List<Station> route = calculator.getShortestRoute(e, c);
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 6;
        assertEquals(expected, actual);
    }

    public void testRouteOnTheLine() {
        List<Station> route = calculator.getShortestRoute(z, e);
        List<String> expected = Arrays.asList("Z", "A", "E");
        assertEquals(expected, route.stream().map(s -> s.getName()).collect(Collectors.toList()));
    }

    public void testRouteWithOneConnection() {
        List<Station> route = calculator.getShortestRoute(e, c);
        List<String> expected = Arrays.asList("E", "D", "C");
        assertEquals(expected, route.stream().map(s -> s.getName()).collect(Collectors.toList()));
    }

    public void testRouteWithTwoConnections() {
        List<Station> route = calculator.getShortestRoute(a, f);

        route.forEach(s -> System.out.println(s.getName()));

    }
    
    @Override
    protected void tearDown() throws Exception {

    }
}
