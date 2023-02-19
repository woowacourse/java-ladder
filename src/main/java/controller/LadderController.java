package controller;

import domain.model.Goods;
import domain.model.Ladder;
import domain.model.Player;
import domain.service.LadderGame;
import domain.service.LadderMaker;
import domain.service.PlayerMaker;
import domain.vo.Height;
import domain.vo.Name;
import domain.vo.Width;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderMaker ladderMaker;

    public LadderController(InputView inputView, OutputView outputView, LadderMaker ladderMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
    }

    public void play() {
        PlayerMaker playerMaker = new PlayerMaker(inputView.inputNames());
        List<Name> players = playerMaker.getPlayerList().stream().map(player -> {
            return new Name(player.getName());
        }).collect(Collectors.toList());
        List<Name> goodsList = inputView.inputGoods()
                .stream()
                .map(Name::new)
                .collect(Collectors.toList());
        int height = inputView.inputLadderHeight();
        Ladder ladder = ladderMaker.make(new Height(height), new Width(players.size() - 1));
        outputView.printLadderResult();
        outputView.printNames(players);
        outputView.printLadder(ladder);
        outputView.printNames(goodsList);
        LadderGame ladderGame = new LadderGame(players.size() - 1);
        outputView.printResult();
        ladderGame.playLadderGame(playerMaker.getPlayerList(), ladder);
        showTargetResult(playerMaker.getPlayerList(), goodsList);
    }


    private void showTargetResult(List<Player> players, List<Name> goodsList) {
        String input = inputView.inputTargetResult();
        if (input.equals("all")) {
            outputView.printAllTargetResult(players, goodsList);
            return;
        }
        outputView.printTargetResult(goodsList.get(makePlayerHash(players).get(input).getPosition()).get());
    }

    private HashMap<String, Player> makePlayerHash(List<Player> players) {
        HashMap<String, Player> playerHashMap = new HashMap<>();
        for (Player player : players) {
            playerHashMap.put(player.getName(), player);
        }
        return playerHashMap;
    }
}
