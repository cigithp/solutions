package stm.states;

import stm.events.Event;

public interface State<T> {
    public State<T> next();
    public State<T> previous();
    public void processEvent(Event<T> e);
}
