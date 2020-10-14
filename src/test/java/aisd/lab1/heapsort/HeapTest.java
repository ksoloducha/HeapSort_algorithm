package aisd.lab1.heapsort;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class HeapTest {

    private Heap<Double> heap;

    @Before
    public void setUp() {
        heap = new Heap<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void put_should_throwIllegalArgumentException_when_itemIsNull() {

        Double itemToPut = null;

        heap.put(itemToPut);
    }

    @Test
    public void put_should_addItemsInProperOrder_when_givenRightValues() {
        Double[] itemsToPut = {0.0, 2.5, -1.0, 5.0, 3.2};
        int n = itemsToPut.length;

        for (int i = 0; i < n; i++) {
            heap.put(itemsToPut[i]);
        }
        Double[] result = new Double[n];
        for (int i = 0; i < n; i++) {
            result[i] = heap.get(i);
        }
        Double[] expectedResult = {5.0, 3.2, -1.0, 0.0, 2.5};

        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void pop_should_returnNullValue_when_itemsIsEmpty() {

        Double result = heap.pop();
        Double expectedResult = null;

        assertEquals(expectedResult, result);
    }

    @Test
    public void pop_should_returnValuesDescending_when_itemsIsNotEmpty() {

        Double[] itemsToPut = {0.0, 2.5, -1.0, 5.0, 3.2};
        int n = itemsToPut.length;
        for (int i = 0; i < n; i++) {
            heap.put(itemsToPut[i]);
        }

        Double[] result = new Double[n];
        for (int i = 0; i < n; i++) {
            result[i] = heap.pop();
        }
        Double[] expectedResult = {5.0, 3.2, 2.5, 0.0, -1.0};

        Assert.assertArrayEquals(expectedResult, result);
    }
}
