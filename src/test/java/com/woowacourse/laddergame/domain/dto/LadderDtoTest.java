package com.woowacourse.laddergame.domain.dto;

import com.woowacourse.laddergame.domain.vo.HeightVo;
import com.woowacourse.laddergame.domain.vo.LadderResultsVo;
import com.woowacourse.laddergame.domain.vo.PlayerNamesVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderDtoTest {
    LadderDto ladderDto;

    @BeforeEach
    void setUp() {
        ladderDto = new LadderDto();
    }

    @Test
    void Player_정상이름입력() {
        String input = "pobi,crong,honux";
        ladderDto.setPlayerNamesVo(new PlayerNamesVo(input));
        for (String name : input.split(",")) {
            assertThat(ladderDto.getPlayerNamesVo().contains(name)).isTrue();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiiii,crong,honux", "po bi,crong", "  ", ",pobi", "pobi,", "pobi, jay"})
    void Player_비정상이름입력(String input) {
        LadderDto ladderDto = new LadderDto();

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ladderDto.setPlayerNamesVo(new PlayerNamesVo(input));
        }).withMessage("Player 이름들이 잘못되었습니다");
    }

    @Test
    void Player_null입력() {
        String input = null;

        LadderDto ladderDto = new LadderDto();

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ladderDto.setPlayerNamesVo(new PlayerNamesVo(input));
        }).withMessage("Null 은 입력할 수 없습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"01", "ab", "!!", "-1", " ", "1_000"})
    void 높이_비정상값(String input) {
        LadderDto ladderDto = new LadderDto();

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ladderDto.setHeightVo(new HeightVo(input));
        }).withMessage("정상적인 사다리 높이가 아닙니다");
    }

    @Test
    void 높이_null() {
        LadderDto ladderDto = new LadderDto();

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ladderDto.setHeightVo(new HeightVo(null));
        }).withMessage("Null 은 입력할 수 없습니다");
    }

    @Test
    void 사다리_결과_비정상_입력() {
        LadderDto ladderDto = new LadderDto();

        ladderDto.setPlayerNamesVo(new PlayerNamesVo("pobi,ice,cream,crong"));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ladderDto.setLadderResultsVo(new LadderResultsVo("꽝,아이스크림,아이스크림,꽝,꽝"));
        }).withMessage("플레이어 수와 사다리 결과의 수가 다릅니다");
    }

    @Test
    void 사다리_결과_null_입력() {
        LadderDto ladderDto = new LadderDto();

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ladderDto.setLadderResultsVo(new LadderResultsVo(null));
        }).withMessage("Null 은 입력할 수 없습니다");
    }
}