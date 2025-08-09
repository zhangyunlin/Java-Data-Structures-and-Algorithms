package com.lynn.datastructure.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class VoteGame {
    public static void main(String[] args) {
        System.out.println(voteGame("RDDRR"));
    }

    public static String voteGame(String str){
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'R') {
                r.offer(i);
            }else if (str.charAt(i) == 'D') {
                d.offer(i);
            }

            while (!r.isEmpty() && !d.isEmpty()) {
                int r1 = r.poll();
                int d1 = d.poll();
                if (r1 < d1) {
                    // to the second round
                    r.offer(r1+str.length());
                }else{
                    d.offer(d1+str.length());
                }
            }
        }

        return d.isEmpty() ? "R" : "D";
    }


}
