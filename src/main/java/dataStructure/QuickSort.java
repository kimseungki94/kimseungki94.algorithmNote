package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        Integer pivot = dataList.get(0);
        for (int index = 1; index < dataList.size(); index++) {
            if (pivot >= dataList.get(index)) {
                leftArr.add(dataList.get(index));
            } else {
                rightArr.add(dataList.get(index));
            }
        }

        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        mergedArr.addAll(this.sort(leftArr));
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(this.sort(rightArr));
        System.out.println(mergedArr);
        return mergedArr;
    }
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int index = 0; index<=100;index++) {
            arrayList.add((int)(Math.random()*100));
        }

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arrayList);
    }
}
