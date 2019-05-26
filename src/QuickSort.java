public class QuickSort {
    public void sort(int[] array) {
        int pivot = (int) Math.random() * array.length;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] > array[pivot] && array[right] < array[pivot]) {
                int value = array[left];
                array[left] = array[right];
                array[right] = value;
                left++;
                right--;
            } else if (array[left] <= array[pivot]) {
                left++;
            } else if (array[right] >= array[pivot])){
                right--;
            }
        }

        sort(array[0:left]);
        sort(array[right:-1]);


    }

    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    public static void quicksort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = array[(left + right) / 2];
        int index = particition(array, left, right, pivot);
        quicksort(array, left, index - 1);
        quicksort(array, index, right);
    }

    private static int particition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int value = array[left];
                array[left] = array[right];
                array[right] = value;
                left++;
                right--;
            }
        }

        return left;
    }
}
