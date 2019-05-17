package ladder;

import ladder.DTO.LadderGameDTO;
import ladder.domain.LadderMaker;
import ladder.domain.LadderResult;
import ladder.domain.Line;
import ladder.domain.ResultMaker;
import ladder.util.OutputHelper;
import ladder.validator.InputValidator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGame {
    private static LadderGameDTO ladderGameDTO = new LadderGameDTO();

    public static void main(String[] args) {
        receiveInput();
        ladderGameDTO.setAllResult(ResultMaker.generateResultAll(ladderGameDTO.getLadder(), ladderGameDTO.getNames().size()));
        LadderResult ladderResult = new LadderResult(ladderGameDTO.getAllResult(), ladderGameDTO.getNames(), ladderGameDTO.getResultCandidate());
        printOutput();
        printResult(ladderResult);
    }


    private static void receiveInput() {
        String inputName = InputView.inputNames();
        ladderGameDTO.setNames(InputValidator.checkValidName(inputName));
        List<String> results = InputValidator.checkValidResultCandidate(ladderGameDTO.getNames(), InputView.inputResultAll(ladderGameDTO.getNames()));
        ladderGameDTO.setResultCandidate(results);
        int height = InputView.inputHeight();
        InputValidator.isLowerLimit(height);
        ladderGameDTO.setHeight(height);
        List<Line> ladder = LadderMaker.generateLadder(ladderGameDTO.getHeight(), ladderGameDTO.getNames().size());
        ladderGameDTO.setLadder(ladder);
    }

    private static void printOutput() {
        String names = OutputHelper.generateOutputText(ladderGameDTO.getNames());
        String resultCandidate = OutputHelper.generateOutputText(ladderGameDTO.getResultCandidate());
        OutputView.printLadder(ladderGameDTO.getLadder(), names, resultCandidate);
    }

    private static void printResult(LadderResult ladderResult) {
        do {
            ladderGameDTO.setRequestedName(InputView.findResultName(ladderGameDTO.getNames()));
            OutputView.printLadderResult(ladderResult.matchResult(ladderGameDTO.getRequestedName()));
        } while (!ladderGameDTO.getRequestedName().equals("all"));
    }
}