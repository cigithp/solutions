package stm.events;

public class IncomingEvent<T> implements Event<T> {
    private final static String NAME = "INCOMING";

    @Override
    public String toString() {
        return "[Event: "+NAME+"]";
    }
}
