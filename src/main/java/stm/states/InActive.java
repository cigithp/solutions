package stm.states;

import stm.events.Event;

public class InActive<T> implements State<T> {
    private final static String NAME = "INACTIVE";
    @Override
    public State<T> next() {
        return new Active();
    }

    @Override
    public State<T> previous() {
        return null;
    }

    @Override
    public void processEvent(Event e) {

    }

    @Override
    public String toString() {
        return "[State: "+NAME+"]";
    }
}
