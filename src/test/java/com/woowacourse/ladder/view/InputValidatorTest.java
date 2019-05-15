package com.woowacourse.ladder.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {
    @Test
    void 아무입력이_없을때() {
        assertThat(InputValidator.isValidNamesInput(Collections.singletonList(""))).isFalse();
    }

    @Test
    void 공백만입력했을때() {
        assertThat(InputValidator.isValidNamesInput(Collections.singletonList("  "))).isFalse();
    }

    @Test
    void 이름길이_초과() {
        assertThat(InputValidator.isValidNamesInput(Collections.singletonList("abcdee"))).isFalse();
    }

    @Test
    void 이름_길이_경계() {
        assertThat(InputValidator.isValidNamesInput(Collections.singletonList("abcee"))).isTrue();
    }

    @Test
    void 이름에_all을_포함() {
        assertThat(InputValidator.isValidNamesInput(Arrays.asList("all", "pobi"))).isFalse();
    }

    @Test
    void 실행결과_길이_초과() {
        assertThat(InputValidator.isValidDestinationsInput(Arrays.asList("꽝", "500000"))).isFalse();
    }

    @Test
    void 실행결과_입력이_빈_문자열을_포함() {
        assertThat(InputValidator.isValidDestinationsInput(Arrays.asList("pobi", "", "jk"))).isFalse();
    }

    @Test
    void 결과_조회_입력() {
        assertThat(InputValidator.isValidResultQuery(Collections.singletonList("pobi"))).isTrue();
    }

    @Test
    void 결과_조회_입력_all() {
        assertThat(InputValidator.isValidResultQuery(Collections.singletonList("all"))).isTrue();
    }

    @Test
    void 결과_조회_입력이_빈_문자열을_포함() {
        assertThat(InputValidator.isValidResultQuery(Arrays.asList("pobi", "", "crong"))).isFalse();
    }

    @Test
    void 결과_조회_입력_토큰_길이_초과() {
        assertThat(InputValidator.isValidResultQuery(Arrays.asList("pobi", "abcedd"))).isFalse();
    }

    @Test
    void 결과_조회_입력값이_빈_문자열() {
        assertThat(InputValidator.isValidResultQuery(Collections.singletonList(""))).isFalse();
    }
}
