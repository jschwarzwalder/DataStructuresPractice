import java.util.HashMap;
import java.util.Map;

public class RandsomNote {

    private static boolean canBuildRandsomNote(String[] magazine, String[] note) {
        HashMap<String, Integer> magazineFreq = getStringFrequency(magazine);
        HashMap<String, Integer> noteFreq = getStringFrequency(note);
        return hasEnoughStrings(magazineFreq, noteFreq);

    }

    private static boolean hasEnoughStrings(HashMap<String, Integer> magazineFreq, HashMap<String, Integer> noteFreq) {
        for (Map.Entry<String, Integer> entry : noteFreq.entrySet()) {
            String word = entry.getKey();
            if (!magazineFreq.containsKey(word) || magazineFreq.get(word) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private static HashMap<String, Integer> getStringFrequency(String[] text) {
        HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
        for (String word : text) {
            if (!frequencies.containsKey(word)) {
                frequencies.put(word, 0);
            }
            frequencies.put(word, frequencies.get(word) + 1);
        }
        return frequencies;

    }

    public static void main(String[] args) {
        String[] magazine = {"hello", "world", "blah"};
        String[] note = {"hello", "world", "world"};
        System.out.println(canBuildRandsomNote(magazine, note));

        magazine = new String[]{"hello", "world", "world", "blah"};
        System.out.println(canBuildRandsomNote(magazine, note));
    }

}
