package dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class BinarySearchTreeAlgorithm {

    public boolean search(ArrayList<Integer> dataList, Integer searchData) {
        if (dataList.size() == 0) {
            return false;
        }
        if (dataList.size() == 1 && searchData == dataList.get(0)) {
            return true;
        }
        if (dataList.size() == 1 && searchData != dataList.get(0)) {
            return false;
        }

        Integer medium = dataList.size() / 2;
        if (searchData == dataList.get(medium)) {
            return true;
        } else {
            if (searchData < dataList.get(medium)) {
                return this.search(new ArrayList<>(dataList.subList(0, medium)), searchData);
            } else {
                return this.search(new ArrayList<>(dataList.subList(medium, dataList.size())), searchData);
            }
        }


    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int index = 0; index <= 100; index++) {
            arrayList.add((int) (Math.random() * 100));
        }

        System.out.println(arrayList);
        BinarySearchTreeAlgorithm binarySearchTreeAlgorithm = new BinarySearchTreeAlgorithm();
        System.out.println(binarySearchTreeAlgorithm.search(arrayList, 4));

    }
}
