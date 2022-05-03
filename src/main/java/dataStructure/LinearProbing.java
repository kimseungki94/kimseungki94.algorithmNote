package dataStructure;

public class LinearProbing {
    Slot[] hashTable;

    public LinearProbing(Integer length) {
        this.hashTable = new Slot[length];
    }

    private class Slot {
        String key;
        String value;

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
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[address].value = value;
                    }
                    currAddress += 1;
                    if (currAddress >= this.hashTable.length) {
                        return false;
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
            }

        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String findValue(String key) {
        Integer address = findKey(key);
            while (this.hashTable[address] != null) {
                if (this.hashTable[address].key == key) {
                    return this.hashTable[address].value;
                } else {
                    address = address + 1;
                    if (address >= this.hashTable.length) {
                        return null;
                    }
                }
            }
            return null;
    }

    public static void main(String[] args) {
        LinearProbing hash = new LinearProbing(20);
        hash.insertData("abc", "aaa");
        hash.insertData("apple", "bbb");
        hash.insertData("3", "ccc");
        hash.insertData("3", "ccc");
        hash.insertData("4", "ddd");
        System.out.println(hash.findValue("abc"));

    }
}
