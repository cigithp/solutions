

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<E> {
    private final Queue<E> queue = new LinkedList<E>();
    private final int capacity;
    private int count = 0;

    public BlockingQueue(int capacity) {
        //  if (capacity <= 0)  throw new InvalidArgumentException();
        this.capacity = capacity;
    }

    public synchronized void add(E e) throws Exception {
        if (e == null) throw new NullPointerException("Null element is not allowed.");

        int oldCount = -1;
        while (count == capacity) this.wait();

        queue.add(e);
        oldCount = count;
        if (oldCount == 0) {
            this.notifyAll(); // notify other waiting threads (could be producers or consumers)
        }
    }

    public synchronized E remove() throws Exception {
        E e;

        int oldCount = -1;
        while (count == 0) this.wait();

        e = queue.remove();
        oldCount = count;
        if (oldCount == this.capacity) {
            this.notifyAll(); // notify other waiting threads (could be producers or consumers)
        }
        return e;
    }
}
