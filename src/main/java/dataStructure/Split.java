package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;

public class Split {
    public void splitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return;
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
        System.out.println(leftArr);
        System.out.println(pivot);
        System.out.println(rightArr);

        if(leftArr.size()>1) {
            splitFunc(leftArr);
        }
        if(rightArr.size()>1) {
            splitFunc(rightArr);
        }
        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        mergedArr.addAll(leftArr);
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(rightArr);
        System.out.println(mergedArr);
    }

    public static void main(String[] args) {
        Integer[] arr = {4,1,2,5,7,88,33,34,9,64};
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(arr));

        Split split = new Split();
        split.splitFunc(arrayList);
    }
}
