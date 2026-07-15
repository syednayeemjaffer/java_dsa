package model;

public class Bus {
    private int id;
    private String busNo;
    private String busName;
    private String Source;
    private String Destination;
    private double fare;
    private int seat;

    public Bus(int id, String busNo, String busName, String source, String destination, double fare,int seat) {
        this.id = id;
        this.busNo = busNo;
        this.busName = busName;
        Source = source;
        Destination = destination;
        this.fare = fare;
        this.seat = seat;
    }

    public int getId() {
        return id;
    }

    public String getBusNo() {
        return busNo;
    }

    public String getBusName() {
        return busName;
    }

    public String getSource() {
        return Source;
    }

    public String getDestination() {
        return Destination;
    }

    public double getFare() {
        return fare;
    }

    public int getSeat() {
        return seat;
    }

    // tostring

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", busNo=" + busNo +
                ", busName='" + busName + '\'' +
                ", Source='" + Source + '\'' +
                ", Destination='" + Destination + '\'' +
                ", fare=" + fare +
                '}';
    }
}
