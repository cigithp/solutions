package stm.states;

import stm.events.Event;

public class Active<T> implements State<T> {
    private final static String NAME = "ACTIVE";

    @Override
    public State<T> next() {
        return new InActive();
    }

    @Override
    public String toString() {
        return "[State: "+NAME+"]";
    }

    @Override
    public State<T> previous() {
        return new InActive();
    }

    @Override
    public boolean validate(Event<T> e) {
        return false;
    }

    @Override
    public void processEvent(Event e) {
        //according to the event
        //either it will go to next or previous state

    }
}
