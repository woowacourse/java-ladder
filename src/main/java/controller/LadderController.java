package controller;

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
    private static final String NOT_PLAYER_MASSAGE = "없는 참가자입니다.";
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
        List<Name> players = makePlayers(playerMaker);
        List<Name> goodsList = makeGoodsList();
        notSameCount(players, goodsList);
        int height = inputView.inputLadderHeight();
        Ladder ladder = ladderMaker.make(new Height(height), new Width(players.size() - 1));
        outputView.printLadderResult();
        outputView.printNames(players);
        outputView.printLadder(ladder);
        outputView.printNames(goodsList);
        LadderGame ladderGame = new LadderGame(players.size() - 1);
        ladderGame.playLadderGame(playerMaker.getPlayerList(), ladder);
        showTargetResult(playerMaker.getPlayerList(), goodsList);
    }

    private List<Name> makePlayers(PlayerMaker playerMaker) {
        return playerMaker.getPlayerList().stream().map(player -> {
            return new Name(player.getName());
        }).collect(Collectors.toList());
    }

    private List<Name> makeGoodsList() {
        return inputView.inputGoods()
                .stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private void notSameCount(List<Name> players, List<Name> goods) {
        if (players.size() != goods.size()) {
            throw new IllegalArgumentException("참가자 수와 상품 수는 같아야 합니다.");
        }
    }

    private void showTargetResult(List<Player> players, List<Name> goodsList) {
        String input = inputView.inputTargetResult();
        if (input.equals("end")) {
            return;
        }
        outputView.printResult();
        if (input.equals("all")) {
            outputView.printAllTargetResult(players, goodsList);
            showTargetResult(players, goodsList);
            return;
        }
        validateNotInPlayers(players, input);
        outputView.printTargetResult(goodsList.get(makePlayerHash(players).get(input).getPosition()).get());
        showTargetResult(players, goodsList);
    }

    private void validateNotInPlayers(List<Player> players, String target) {
        if (notHasTarget(players, target)) {
            throw new NullPointerException(NOT_PLAYER_MASSAGE);
        }
    }

    private Boolean notHasTarget(List<Player> players, String target) {
        return !players.stream().map(player -> player.getName()).collect(Collectors.toList()).contains(target);
    }

    private HashMap<String, Player> makePlayerHash(List<Player> players) {
        HashMap<String, Player> playerHashMap = new HashMap<>();
        for (Player player : players) {
            playerHashMap.put(player.getName(), player);
        }
        return playerHashMap;
    }
}
