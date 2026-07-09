package util;

public class IDGenerator {

    private static int ticketId = 1000;

    private IDGenerator() {
    }

    public static int generateTicketId() {
        return ticketId++;
    }
}