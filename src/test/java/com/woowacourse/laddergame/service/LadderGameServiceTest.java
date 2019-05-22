package com.woowacourse.laddergame.service;

import com.woowacourse.laddergame.domain.*;
import com.woowacourse.laddergame.domain.dto.LadderDto;
import com.woowacourse.laddergame.domain.dto.LadderGameDto;
import com.woowacourse.laddergame.domain.vo.*;
import com.woowacourse.laddergame.util.NaturalNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

class LadderGameServiceTest {
    @Test
    void 사다리_통합테스트_커스텀() {
        LadderDto ladderDto = new LadderDto(new PlayerNamesVo("pobi,honux,tim,crong"), new HeightVo("3"), new LadderResultsVo("꽝,꽝,꽝,300원"));

        // 사용자 입력
        Players players = new Players(Arrays.asList(
                new Player("pobi"),
                new Player("honux"),
                new Player("tim"),
                new Player("crong")
        ));

        Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
        ladder.putBridge(new NaturalNumber(1), new NaturalNumber(1));
        ladder.putBridge(new NaturalNumber(1), new NaturalNumber(3));
        ladder.putBridge(new NaturalNumber(2), new NaturalNumber(2));
        ladder.putBridge(new NaturalNumber(3), new NaturalNumber(3));

        Results results = new Results(Arrays.asList(
                new Result("꽝"),
                new Result("꽝"),
                new Result("꽝"),
                new Result("300원")
        ));

        HashMap<Player, Result> winners = new HashMap<>();
        winners.put(new Player("pobi"), new Result("300원"));
        winners.put(new Player("honux"), new Result("꽝"));
        winners.put(new Player("tim"), new Result("꽝"));
        winners.put(new Player("crong"), new Result("꽝"));

        MadeLadderVo madeLadderVO = new MadeLadderVo(players, ladder, results);
        LadderMatchingResultVo ladderMatchingResultVo = new LadderMatchingResultVo(winners);
        LadderGameDto expectedLadderResultDto = new LadderGameDto();
        expectedLadderResultDto.setMadeLadderVO(madeLadderVO);
        expectedLadderResultDto.setLadderMatchingResultVo(ladderMatchingResultVo);

        LadderGameDto actualLadderResultDto = LadderGameService.request(ladderDto);

        System.out.println(actualLadderResultDto.getMadeLadderVO());
        System.out.println(actualLadderResultDto.getLadderMatchingResultVo());
    }
}