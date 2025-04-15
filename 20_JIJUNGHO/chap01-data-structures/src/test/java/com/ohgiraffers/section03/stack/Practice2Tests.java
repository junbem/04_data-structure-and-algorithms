package com.ohgiraffers.section03.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/* 쇠막대기 - 백준 10799 */
/* https://www.acmicpc.net/problem/10799 */
class Practice2Tests {

    Practice2 practice2;

    @BeforeEach
    void setUp() {
        practice2 = new Practice2();
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments("()(((()())(())()))(())", "17"),
                Arguments.arguments("(((()(()()))(())()))(()())", "24")

        );
    }

    @DisplayName("쇠막대기 테스트")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("data")
    void stickTest(String input, String expected) {
        String result = practice2.solution(input);
        Assertions.assertEquals(expected, result);
    }

}