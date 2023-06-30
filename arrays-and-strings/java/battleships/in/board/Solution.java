package battleships.in.board;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        var ss = new Solution();
        System.out.println(ss.countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}}));

    }

    public int countBattleships(char[][] board) {
        int battleshipN = 0;

        int N = board.length; //rows
        int M = board[0].length; //columns

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if(board[i][j] == '.' || board[i][j] == 'O') continue;

                Deque<Pair> myStack = new LinkedList<>();
                var aPair = new Pair(i, j);
                myStack.push(aPair);
                ++battleshipN;

                //DFS
                while (!myStack.isEmpty()) {
                    var p = myStack.pop();
                    board[p.row][p.column] = 'O';

                    if(isBound(board, new Pair(p.row+1, p.column)) && board[p.row+1][p.column] == 'X') {
                        myStack.push(new Pair(p.row+1, p.column));
                    } else if(isBound(board, new Pair(p.row, p.column+1)) && board[p.row][p.column+1] == 'X') {
                        myStack.push(new Pair(p.row, p.column+1));
                    }
                }
            }
        }

        return battleshipN;
    }


    private boolean isBound(char[][] board, Pair pair) {
        int N = board.length; //rows
        int M = board[0].length; //columns

        return pair.row < N && pair.column < M;
    }
}

class Pair {

    final int row;
    final int column;

    Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
