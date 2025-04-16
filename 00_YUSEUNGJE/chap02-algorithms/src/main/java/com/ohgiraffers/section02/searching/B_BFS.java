package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 너비 우선 탐색(Breadth-First Search)
* 선입 선출 구조의 queue를 활용한다.
* 시작 노드에서 출발해서 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다.
* */
public class B_BFS {


    /* 배추 밭에 필요한 배추 지렁이 갯수 구하는 문제
    *  (x, y좌표를 활용한 탐색 문제를 해결할 수 있다.)
    * */
    // 배추밭의 크기(가로, 세로)와 배추 개수
    static int M, N, K;
    // 배추밭
    static int[][] map;
    // 배추 찾기를 할 때 방문 했는지 여부를 확인할 배열
    static boolean[][] visit;
    // 지렁이의 개수
    static int count;
    // 상하좌우 개념의 좌표 배열
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    // x와 y 좌표를 가지는 Node클래스
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 현재 좌표
    static int cx, cy;
    // BFS로 문제를 해결하기 위한 Queue
    static Queue<Node> q = new LinkedList<>();

    public static int solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visit = new boolean[M][N];

        return count;
    }
}
