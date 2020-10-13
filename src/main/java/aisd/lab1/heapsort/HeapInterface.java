package aisd.lab1.heapsort;

public interface HeapInterface<T extends Comparable<T>> {

    public void put(T item);

    public T pop();
}
