import java.util.ArrayList;

public class BubbleSort {
    public static int[] sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[index]) {
                    int value = array[index];
                    array[index] = array[j];
                    array[j] = value;

                }
            }

        }

        return array;
    }

    public static void bubblesort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    int value = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = value;
                    isSorted = false;
                }
            }
        }
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
            int[] sortedtest = sort(test);
            for (int i : sortedtest) {
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
            bubblesort(test);
            for (int i : test) {
                System.out.print(i + ", ");
            }
            System.out.print("\n");
        }
    }

}
