package com.woowacourse.laddergame;

import com.woowacourse.laddergame.domain.dto.LadderDto;
import com.woowacourse.laddergame.domain.dto.LadderGameDto;
import com.woowacourse.laddergame.domain.vo.ResultNameVo;
import com.woowacourse.laddergame.service.LadderGameService;
import com.woowacourse.laddergame.view.InputView;
import com.woowacourse.laddergame.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGameDto ladderGameDto = requestLadderGame(createLadderGameDto());
        OutputView.printLadderStatus(ladderGameDto);
        inputResult(ladderGameDto);
    }

    private static LadderDto createLadderGameDto() {
        return new LadderDto(InputView.inputPlayerNames(), InputView.inputHeight(), InputView.inputGameResult());
    }

    private static LadderGameDto requestLadderGame(LadderDto ladderDto) {
        return LadderGameService.request(ladderDto);
    }

    private static void inputResult(LadderGameDto ladderGameDto) {
        try {
            ResultNameVo resultNameVo = InputView.inputResultName();
            OutputView.printLadderGameResult(resultNameVo.getName(), ladderGameDto);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
