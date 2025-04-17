package com.ohgiraffers.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class C_MeetingRoomScheduler {
    /*
    * 그리드 핵심
    * 1. 끝나는 시간이 빠른 회의 먼저
    * 2. 끝나는 시간이 같다면, 시작 시간이 빠른 회의 먼저
    * */

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int N = Integer.parseInt(br.readLine());  // 회의 개수
        int[][] time = new int[N][2];  // 앞은 회의 개수, 2는 시작과 종료
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // 시작시간과 종류시간 나눠서
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }
        /* 기본적인 조건은 종료시간이 빠른 회의 순서로 데이터 정렬 (람다 사용)
        * 종료시간 기준으로 정렬 이유 : 회의를 빨리 끝내야 다음 회의를 더 많이 넣을 수 있기 때문
        * */
        Arrays.sort(time, (t1, t2) -> {
            if(t1[1] == t2[1]) return t1[0] - t2[0];
            return t1[1] - t2[1];
        });
        int endTime = 0;                // 직전 회의가 끝난 시간을 담아둘 변수
        int count = 0;                  // 회의가 배정된 개수

        /* time 배열 안에 있는 회의를 반복하며 회의 시간표에 넣을지 확인
        * 만약 회의 시작시간이 이전 회의가 끝난 시ㅏㄴ보다 늦거나 같으면, 넣고 겹치는 회의는 넣지 않는다.
        * */
        for (int i = 0; i < N; i++) {
            if(time[i][0] >= endTime) {
                count++;
                endTime = time[i][1];   // 이후 회의 확인을 위해 종료 시간 수정
            }
        }
        return count;
    }
}
