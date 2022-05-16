package dataStructure;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {
    public static void greedyFunc(Integer[][] objectList, double capacity) {
        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] comp1, Integer[] comp2) {
                return comp2[1] / comp2[0] - comp1[1] / comp1[0];
            }
        });
        double restNum = 0.0;
        double value = 0.0;
        for (int index = 0; index < objectList.length; index++) {
            if (capacity - objectList[index][0] > 0) {
                capacity -= objectList[index][0];
                value += objectList[index][1];
            } else {
                restNum = (double) capacity / objectList[index][0];
                value += (double) objectList[index][1] * restNum;
                break;
            }
        }
        System.out.println(value);

    }

    public static void main(String[] args) {
        //2차원 배열로 작성해보기
        Integer[][] objectList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
        greedyFunc(objectList, 30.0);
    }
}
