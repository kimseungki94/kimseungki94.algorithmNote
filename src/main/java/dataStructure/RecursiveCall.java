package dataStructure;

import java.util.ArrayList;

public class RecursiveCall {

    public Integer factorial(Integer number) {
        if (number <= 0) {
            return 1;
        }
        return number * this.factorial(number - 1);
    }

    public Integer changeFactorial(Integer number) {
        if (number <= 1) {
            return number;
        }
        return number * this.factorial(number - 1);
    }

    public Integer addArrayList(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return 0;
        }
        //return dataList.remove(0) + addArrayList(dataList);
        return dataList.get(0) + addArrayList(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
    }

    public Integer combination(Integer data) {
        if (data == 1) {
            return 1;
        }
        return data - 1 + combination(data - 1);
    }

    public Integer fibonacciRecursive(Integer data) {
        if (data == 0) {
            return 0;
        } else if (data == 1) {
            return 1;
        } else {
            return fibonacciRecursive(data-1) + fibonacciRecursive(data-2);
        }
    }

    public static void main(String[] args) {
        RecursiveCall recursiveCall = new RecursiveCall();
        System.out.println(recursiveCall.factorial(5));
        System.out.println(recursiveCall.changeFactorial(5));
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        System.out.println(arrayList.subList(0, arrayList.size()));
        System.out.println(recursiveCall.addArrayList(arrayList));
        System.out.println(recursiveCall.combination(4));
    }
}
