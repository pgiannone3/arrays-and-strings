package check.knight.tour;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = new int[][]{{0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}};
        System.out.println(s.checkValidGrid(grid));
    }

    public boolean checkValidGrid(int[][] grid) {
        var first = grid[0][0];
        if (first != 0) {
            return false;
        }

        Deque<Pair> stack = new LinkedList<>();
        int counter = 0;

        stack.push(new Pair(0, 0));

        while (!stack.isEmpty()) {
            var myP = stack.pop();

            int N = myP.row();
            int M = myP.column();

            var pair_1 = new Pair(N - 2, M - 1);
            var pair_2 = new Pair(N - 2, M + 1);
            var pair_3 = new Pair(N - 1, M - 2);
            var pair_4 = new Pair(N - 1, M + 2);
            var pair_5 = new Pair(N + 2, M - 1);
            var pair_6 = new Pair(N + 2, M + 1);
            var pair_7 = new Pair(N + 1, M - 2);
            var pair_8 = new Pair(N + 1, M + 2);

            if (checkBounds(grid, pair_1) && checkCounter(grid, pair_1, counter)) {
                stack.push(pair_1);
            } else if (checkBounds(grid, pair_2) && checkCounter(grid, pair_2, counter)) {
                stack.push(pair_2);
            } else if (checkBounds(grid, pair_3) && checkCounter(grid, pair_3, counter)) {
                stack.push(pair_3);
            } else if (checkBounds(grid, pair_4) && checkCounter(grid, pair_4, counter)) {
                stack.push(pair_4);
            } else if (checkBounds(grid, pair_5) && checkCounter(grid, pair_5, counter)) {
                stack.push(pair_5);
            } else if (checkBounds(grid, pair_6) && checkCounter(grid, pair_6, counter)) {
                stack.push(pair_6);
            } else if (checkBounds(grid, pair_7) && checkCounter(grid, pair_7, counter)) {
                stack.push(pair_7);
            } else if (checkBounds(grid, pair_8) && checkCounter(grid, pair_8, counter)) {
                stack.push(pair_8);
            }
            ++counter;
        }

        return grid.length * grid[0].length == counter;

    }

    private boolean checkBounds(int[][] grid, Pair pair) {
        int N = grid.length;
        int M = grid[0].length;
        return pair.row() >= 0 && pair.row() < N && pair.column() >= 0 && pair.column() < M;
    }

    private boolean checkCounter(int[][] grid, Pair pair, int counter) {
        return grid[pair.row()][pair.column()] == counter + 1;
    }
}

record Pair(int row, int column) {

}
