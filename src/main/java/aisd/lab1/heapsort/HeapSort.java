package aisd.lab1.heapsort;

public class HeapSort implements ListSorterAlgorithm {

    private final HeapInterface<Double> heap;

    public HeapSort() {
        heap = new Heap<>();
    }

    @Override
    public double[] sort(double[] unsortedVector) {

        if (unsortedVector == null || unsortedVector.length == 0) {
            return unsortedVector;
        }

        int n = unsortedVector.length;
        double[] sortedVector = new double[n];

        for (int i = 0; i < n; i++) {
            heap.put(unsortedVector[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            sortedVector[i] = heap.pop();
        }

        return sortedVector;
    }
}
