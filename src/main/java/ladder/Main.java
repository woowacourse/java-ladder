package ladder;

import ladder.domain.Floor;
import ladder.domain.LadderGame;
import ladder.domain.PlayerName;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        String inputNames = InputView.inputPlayerNamesMessage();
        String inputResults = InputView.inputResultNamesMessage();
        Floor inputfloors = InputView.inputFloorsMessage();
        
        LadderGame ladderGame = new LadderGame(inputfloors, inputNames, inputResults);
        OutputView.resultLadderTitle();
        OutputView.resultLadder(ladderGame);
        try{
            selectResult(ladderGame);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            selectResult(ladderGame);
        }
    }

    private static void selectResult(LadderGame ladderGame) {
        String select = InputView.inputSelectResultMessage();
        OutputView.resultTitle();
        while(true) {
            if(select.equals("exit")){
                break;
            }
            if (!select.equals("all")) {
                PlayerName selectName = new PlayerName(select);
                OutputView.resultPrint(ladderGame.getOnePlayerResult(selectName));
            }
            if (select.equals("all")) {
                OutputView.resultPrint(ladderGame.getAllPlayerResult());
                break;
            }
        }
    }
}
