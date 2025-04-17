package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static com.ohgiraffers.section02.searching.B_BFS2.bfs;

public class C_ShortestPath {
    /*
    * BFS는 먼저 방문한 노드를 기준으로 가장 가까운 노드부터 탐색한다.
    * 즉, 시작저메엇 출발하여 거리 1짜리 노드를 모두 방문한 후,
    * 저길 2짜리 노드를 방문하는 방식으로 진행된다.
    * 따라서 어떤 노드에 도달했을 때, 처음 도달한 순간이 곧 최단거리가 됩니다.
    * DFS는 한 방향을로 깊게 들어간 후, 막다른 길에 도달하면 다시 되돌아오므로
    * 최단 경로가 아닌 먼 길을 돌아 도착하는 경우도 생길 수 있다.
    * */
    // 미로 크기
    static int M, N, K;
    // 미로
    static int [][] map;
    // 미로 길 찾기를 할 때 방문했는지 여부 확인
    static boolean[][] visit;
    // 미로를 몇번만에 통과했는지 count
    static int count;
    // 상하좌우 개념의 좌표
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    // x와 y 좌표를 가지고 Node 클래스
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
    // BFS로 문제 해결을 위한 Queue
    static Queue<Node> q = new LinkedList<>();

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visit = new boolean[M][N];



        // 미로 출력 확인
        System.out.println("미로 : ");
        for(int i = 0; i < M; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < ch.length; j++) {
                map[i][j] = Character.getNumericValue(ch[j]);
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        /* 시작점 설정해주기((0, 0)에서 출발)*/
        bfs(0, 0);

        /* 도착지의 값을 반환 (도착 할 때까지의 최적의 경로 단계 수) */
        return map[M - 1][N - 1];
    }

    static void bfs(int x, int y) {
        visit[x][y] = true;
        q.add(new Node(x, y));
        /* 시작 지점에서부터 큐를 이용해서 큐에 담기는 노드가 제거 될 때 까지
        * 너비 우선 탐색을 진행한다.
        * */
        while(!q.isEmpty()) {
            /* 현재 탐색을 진행할 노드 */
            Node node = q.poll();
            for(int i = 0; i < 4; i++) {
                int cx = node.x + dirX[i];
                int cy = node.y + dirY[i];

                /* map을 넘어가면 확인이 필요없으므로 다음 방향 확인 */
                if(cx < 0 || cx >= M || cy < 0 || cy >= N) continue;

                /* 방문했던 좌표이거나 벽이면 확인이 불필요하므로 다음 방향 확인 */
                if(visit[cx][cy] || map[cx][cy] == 0) continue;

                q.offer(new Node(cx, cy));
                visit[cx][cy] = true;
                map[cx][cy] = map[node.x][node.y] + 1;

                /* 디버깅용 출력 */
                System.out.println("cx = " + cx + ", cy = " + cy);
                System.out.println("map[cx][cy] = " + map[cx][cy]);
            }
        }

    }
}
