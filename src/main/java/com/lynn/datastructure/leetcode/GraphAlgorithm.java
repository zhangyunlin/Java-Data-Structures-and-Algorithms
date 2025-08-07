package com.lynn.datastructure.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class GraphAlgorithm {


    /**
     * 把相连的元素进行分组
     * 输入一个二维数组，数组元素之间如果相连就作为一个分组，判断这个二位数组有几个分组
     */
    public static void main(String[] args) {
        System.out.println(mergeGroups(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(mergeGroups(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    //DFS algorithm, o(n^2) time, o(n) space
    private static int getGroupsDfs(int[][] ints) {
        int length = ints.length;
        boolean[] visited = new boolean[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                dfs(i, length, visited, ints);
                count++;
            }
        }

        return count;
    }

    private static void dfs(int i, int length, boolean[] visited, int[][] ints) {
        for (int j = 0; j < length; j++) {
            if (ints[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(i, length, visited, ints);
            }
        }
    }

    //BFS algorithm, o(n) time, o(n) space
    public static int getGroupsBfs(int[][] ints) {
        int length = ints.length;
        boolean[] visited = new boolean[length];
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty() ) {
                    Integer poll = queue.poll();
                    visited[poll] = true;
                    for (int j = 0; j < length; j++) {
                        if (ints[i][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }

                count ++;
            }
        }
        return 0;
    }

    //并查集，将相连数据作为一个树，数出二维数组中的树数量，就是分组数
    public static int mergeGroups(int[][] groups) {
        int length = groups.length;
        int[] heads = new int[length];
        int[] level = new int[length];
        for (int i = 0; i < length; i++) {
            heads[i] = i;
            level[i] = 1;

        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (groups[i][j] == 1){
                    merge(i, j ,level, heads);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (heads[i] == i){
                count ++;
            }
        }
        return count;
    }

    static void merge(int x, int y, int[] level, int[] heads){
        int i = find(x, heads);
        int j = find(y, heads);
        if (i == j){
            return;
        }
        if (level[i] < level[j]){
            heads[i] = j;
        }else {
            heads[j] = i;
        }
        if (level[i] == level[j]){
            level[i] ++;
            level[j] ++;
        }
    }

    private static int find(int y, int[] heads) {
        if (heads[y] == y){
            return y;
        }
        heads[y] = find(y, heads);
        return heads[y];
    }


}
