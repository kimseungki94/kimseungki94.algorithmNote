package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Heap {
    public ArrayList<Integer> bashHeap;

    public Heap(Integer data) {
        this.bashHeap = new ArrayList<Integer>();
        this.bashHeap.add(null);
        this.bashHeap.add(data);
    }

    private boolean moveUp(Integer childIdx) {
        if (childIdx <= 1) {
            return false;
        }
        Integer parentIdx = childIdx / 2;
        if (this.bashHeap.get(childIdx) > this.bashHeap.get(parentIdx)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean moveDown(Integer popIdx) {
        if (popIdx >= this.bashHeap.size()) {
            return false;
        } else {
            Integer leftIndex = popIdx * 2;
            Integer rightIndex = popIdx * 2 + 1;
            if (leftIndex >= this.bashHeap.size()) {
                return false;
            } else if (leftIndex == this.bashHeap.size() - 1) {
                if (this.bashHeap.get(leftIndex) > this.bashHeap.get(popIdx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.bashHeap.get(leftIndex) > this.bashHeap.get(rightIndex)) {
                    if (this.bashHeap.get(leftIndex) > this.bashHeap.get(popIdx)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (this.bashHeap.get(rightIndex) > this.bashHeap.get(popIdx)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    public boolean insert(Integer data) {
        if (this.bashHeap == null) {
            this.bashHeap = new ArrayList<Integer>();
            this.bashHeap.add(null);
            this.bashHeap.add(data);
            return true;
        }
        this.bashHeap.add(data);
        Integer childIdx = this.bashHeap.size() - 1;
        Integer parentIdx = null;
        while (this.moveUp(childIdx)) {
            parentIdx = childIdx / 2;
            Collections.swap(this.bashHeap, childIdx, parentIdx);
            childIdx = parentIdx;
        }
        return true;
    }

    public Integer pop() {
        Integer returnData = this.bashHeap.get(1);
        Integer leftIndex;
        Integer rightIndex;
        Integer popIndex = 1;
        Collections.swap(this.bashHeap, 1, this.bashHeap.size() - 1);
        this.bashHeap.remove(this.bashHeap.size()-1);
        while (this.moveDown(1)) {
            leftIndex = popIndex * 2;
            rightIndex = popIndex * 2 + 1;

            if(leftIndex == this.bashHeap.size()-1) {
                Collections.swap(this.bashHeap,popIndex,leftIndex);
            } else {
                if(this.bashHeap.get(leftIndex) > this.bashHeap.get(rightIndex)) {
                    Collections.swap(this.bashHeap,popIndex,leftIndex);
                } else {
                    Collections.swap(this.bashHeap,popIndex,rightIndex);
                }
            }
        }
        return returnData;
    }


    public static void main(String[] args) {
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.bashHeap);

        heapTest.pop();
        System.out.println(heapTest.bashHeap);
    }
}
