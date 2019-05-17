package ladder.Controller;

import ladder.View.OutputView;
import ladder.domain.*;
import ladder.View.InputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGameManager {
    private PlayerManager playerManager;
    private List<Player> players;
    private List<Line> createdLadder;

    public LadderGameManager() {
        players = new ArrayList<>();
        createdLadder = new ArrayList<>();
    }

    public void start() {
        InputModel inputModel = new InputModel();
        List<String> names = inputModel.getValidNames(InputView.getNames());

        int ladderHeight = inputModel.getValidLadderHeight(InputView.getLadderHeight());
        Ladder ladder = new Ladder(names.size(), ladderHeight);
        createdLadder = ladder.getLadder();

        playerManager = new PlayerManager(names,createdLadder.get(0));
        players = playerManager.getPlayers();


        //LadderMove();
        output();
        LadderMove(ladderHeight, names);
    }

    private void LadderMove(int ladderHeight, List<String> names) {
        for (int i =0; i<players.size(); i++) {
            for (int k=0; k<ladderHeight; k++) {
                for (int j = 0; j < createdLadder.size(); j++) {
                    players.get(i).move(createdLadder.get(j));
                    if(k == ladderHeight -1) continue;
                    players = playerManager.createPlayers(names, createdLadder.get(k + 1));
                }
            }
            System.out.println(players.get(i).getPosition());
        }

//        for(int i =0; i<players.size(); i++) {
//            System.out.println(players.get(i).getName()+"//"+players.get(i).getPosition());
//        }
    }

    private void output() {
        OutputView.printLadderResult(players);
        for ( Line line : createdLadder) {
            OutputView.printLadder(line);
        }
    }
}
