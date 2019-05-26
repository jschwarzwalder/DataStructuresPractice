import java.util.ArrayList;

public class QuickSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length -1);
    }
    public static void sort(int[] array, int start, int end) {
        int right = start;
        int left = end;
        if (right < left){
            return;
        }
        int pivot = (right + left)/2;
        System.out.println(start + ", " + end + ", " + pivot);
        while (left < right) {

            if (array[left] > array[pivot] && array[right] < array[pivot]) {
                int value = array[left];
                array[left] = array[right];
                array[right] = value;
                left++;
                right--;
            } else if (array[left] <= array[pivot]) {
                left++;
            } else if (array[right] >= array[pivot]){
                right--;

            }

        }
        if (right > 0) {
            sort(array, start, left - 1);
            sort(array, left, end);
        }




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

    public static void main(String[] args) {
        ArrayList<int[]> Tests = new ArrayList<int[]>();
        Tests.add(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        Tests.add(new int[]{});
        Tests.add(new int[]{-1, 0, -5, 5, 0, 4, -10});
        Tests.add(new int[]{1, 3, 5, 4, 2, 6});
        Tests.add(new int[]{0, 1, 0, 1, 0, 1});

        for (int[] test : Tests) {
            System.out.print("test : ");
            quicksort(test);
            for (int i : test) {
                System.out.print(i + ", ");
            }
            System.out.print("\n");
        }

        ArrayList<int[]> Tests2 = new ArrayList<int[]>();
        Tests2.add(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        Tests2.add(new int[]{});
        Tests2.add(new int[]{-1, 0, -5, 5, 0, 4, -10});
        Tests2.add(new int[]{1, 3, 5, 4, 2, 6});
        Tests2.add(new int[]{0, 1, 0, 1, 0, 1});

        for (int[] test : Tests2) {
            System.out.print("test : ");
            sort(test);
            for (int i : test) {
                System.out.print(i + ", ");
            }
            System.out.print("\n");
        }
    }
}
