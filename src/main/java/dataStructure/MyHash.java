package dataStructure;

public class MyHash {
    Slot[] hashTable;

    public MyHash(Integer length) {
        this.hashTable = new Slot[length];
    }

    private class Slot {
        String key;
        String value;
        Slot next;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public Integer findKey(String value) {
        return ((int) value.charAt(0) % 20);
    }

    public boolean insertData(String key, String value) {
        Integer address = findKey(key);
        if (this.hashTable[address] != null) {
            Slot prevSlot = this.hashTable[address];
            Slot nextSlot = this.hashTable[address];

            while (nextSlot != null) {
                if (nextSlot.key == key) {
                    nextSlot.value = value;
                    return true;
                } else {
                    prevSlot = nextSlot;
                    nextSlot = nextSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String findValue(String key) {
        Integer address = findKey(key);
        if (this.hashTable[address] != null) {
            Slot nextSlot = this.hashTable[address];
            while (nextSlot != null) {
                if (nextSlot.key == key) {
                    return nextSlot.value;
                } else {
                    nextSlot = nextSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash hash = new MyHash(20);
        hash.insertData("abc", "aaa");
        hash.insertData("apple", "bbb");
        hash.insertData("3", "ccc");
        hash.insertData("3", "ccc");
        hash.insertData("4", "ddd");
        System.out.println(hash.findValue("abc"));

    }
}
