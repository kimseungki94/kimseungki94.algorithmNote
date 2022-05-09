package dataStructure;

import java.util.ArrayList;
import java.util.Collections;

public class InsertSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index++) {
            for (int index2 = index + 1; index2 > 0; index2--) {
                if (dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add((int) (Math.random() * 1000));
        }
        System.out.println(dataList);
        InsertSort insertSort = new InsertSort();
        System.out.println(insertSort.sort(dataList));
    }
}
