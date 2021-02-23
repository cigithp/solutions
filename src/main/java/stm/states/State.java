package stm.states;

import stm.events.Event;

public interface State<T> {
    State<T> next();
    State<T> previous();
    void processEvent(Event<T> e);
    boolean validate(Event<T> e);
}
