import java.util.ArrayList;

public class SelectionSort {

    public static void sort(int[] array) {

        for (int i = 0; i < array.length ; i++){
            int smallest = i;
            for (int j = i; j < array.length; j++){
                if (array[j] < array[smallest]){
                    smallest = j;
                }
            }
            int value = array[i];
            array[i] = array[smallest];
            array[smallest] = value;
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
            sort(test);
            for (int i : test) {
                System.out.print(i + ", ");
            }
            System.out.print("\n");
        }
    }
}
