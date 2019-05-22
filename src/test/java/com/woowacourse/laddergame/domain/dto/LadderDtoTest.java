package com.woowacourse.laddergame.domain.dto;

import com.woowacourse.laddergame.domain.vo.HeightVo;
import com.woowacourse.laddergame.domain.vo.LadderResultsVo;
import com.woowacourse.laddergame.domain.vo.PlayerNamesVo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderDtoTest {
    @Test
    void 플레이어수_결과수_다른경우_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LadderDto(
                    new PlayerNamesVo("pobi,ice,cream,crong"),
                    new HeightVo("3"),
                    new LadderResultsVo("꽝,아이스크림,아이스크림,꽝,꽝")
            );
        }).withMessage("플레이어 수와 사다리 결과의 수가 다릅니다");
    }
}