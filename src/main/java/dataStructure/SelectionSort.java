package dataStructure;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        Integer minIndex = 0;
        boolean isSwap = false;
        for (int index = 0; index < dataList.size() - 1; index++) {
            minIndex = index;
            for (int index2 = index + 1; index2 <= dataList.size() - 1; index2++) {
                if (dataList.get(minIndex) > dataList.get(index2)) {
                    minIndex = index2;
                }
            }
            Collections.swap(dataList, index, minIndex);
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add((int) (Math.random() * 100));
        }
        System.out.println(dataList);
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(selectionSort.sort(dataList));
    }
}
