public class HashTable {

    LinkedList[] data;

    public boolean put (String key, Person value) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList list = data[index];
        list.insert(key.value);
    }
}
