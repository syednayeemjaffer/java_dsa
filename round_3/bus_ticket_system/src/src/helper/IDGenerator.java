package helper;

import java.util.UUID;

public final class IDGenerator {

    private IDGenerator() {
        // prevent instantiation
    }

    public static String generateID() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
