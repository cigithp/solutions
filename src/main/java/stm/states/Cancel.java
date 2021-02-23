package stm.states;

import stm.events.Event;

public class Cancel<T> implements State<T> {
    private final static String NAME = "CANCEL";

    @Override
    public State<T> next() {
        return null;
    }

    @Override
    public State<T> previous() {
        return null;
    }

    @Override
    public void processEvent(Event<T> e) {

    }

    @Override
    public String toString() {
        return "[State: "+NAME+"]";
    }

    @Override
    public boolean validate(Event<T> e) {
        return false;
    }
}
