package util;

public class IDGenerator {

    private static int passengerIdCounter = 1001;

    private IDGenerator() {
        // Prevent object creation
    }

    public static int generatePassengerId() {
        return passengerIdCounter++;
    }

}