package com.lynn.datastructure.leetcode;

/**
 * 井字游戏,五子棋游戏
 */
public class WellGame {
    public static void main(String[] args) {


    }

    public static boolean wellGame(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') {
                    xCount++;
                } else if (c == 'O') {
                    oCount ++;
                }
            }
        }

        if (xCount != oCount && xCount - oCount != 1) {
            return false;
        }

        if (win(board, "XXX") && xCount - oCount == 1) {
            return false;
        }

        if (win(board, "OOO") && oCount - xCount == 1) {
            return false;
        }

        return true;


    }

    static boolean win(String[] board, String flag) {
        for (int i = 0; i < board.length; i++) {
            if(flag.equals(""+board[0].charAt(i)+board[1].charAt(i)+board[2].charAt(i))) {
                return true;
            }
            if (flag.equals(""+board[0].charAt(0)+board[1].charAt(1)+board[2].charAt(2))) {
                return true;
            }
            if (flag.equals(""+board[0].charAt(2)+board[1].charAt(1)+board[2].charAt(0))) {
                return true;
            }
        }
        return false;
    }

}

