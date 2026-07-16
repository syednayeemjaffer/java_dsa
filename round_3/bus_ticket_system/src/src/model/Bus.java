package model;

public class Bus {
    private final String id;
    private final String busNo;
    private final String busName;
    private final String source;
    private final String destination;
    private final double fare;
    private final int seat;
    private static int totalBus;

    public Bus(String id, String busNo, String busName, String source, String destination, double fare, int seat) {
        this.id = id;
        this.busNo = busNo;
        this.busName = busName;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.seat = seat;
        totalBus++;
    }

    public String getId() {
        return id;
    }

    public String getBusNo() {
        return busNo;
    }

    public String getBusName() {
        return busName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getFare() {
        return fare;
    }

    public int getSeat() {
        return seat;
    }

    public static int getTotalBus() {
        return totalBus;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id='" + id + '\'' +
                ", busNo='" + busNo + '\'' +
                ", busName='" + busName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", fare=" + fare +
                ", seat=" + seat +
                '}';
    }
}
