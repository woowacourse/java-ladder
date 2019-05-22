package com.woowacourse.laddergame.service;

import com.woowacourse.laddergame.domain.*;
import com.woowacourse.laddergame.domain.dto.LadderDto;
import com.woowacourse.laddergame.domain.dto.LadderGameDto;
import com.woowacourse.laddergame.domain.vo.*;
import com.woowacourse.laddergame.util.NaturalNumber;

import java.util.ArrayList;
import java.util.List;

public class LadderGameService {
    public static LadderGameDto request(LadderDto ladderDto) {
        MadeLadderVo madeLadderVo = madeLadder(ladderDto);
        LadderMatchingResultVo ladderMatchingResultVo = playLadderGame(madeLadderVo);

        LadderGameDto ladderGameDto = new LadderGameDto();
        ladderGameDto.setMadeLadderVO(madeLadderVo);
        ladderGameDto.setLadderMatchingResultVo(ladderMatchingResultVo);

        return ladderGameDto;
    }

    private static LadderMatchingResultVo playLadderGame(MadeLadderVo madeLadderVo) {
        LadderGame ladderGame = new LadderGame(madeLadderVo);
        return ladderGame.run();
    }

    private static MadeLadderVo madeLadder(LadderDto ladderDto) {
        Players players = createPlayers(ladderDto.getPlayerNamesVo());
        Ladder ladder = createLadder(ladderDto.getHeightVo(), ladderDto.getPlayerNamesVo());
        Results results = createResults(ladderDto.getLadderResultsVo());

        return new MadeLadderVo(players, ladder, results);
    }

    private static Players createPlayers(PlayerNamesVo playerNamesVo) {
        List<Player> players = new ArrayList<>();
        for (String name : playerNamesVo.getPlayerNames()) {
            players.add(new Player(name));
        }
        return new Players(players);
    }

    private static Ladder createLadder(HeightVo heightVo, PlayerNamesVo playerNamesVo) {
        NaturalNumber height = new NaturalNumber(heightVo.getHeight());
        NaturalNumber countOfPerson = new NaturalNumber(playerNamesVo.size());
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

        return new Ladder(height, countOfPerson, booleanGenerator);
    }

    private static Results createResults(LadderResultsVo ladderResultsVo) {
        List<Result> results = new ArrayList<>();
        for (String result : ladderResultsVo.getLadderResults()) {
            results.add(new Result(result));
        }
        return new Results(results);
    }
}

