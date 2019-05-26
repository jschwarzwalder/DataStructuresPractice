import java.util.ArrayList;

public class BinarySearch {

    public static boolean binarySearchRecursive(int[] array, int x, int left, int right) {
        boolean doesContain = false;
        if (left > right) {
            return false;
        } else {
            int midpoint = left + ((right - left) / 2);
            int arrayValue = array[midpoint];

            if (arrayValue == x) {
                doesContain = true;
            } else if (arrayValue > x) {
                doesContain = binarySearchRecursive(array, x, left, midpoint - 1);
            } else if (arrayValue < x) {
                doesContain = binarySearchRecursive(array, x, midpoint + 1, right);
            }


            return doesContain;
        }
    }
        public static boolean binarySearchRecursive( int[] array, int x){
            if (array.length > 0) {
                return binarySearchRecursive(array, x, 0, array.length - 1);
            } else {
                return false;
            }
        }

        public static void main (String[]args){
            ArrayList<int[]> Tests = new ArrayList<>();
            Tests.add(new int[]{0});
            Tests.add(new int[]{});
            Tests.add(new int[]{0, 0, 0, 1, 1, 1});
            Tests.add(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
            Tests.add(new int[]{-10, -5, -1, 0, 1, 4, 5, 10, 15, 18});
            Tests.add(new int[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0});
            Tests.add(new int[]{1, 2, 3, 4, 5, 6});

            for (int[] test : Tests) {

                boolean doesContain = binarySearchRecursive(test, 0);
                System.out.print(doesContain + ": 0 is in [");
                for (int i : test) {
                    System.out.print(i + ", ");
                }

                System.out.print("]\n");
            }

        }
    }

