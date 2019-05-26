import java.util.ArrayList;

public class MergeSort {
    private static int[] placehodler;

    public static int[] sort(int[] array) {
        return sort(array, 0, array.length);
    }

    public static int[] sort(int[] array, int leftindex, int rightindex) {

        if (array.length > 1) {
            int[] tempArray = new int[array.length];
            int midpoint = array.length / 2;
            int[] left = sort(array, 0, midpoint);
            int[] right = sort(array, midpoint, rightindex);
            if (left.length <= 1 && right.length <= 1) {

                for (int i = 0; i < array.length; i++) {
                    if (leftindex < left.length && left[leftindex] < right[rightindex]) {
                        tempArray[i] = left[leftindex];
                        left[leftindex]++;

                    } else {
                        tempArray[i] = right[rightindex];
                        right[rightindex]++;
                    }

                }


            }
            return tempArray;

        } else {
            return array;
        }
    }

    public static void mergesort(int[] array) {
        mergesort(array, placehodler, 0, array.length - 1);
    }

    public static void mergesort(int[] array, int[] placehodler, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergesort(array, placehodler, leftStart, middle);
        mergesort(array, placehodler, middle + 1, rightEnd);
        mergeHalves(array, placehodler, leftStart, rightEnd);

    }

    public static void mergeHalves(int[] array, int[] placehodler, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart - 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                placehodler[index] = array[left];

                left++;

            } else {
                placehodler[index] = array[right];
                right++;
            }
            index++;

        }
        System.arraycopy(array, left, placehodler, index, leftEnd - left + 1);
        System.arraycopy(array, right, placehodler, index, rightEnd - right + 1);
        //copy back to the original array
        System.arraycopy(placehodler, leftStart, array, leftStart, size);
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
            mergesort(test);
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

                int[] sortedtest = sort(test);
                for (int i : sortedtest) {
                System.out.print(i + ", ");
            }
            System.out.print("\n");
        }

    }
}

