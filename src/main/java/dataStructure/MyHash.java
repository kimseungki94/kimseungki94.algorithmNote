package dataStructure;

public class MyHash {
    Slot[] hashTable;

    public MyHash(Integer length) {
        this.hashTable = new Slot[length];
    }

    private class Slot {
        String value;

        public Slot(String value) {
            this.value = value;
        }
    }

    public Integer findKey(String value) {
        return ((int) value.charAt(0) % 20);
    }

    public void insertData(String key, String value) {
        Integer address = findKey(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
    }
    public String findValue(String key) {
        Integer address = findKey(key);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash hash = new MyHash(20);
        hash.insertData("1","aaa");
        hash.insertData("2","bbb");
        hash.insertData("3","ccc");
        hash.insertData("4","ddd");
        System.out.println(hash.findValue("3"));

    }
}
