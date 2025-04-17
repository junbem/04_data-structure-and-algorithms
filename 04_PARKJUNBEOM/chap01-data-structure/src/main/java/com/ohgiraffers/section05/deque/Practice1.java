package com.ohgiraffers.section05.deque;

import java.util.*;

public class Practice1 {

    static class Balloon {
        int order;
        int noteValue;

        public Balloon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }
    }

    public String solution(Integer[] notes) {
        Deque<Balloon> deque = new ArrayDeque<>();

        // 1. 모든 풍선을 덱에 추가 (1번부터 시작)
        for (int i = 0; i < notes.length; i++) {
            deque.addLast(new Balloon(i + 1, notes[i]));
        }

        List<Integer> result = new ArrayList<>();

        // 2. 첫 풍선 터뜨리기
        Balloon current = deque.pollFirst();
        result.add(current.order);
        int move = current.noteValue;

        // 3. 풍선이 빌 때까지 반복
        while (!deque.isEmpty()) {
            // 4. 이동
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());  // 오른쪽으로 회전
                }
                current = deque.pollFirst();  // 다음 풍선 터뜨림
            } else {
                for (int i = 0; i < Math.abs(move) - 1; i++) {
                    deque.addFirst(deque.pollLast());  // 왼쪽으로 회전
                }
                current = deque.pollLast();  // 다음 풍선 터뜨림
            }

            result.add(current.order);
            move = current.noteValue;
        }

        // 5. 결과 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }

        return sb.toString().trim();
    }
}
