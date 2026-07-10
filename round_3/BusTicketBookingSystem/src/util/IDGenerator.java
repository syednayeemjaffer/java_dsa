package util;

import java.util.concurrent.atomic.AtomicInteger;

public class IDGenerator {
    private static final AtomicInteger busCounter = new AtomicInteger(1000);
    private static final AtomicInteger customerCounter = new AtomicInteger(1000);
    private static final AtomicInteger ticketCounter = new AtomicInteger(10000);

    private IDGenerator() {}

    public static String generateBusId() {
        return constants.AppConstants.BUS_ID_PREFIX + busCounter.getAndIncrement();
    }

    public static String generateCustomerId() {
        return constants.AppConstants.CUSTOMER_ID_PREFIX + customerCounter.getAndIncrement();
    }

    public static String generateTicketId() {
        return constants.AppConstants.TICKET_ID_PREFIX + ticketCounter.getAndIncrement();
    }
}