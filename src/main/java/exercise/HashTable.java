package exercise;

public class HashTable {

    private int INITIAL_SIZE = 16;
    private HashEntry[] data; // LinkedList

    class HashEntry {
        String key;
        String value;
        HashEntry next;

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "[ " + key + ", " + value + " ]";
        }
    }

    HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    public void put(String key, String value) {

        // get the index
        int index = getIndex(key);

        // Create  the LinkedList Entry
        HashEntry hashEntry = new HashEntry(key, value);

        if (data[index] == null) {
            data[index] = hashEntry;
        }
        // else handle collision by addking to the end of LL
        else {
            HashEntry entries = data[index];
            // Walk to the end
            while (entries.next != null) {
                entries = entries.next;
            }
            entries.next = hashEntry;
        }

    }

    public String get(String key) {
        // get the index
        int index = getIndex(key);

        //Get the current list of entries
        HashEntry entries = data[index];

        // if we have existing entries against this key
        if (entries != null) {
            // else walk chain untill find a match
            while (!entries.key.equals(key) && entries.next != null) {
                entries = entries.next;
            }
            return entries.value;
        }
        // if we have no entries against this key..
        return null;
    }

    private int getIndex(String key) {
        //Get the hashcode
        int hashcode = key.hashCode();
        System.out.println("hashcode " + hashcode);

        //Convert to index;
//        int index = hashcode % INITIAL_SIZE;
        // convert negative index to positive
        int index = (hashcode & 0x7fffffff) % INITIAL_SIZE;
        System.out.println("index =  " + index);

//        //hack to force collision for testing
//        if (key.equals("John Smith") || key.equals("Sandra Dee")) {
//            index = 4;
//        }

        return index;
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : data) {
            if (entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while (temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }
}
