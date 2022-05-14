package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeSort {
    public ArrayList<Integer> mergeSplit(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medList = dataList.size()/2;
        ArrayList<Integer> leftList = this.mergeSplit(new ArrayList<>(dataList.subList(0, medList)));
        ArrayList<Integer> rightList = this.mergeSplit(new ArrayList<>(dataList.subList(medList, dataList.size())));
        return mergeSort(leftList, rightList);
    }

    private ArrayList<Integer> mergeSort(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergeList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) < rightList.get(rightPoint)) {
                mergeList.add(leftList.get(leftPoint));
                leftPoint += 1;
            } else {
                mergeList.add(rightList.get(rightPoint));
                rightPoint += 1;
            }
        }
        while (leftList.size() > leftPoint) {
            mergeList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }
        while (rightList.size() > rightPoint) {
            mergeList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }
        return mergeList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int index = 0; index < 100 ; index++) {
            arrayList.add((int) (Math.random()*100));
        }
        MergeSort mergeSort = new MergeSort();
        System.out.println(mergeSort.mergeSplit(arrayList));
    }
}
