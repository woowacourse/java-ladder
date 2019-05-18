package com.woowacourse.laddergame;

import com.woowacourse.laddergame.domain.dto.LadderDto;
import com.woowacourse.laddergame.domain.dto.LadderGameResultDto;
import com.woowacourse.laddergame.domain.dto.ResultNameDto;
import com.woowacourse.laddergame.service.LadderGameService;
import com.woowacourse.laddergame.view.InputView;
import com.woowacourse.laddergame.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGameResultDto ladderGameResultDto = requestLadderGame();
        OutputView.printLadderStatus(ladderGameResultDto);

        while (true) {
            ResultNameDto resultNameDto = new ResultNameDto();
            InputView.inputResultName(resultNameDto);
            OutputView.printLadderGameResult(resultNameDto.getName(), ladderGameResultDto);
        }
    }

    private static LadderGameResultDto requestLadderGame() {
        LadderDto ladderDto = new LadderDto();
        InputView.inputPlayerNames(ladderDto);
        InputView.inputHeight(ladderDto);
        InputView.inputGameResult(ladderDto);

        LadderGameService ladderGameService = new LadderGameService();
        ladderGameService.request(ladderDto);

        return ladderGameService.request(ladderDto);
    }

}
