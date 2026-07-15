package helper;

import java.util.UUID;

public class IDGenerator {
    public IDGenerator() {}
    public static String generateID(){
        return UUID.randomUUID().toString().substring(0,6);
    }
}
