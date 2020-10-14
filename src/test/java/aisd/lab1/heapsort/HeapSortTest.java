package aisd.lab1.heapsort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapSortTest {

    private HeapSort hSort;

    @Before
    public void setUp() {
        hSort = new HeapSort();
    }

    @Test
    public void should_returnNull_when_unsortedVectorIsNull() {

        double[] unsortedVector = null;

        double[] sortedVector = hSort.sort(unsortedVector);
        double[] expectedResult = null;

        Assert.assertArrayEquals(expectedResult, sortedVector, 0);
    }

    @Test
    public void should_returnEmptyArray_when_unsortedVectorIsEmpty() {

        double[] unsortedVector = {};

        double[] sortedVector = hSort.sort(unsortedVector);
        double[] expectedResult = {};

        Assert.assertArrayEquals(expectedResult, sortedVector, 0);
    }

    @Test
    public void should_returnSortedVector_when_givenRightValues() {

        double[] unsortedVector = {4.5, -9.1, 0.0, -2.2, 15.7};

        double[] sortedVector = hSort.sort(unsortedVector);
        double[] expectedResult = {-9.1, -2.2, 0.0, 4.5, 15.7};

        Assert.assertArrayEquals(expectedResult, sortedVector, 0);
    }
}
