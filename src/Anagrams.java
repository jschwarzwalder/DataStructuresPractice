import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Anagrams {
    public static int NUMBER_LETTERS = 26;

    public static void main(String[] args) {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        System.out.println(numberNeeded(first, second));
    }

    private static int numberNeeded(String first, String second) {
        int[] charCount1 = getCharCount(first);
        int[] charCount2 = getCharCount(second);
        return getDelta(charCount1, charCount2);
    }

    private static int getDelta(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return -1;
        }
        int delta = 0;
        for (int i = 0; i < array1.length; i++) {
            int difference = Math.abs(array1[i] - array2[i]);
            delta += difference;
        }
        return delta;
    }

    private static int[] getCharCount(String s) {
        int[] charCounts = new int[NUMBER_LETTERS];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int offset = (int) 'a';
            int code = (int) c - offset;
            charCounts[code]++;

        }
        return charCounts;
    }
}
