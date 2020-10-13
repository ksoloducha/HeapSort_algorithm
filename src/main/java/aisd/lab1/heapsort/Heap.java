package aisd.lab1.heapsort;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    private List<T> items;

    public Heap() {
        items = new ArrayList<>();
    }

    @Override
    public void put(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot put null value!");
        }
        items.add(item);
        heapUp(items.size() - 1);
    }

    @Override
    public T pop() {
        int n = items.size();

        if (n == 0) {
            return null;
        }

        int firstItemId = 0;
        int lastItemId = n - 1;

        swapItems(firstItemId, lastItemId);
        T rootItem = items.remove(lastItemId);

        heapDown();

        return rootItem;
    }

    private void heapUp(int lastId) {
        int childId = lastId;
        int parentId = (childId - 1) / 2;

        //while (parentId >= 0) {
        while (childId != 0) {

            if (isChildBiggerThanParent(parentId, childId)) {
                swapItems(parentId, childId);
                childId = parentId;
                parentId = (childId - 1) / 2;

            } else {
                break;
            }
        }
    }

    public void print() {
        for (T item : items) {
            System.out.println(item.toString());
        }
    }

    private void heapDown() {

        if (items.size() > 1) {

            int parentId = 0;
            int childId = chooseBiggerChild(parentId);

            while ((parentId * 2 + 1) < items.size()) {
                if (isChildBiggerThanParent(parentId, childId)) {
                    swapItems(parentId, childId);
                    parentId = childId;
                    childId = chooseBiggerChild(parentId);
                } else {
                    break;
                }
            }
        }
    }

    private boolean isChildBiggerThanParent(int parentId, int childId) {
        T parentValue = items.get(parentId);
        T childValue = items.get(childId);

        return childValue.compareTo(parentValue) > 0;
    }

    private int chooseBiggerChild(int parentId) {
        int leftChildId = parentId * 2 + 1;
        int rightChildId = parentId * 2 + 2;
        int n = items.size() - 1;

        if (rightChildId <= n) {
            T leftChildValue = items.get(leftChildId);
            T rightChildValue = items.get(rightChildId);

            if (leftChildValue.compareTo(rightChildValue) > 0) {
                return leftChildId;
            } else {
                return rightChildId;
            }
        } else {
            return leftChildId;
        }
    }

    private void swapItems(int firstId, int secondId) {
        T firstValue = items.get(firstId);

        items.set(firstId, items.get(secondId));
        items.set(secondId, firstValue);
    }
}
