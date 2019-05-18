package com.woowacourse.laddergame.service;

import com.woowacourse.laddergame.domain.*;
import com.woowacourse.laddergame.domain.dto.LadderDto;
import com.woowacourse.laddergame.domain.dto.LadderGameResultDto;
import com.woowacourse.laddergame.domain.vo.*;
import com.woowacourse.laddergame.util.NaturalNumber;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class LadderGameServiceTest {
    @Test
    void 사다리_통합테스트_커스텀() {
        LadderDto ladderDto = new LadderDto();
        ladderDto.setPlayerNamesVo(new PlayerNamesVo("pobi,honux,tim,crong"));
        ladderDto.setHeightVo(new HeightVo("3"));
        ladderDto.setLadderResultsVo(new LadderResultsVo("꽝,꽝,꽝,300원"));

        // 사용자 입력
        Players players = new Players();
        players.add(new Player("pobi"));
        players.add(new Player("honux"));
        players.add(new Player("tim"));
        players.add(new Player("crong"));

        Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
        ladder.putBridge(new NaturalNumber(1), new NaturalNumber(1));
        ladder.putBridge(new NaturalNumber(1), new NaturalNumber(3));
        ladder.putBridge(new NaturalNumber(2), new NaturalNumber(2));
        ladder.putBridge(new NaturalNumber(3), new NaturalNumber(3));

        Results results = new Results();
        results.add(new Result("꽝"));
        results.add(new Result("꽝"));
        results.add(new Result("꽝"));
        results.add(new Result("300원"));

        HashMap<String, String> winners = new HashMap<>();
        winners.put("pobi", "300원");
        winners.put("honux", "꽝");
        winners.put("tim", "꽝");
        winners.put("crong", "꽝");

        MadeLadderVO madeLadderVO = new MadeLadderVO(players, ladder, results);
        LadderGameResultVo ladderGameResultVo = new LadderGameResultVo(winners);
        LadderGameResultDto expectedLadderResultDto = new LadderGameResultDto();
        expectedLadderResultDto.setMadeLadderVO(madeLadderVO);
        expectedLadderResultDto.setLadderGameResultVo(ladderGameResultVo);

        LadderGameService ladderGameService = new LadderGameService();
        LadderGameResultDto actualLadderResultDto = ladderGameService.request(ladderDto);

        System.out.println(actualLadderResultDto.getMadeLadderVO());
        System.out.println(actualLadderResultDto.getLadderGameResultVo());
        System.out.println(actualLadderResultDto.getMadeLadderVO());
    }
}