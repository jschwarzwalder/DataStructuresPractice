public class SelectionSort {

    public int[] sort(int[] array) {

        for (int i = 0; i < array.length ; i++){
            int smallest = i;
            for (int j = i; j < array.length; j++){
                if (array[j] < smallest){
                    smallest = j;
                }
            }
            int value = array[i];
            array[i] = array[smallest];
            array[smallest] = value;
        }

        return array;
    }
}
