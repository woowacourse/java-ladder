package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Result;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private Ladder ladder;
    private List<Player> players = new ArrayList<>();
    private List<String> rewards;

    public LadderGame() {
        List<String> names = InputView.getNames();
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), i));
        }
        rewards = InputView.getRewards(players);
        int height = InputView.getHeight();
        ladder = new Ladder(players.size(), height);
    }

    public void play() {
        printGame();
        ladder.goDown(players);
        Result result = new Result(players, rewards);
        String name;
        while(!(name = InputView.getName(players)).equals("all")){
            printResult(name, result);
        }
        printResultAll(result);
    }


}
