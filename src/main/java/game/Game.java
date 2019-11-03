package game;

public interface Game<T> {
    public void start(T t);
    public void stop(T t);
    public void selectSide(T t);
    public void winner();
    public void lastMoves();

}
