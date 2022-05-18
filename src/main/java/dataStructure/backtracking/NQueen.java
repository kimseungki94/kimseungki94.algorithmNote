package dataStructure.backtracking;

import java.util.ArrayList;

public class NQueen {

    private boolean isAvailable(Integer currentCol, ArrayList<Integer> candidateCol) {
        Integer currentRow = candidateCol.size();
        for(int index=0;index<candidateCol.size();index++) {
            if(currentCol==candidateCol.get(index) || Math.abs(currentCol - candidateCol.get(index)) == currentRow - index ) {
                return false;
            }
        }
        return true;
    }

    private void NQueenFunc(int currentRow, int N, ArrayList<Integer> candidateCol) {
        if(currentRow == N) {
            System.out.println(candidateCol);
            return;
        }
        for(int index = 0; index<N;index++) {
            if(this.isAvailable(index, candidateCol)) {
                candidateCol.add(index);
                this.NQueenFunc(currentRow+1,N,candidateCol);
                candidateCol.remove(candidateCol.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        ArrayList<Integer> candidateCol = new ArrayList<>();
        nQueen.NQueenFunc(0, 4, candidateCol);
    }
}
