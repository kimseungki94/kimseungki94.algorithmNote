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
        if (data <= 1) {
            return data;
        } else {
            return fibonacciRecursive(data-1) + fibonacciRecursive(data-2);
        }
    }
    public Integer fibonacciDymanic(Integer data) {
        int[] arr = new int[data+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int index=2;index<=data;index++) {
            arr[index] = arr[index-1] + arr[index-2];
        }
        return arr[data];
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
        System.out.println(recursiveCall.combination(5));
        System.out.println(recursiveCall.fibonacciRecursive(5));
        System.out.println(recursiveCall.fibonacciRecursive(6));
        System.out.println(recursiveCall.fibonacciDymanic(5));
        System.out.println(recursiveCall.fibonacciDymanic(6));
    }
}
