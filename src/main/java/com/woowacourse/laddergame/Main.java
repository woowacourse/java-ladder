package com.woowacourse.laddergame;

import com.woowacourse.laddergame.domain.vo.LadderGameResultVO;
import com.woowacourse.laddergame.domain.vo.LadderStatusVO;
import com.woowacourse.laddergame.domain.vo.LadderVO;
import com.woowacourse.laddergame.domain.vo.ResultNameVO;
import com.woowacourse.laddergame.service.LadderGameService;
import com.woowacourse.laddergame.view.InputView;
import com.woowacourse.laddergame.view.OutputView;

public class Main {
    public static void main(String[] args) {
        // view 호출
        LadderVO ladderVO = new LadderVO();
        InputView.inputPlayerNames(ladderVO);
        InputView.inputHeight(ladderVO);
        InputView.inputGameResult(ladderVO);

        // GameService 인자로 넘긴다 - 사다리 vo 반환
        LadderGameService ladderGameService = new LadderGameService();
        ladderGameService.drawLadder(ladderVO);

        LadderStatusVO ladderStatusVO = ladderGameService.getInitialLadder();
        OutputView.printLadderStatus(ladderStatusVO);

        while (true) {
            ResultNameVO resultNameVO = new ResultNameVO();
            resultNameVO = InputView.inputResultName(resultNameVO);

            // TODO all 체크
            //checkTakeLadder(resultNameVO);
            LadderGameResultVO ladderGameResultVO = ladderGameService.playLadder(resultNameVO);
            OutputView.printLadderGameResult(ladderGameResultVO);
        }
    }

    // TODO
    private static void checkTakeLadder(ResultNameVO resultNameVO) {
        if (resultNameVO.getName().equals("all")) {
        }
    }
}
