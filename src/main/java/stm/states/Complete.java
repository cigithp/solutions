package stm.states;

import stm.events.Event;

public class Complete<T> implements State<T>{
    private static final String NAME = "COMPLETE";

    @Override
    public State<T> next() {
        return null;
    }

    @Override
    public String toString() {
        return "[State: "+NAME+"]";
    }

    @Override
    public State<T> previous() {
        return null;
    }

    @Override
    public void processEvent(Event<T> e) {

    }

    @Override
    public boolean validate(Event<T> e) {
        return false;
    }
}
