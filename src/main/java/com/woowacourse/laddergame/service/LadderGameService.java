package com.woowacourse.laddergame.service;

import com.woowacourse.laddergame.domain.*;
import com.woowacourse.laddergame.domain.dto.LadderDto;
import com.woowacourse.laddergame.domain.dto.LadderGameResultDto;
import com.woowacourse.laddergame.domain.vo.*;
import com.woowacourse.laddergame.util.NaturalNumber;

public class LadderGameService {
    public LadderGameResultDto request(LadderDto ladderDto) {
        Players players = createPlayers(ladderDto.getPlayerNamesVo());
        Results results = createResults(ladderDto.getLadderResultsVo());
        Ladder ladder = createLadder(ladderDto.getHeightVo(), ladderDto.getPlayerNamesVo());

        LadderGameResultDto ladderGameResultDto = new LadderGameResultDto();
        ladderGameResultDto.setMadeLadderVO(new MadeLadderVO(players, ladder, results));
        ladderGameResultDto.setLadderGameResultVo(playLadderGame(players, ladder, results));

        return ladderGameResultDto;
    }

    private LadderGameResultVo playLadderGame(Players players, Ladder ladder, Results results) {
        LadderGame ladderGame = new LadderGame(players, ladder, results);
        return ladderGame.run();
    }

    private Ladder createLadder(HeightVo heightVo, PlayerNamesVo playerNamesVo) {
        NaturalNumber height = new NaturalNumber(heightVo.getHeight());
        NaturalNumber countOfPerson = new NaturalNumber(playerNamesVo.size());
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

        return LadderGenerator.generateLadder(height, countOfPerson, booleanGenerator);
    }

    private Players createPlayers(PlayerNamesVo playerNamesVo) {
        Players players = new Players();
        for (String name : playerNamesVo.getPlayerNames()) {
            players.add(new Player(name));
        }
        return players;
    }

    private Results createResults(LadderResultsVo ladderResultsVo) {
        Results results = new Results();
        for (String result : ladderResultsVo.getLadderResults()) {
            results.add(new Result(result));
        }
        return results;
    }
}

