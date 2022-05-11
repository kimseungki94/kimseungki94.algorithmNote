package dataStructure;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        boolean isSwap = false;
        for(int index=0;index<dataList.size()-1;index++) {
            for(int index2=0;index2<dataList.size()-1-index;index2++) {
                if(dataList.get(index2) > dataList.get(index2+1)) {
                    Collections.swap(dataList,index2,index2+1);
                    isSwap = true;
                }
            }
            if(!isSwap) {
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i=0;i<20;i++) {
            dataList.add((int) (Math.random()*100));
        }
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(dataList);
        System.out.println(bubbleSort.sort(dataList));
    }

}
