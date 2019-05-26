public class BubbleSort {
    public int[] sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int value = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = value;
                }
            }

        }

        return array;
    }

    public static void bubblesort(int[] array){
        boolean isSorted = false;
        int lastUnsorted = array.length -1;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++){
                if (array[i] > array[i +1]){
                    int value = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = value;
                    isSorted = false;
                }
            }
        }
    }
}
