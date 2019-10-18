package assessment.sofi;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment1Test {

    private Assignment1 solution;

    @Before
    public void setUp() {
        solution = new Assignment1();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void arrayReductionZeroElementArray() {
        //S
        int[] arr = {};
        int actual = solution.arrayReduction(arr);

        Assert.assertEquals(0, actual);

    }

    @Test
    public void arrayReductionOneElementArray() {
        //S
        int[] arr = {1};
        int actual = solution.arrayReduction(arr);

        Assert.assertEquals(0, actual);

    }

    @Test
    public void arrayReductionTwoElementArray() {
        //S
        int[] arr = {2, 11};
        int actual = solution.arrayReduction(arr);

        Assert.assertEquals(13, actual);

    }

    @Test
    public void arrayReductionThreeElementArray() {
        //
        int[] arr = {2, 1, 3};
        int actual = solution.arrayReduction(arr);

        Assert.assertEquals(9, actual);

    }

    @Test
    public void arrayReductionThreeElementArray2() {
        //
        int[] arr = {2, 1, 4};
        int actual = solution.arrayReduction(arr);

        Assert.assertEquals(10, actual);

    }

    @Test
    public void arrayReductionFourElementArray() {
        //
        int[] arr = {2, 1, 4, 3};
        int actual = solution.arrayReduction(arr);

        Assert.assertEquals(19, actual);

    }

    @Test
    public void arrayReductionOneDuplicateElemmentArray() {
        //
        int[] arr = {4, 3, 2, 4, 5};
        int actual = solution.arrayReduction(arr);

        Assert.assertEquals(41, actual);

    }

    @Test
    public void arrayReductionAllDuplicateElementArray() {
        //
        int[] arr = {1, 1, 1, 1};
        int actual = solution.arrayReduction(arr);

        Assert.assertEquals(8, actual);

    }

    @Test
    public void arrayReductionManyDuplicateElementArray() {
        //
        int[] arr = {2, 5, 5, 5, 5, 6, 6, 6, 8};
        int actual = solution.arrayReduction(arr);

        Assert.assertEquals(151, actual);

    }

    @Test
    public void arrayReductionHighValueElementArray() {
        //
        int[] arr = {0, 100000, 20000, 30000, 100000, 0, 0, 0, 1};
        int actual = solution.arrayReduction(arr);

        Assert.assertEquals(470005, actual);

    }

    @Test
    public void shouldInsertInSortedArray() {
        int[] arr = {1, 2, 4, 6, 9};
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        solution.binarySearchInsertion(list, 7);
        Assert.assertEquals(list.size(), 6);
        Assert.assertEquals(list.get(4), Integer.valueOf(7));
    }

    @Test
    public void shouldInsertInEmptyArray() {
        int[] arr = {};
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        solution.binarySearchInsertion(list, 7);
        Assert.assertEquals(list.size(), 1);
        Assert.assertEquals(list.get(0), Integer.valueOf(7));
    }

}