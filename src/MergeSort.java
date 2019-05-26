public class MergeSort {
    private static int[] placehodler;

    public int[] sort(int[] array) {


        if (array.length > 1) {
            int midpoint = array.length / 2;
            int[] left = sort(array[0:midpoint]);
            int[] right = sort(array[midpoint:-]);
            if (left.length <= 1 && right.length <= 1) {
                int tempLength = left.length + right.length;
                int[] tempArray = new int[tempLength];
                int rightindex = 0;
                int leftindex = 0;
                for (int i = 0; i < tempLength; i++) {
                    if (leftindex < left.length && left[leftindex] < right[rightindex]) {
                        tempArray[i] = left[leftindex];
                        left[leftindex]++;

                    } else {
                        tempArray[i] = right[rightindex];
                        right[rightindex]++;
                    }

                }


            }

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
        //copy back to the originoal array
        System.arraycopy(placehodler, leftStart, array, leftStart, size);
    }
}
