package com.ohgiraffers.section03.greedy;

/*
* 설탕 배달 문제
* 매 단계마다 즉각적으로 최적이라고 생각되는 선택을 반복해서
* 전체 문제의 해답(최소 봉지의 수)를 구하는 문항
* */
public class A_SugarDelivery {

    public static int solution(int n) {

        int count = 0;
//        int sum = -1;

        while(true) {
            if(n % 5 == 0) {
                return n / 5 + count;
            } else if(n < 0) {
                return -1;
            } else if (n == 0) {
                return count;
            }
            n = n -3;
            count++;
        }

//        for (int i = n/5; i > 0; i--) {
//            int rest = n - (i * 5);
//                if (rest % 3 == 0) {
//                    int j = rest / 3;
//                    sum = i + j;
//            }
//        }
//        System.out.println("봉지 수 : " + sum);
//        return sum;
    }
}
