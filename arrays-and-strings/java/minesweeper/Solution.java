package minesweeper;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        char[][] board = new char[][]{{'B', '1', 'E', '1', 'B'}, {'B', '1', 'M', '1', 'B'}, {'B', '1', '1', '1', 'B'}, {'B', 'B', 'B', 'B', 'B'}};
        int[] click = new int[]{1, 2};

        var solution = new Solution();
        char[][] result = solution.updateBoard(board, click);
        for (char[] row : result) {
            for (char el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }


    public char[][] updateBoard(char[][] board, int[] click) {

        int row = click[0];
        int column = click[1];

        if (board[row][column] == 'M') {
            board[row][column] = 'X';
            return board;
        }

        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(row, column));

        while (!stack.isEmpty()) {
            var aPair = stack.pop();
            var adjPairs = getPairs(board, aPair.row(), aPair.column());
            var mines = countAdjacentMines(board, adjPairs);

            if (mines > 0) {
                board[aPair.row()][aPair.column()] = String.valueOf(mines).charAt(0);
            } else {
                board[aPair.row()][aPair.column()] = 'B';
                addToStack(board, stack, adjPairs);
            }
        }
        return board;
    }

    private void addToStack(char[][] board, Deque<Pair> stack, List<Pair> pairs) {
        for (Pair aPair : pairs) {
            if (checkBounds(board, aPair) && board[aPair.row()][aPair.column()] == 'E') {
                stack.push(aPair);
            }
        }
    }

    private List<Pair> getPairs(char[][] board, int row, int column) {
        List<Pair> pairs = new ArrayList<>();
        var p1 = new Pair(row, column - 1);
        var p2 = new Pair(row, column + 1);
        var p3 = new Pair(row + 1, column);
        var p4 = new Pair(row - 1, column);
        var p5 = new Pair(row - 1, column - 1);
        var p6 = new Pair(row - 1, column + 1);
        var p7 = new Pair(row + 1, column - 1);
        var p8 = new Pair(row + 1, column + 1);

        if (checkBounds(board, p1)) pairs.add(p1);
        if (checkBounds(board, p2)) pairs.add(p2);
        if (checkBounds(board, p3)) pairs.add(p3);
        if (checkBounds(board, p4)) pairs.add(p4);
        if (checkBounds(board, p5)) pairs.add(p5);
        if (checkBounds(board, p6)) pairs.add(p6);
        if (checkBounds(board, p7)) pairs.add(p7);
        if (checkBounds(board, p8)) pairs.add(p8);
        return pairs;
    }

    private int countAdjacentMines(char[][] board, List<Pair> pairs) {
        int counter = 0;
        for (Pair aPair : pairs) {
            if (isMine(board, aPair)) ++counter;
        }
        return counter;
    }

    private boolean isMine(char[][] board, Pair p) {
        return checkBounds(board, p) && board[p.row()][p.column()] == 'M';
    }

    private boolean checkBounds(char[][] board, Pair pair) {
        var N = board.length;
        var M = board[0].length;

        return pair.row() >= 0 && pair.row() < N && pair.column() >= 0 && pair.column() < M;
    }
}

record Pair(int row, int column) {

}