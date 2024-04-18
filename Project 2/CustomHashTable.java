public class CustomHashTable {
    private static int DEFAULT_CAPACITY = 100;
    private Entry[] table;
    private int numberOfentires;
    private double LoadFactor = 0.5;

    private int hash(int key){
        return (key*key +8) % table.length;
    }

    public int getNumberOfentires() {
        return numberOfentires;
        
    }

    public void setNumberOfentires(int numberOfentires) {
        this.numberOfentires = numberOfentires;
        
    }

    public void insert(int key, Response value){
        if ( (double) getNumberOfentires()/ (double) table.length  > LoadFactor){
            rehash();
        }
        Entry newEntry = new Entry(key, value);
        int index = hash(key);
        while (table[index]!= null && table[index].getKey()!= key){
            index = (index +1) % table.length;
        }
        if (table[index] == null){
            table[index] = newEntry;
            setNumberOfentires(getNumberOfentires() + 1);
        } else {
            table[index] = newEntry;
        }
    }

    public Response search(int key){ 
        int index = hash(key);
        while (table[index]!= null && table[index].getKey()!= key){
            index = (index +1) % table.length;
        }
        if (table[index]==null){
            System.out.println("Key not in table.");
            return null;
        } else {
            return table[index].getValue();
        }
    }

    public void delete(int key){
        int index = hash(key);
        while (table[index]!= null && table[index].getKey()!= key){
            index = (index +1) % table.length;
        }
        if (table[index].getKey()== key){
            table[index] = null;
            setNumberOfentires(getNumberOfentires() - 1);
        } else {
            System.out.println("No such entry.");
        }
    }

    public void printHT(){
        for (int i =0; i < table.length; i++){
            if (table[i]== null){
                System.out.println("null");
            } else {
                System.out.println("("+ table[i].getKey() + "," + table[i].getValue() + ")");
            }
        }
    }
    public CustomHashTable() {
        this.table = new Entry[DEFAULT_CAPACITY];
        this.setNumberOfentires(0);
    }

    private void rehash(){
        Entry[] oldTable = table;
        int newCapacity = table.length *2;
        table = new Entry[newCapacity];
        setNumberOfentires(0);
        for (Entry entry:  oldTable){
            if (entry!= null) {
                insert(entry.getKey(), entry.getValue());
            }
        }
    }

    private static class Entry {
        private final int key;
        private Response value; 

        public Entry(int key, Response value){ 
            this.key = key;
            this.value = value;
        }
        public int getKey(){
            return key;
        }
        public Response getValue() { 
            return value;
        }
    }

    public static void main(String[] args) {
    
    }
}
