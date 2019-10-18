package exercise.algorithms;

public class QuickSort {


    public int[] sort(int[] array) {
        // Pick a pivot element randomly

        // Walk through the array making sure that all the elements
        // are smaller before the pivot, and that all elements after are bigger
        // and we do this in place! That's the killer feature. No extra array required.
        //
        // Then we repeat the process to the left and right portions over and over again
        // Then eventually our array becomes sorted.

        quicksort(array, 0, array.length - 1);

        return array;
    }

    private void quicksort(int[] arr, int left, int right) {

        // exit if all comparison are done from left to right of pivot
        if (left >= right) {
            return;
        }

        // Step1. declare pivot;
        int pivot = arr[(left + right) / 2];
        // Step2. partition the array around the pivot - return the index of partion.
        int index = partition(arr, left, right, pivot);


        quicksort(arr, left, index - 1);
        quicksort(arr, index, right);

    }

    private int partition(int[] arr, int left, int right, int pivot) {
        // Move the left and right pointers in towards each other
        while (left <= right) {
            // move left untill you find an element bigger than pivot
            while (arr[left] < pivot)
                left++;

            // move right untill you find an element smaller or equals to pivot
            while (arr[right] > pivot)
                right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        // When we get here, everything in this partition will be in the right order
        // Now we need to return next partition point - which for us will be left
        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

    }

}
