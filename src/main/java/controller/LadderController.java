package controller;

import domain.model.Goods;
import domain.model.Ladder;
import domain.model.Player;
import domain.model.Players;
import domain.service.LadderGame;
import domain.service.LadderMaker;
import domain.vo.Height;
import domain.vo.Name;
import domain.vo.Position;
import domain.vo.Width;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private static final String END_ORDER = "end";
    private static final String ALL_ORDER = "all";
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderMaker ladderMaker;
    private Ladder ladder;
    private Players players;
    private Goods goods;

    public LadderController(InputView inputView, OutputView outputView, LadderMaker ladderMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
    }

    public void play() {
        inputData();
        playGame();
        outputData();
    }

    private void inputData() {
        makePlayers();
        goods = makeGoods(players.size());
        int height = inputView.inputLadderHeight();
        ladder = ladderMaker.make(new Height(height), new Width(players.size() - 1));
        outputView.printResult(players.getPlayersName(), ladder);
        outputView.printNames(goods.getGoodsNames());
    }

    private void playGame() {
        LadderGame ladderGame = new LadderGame(players.size() - 1);
        ladderGame.playLadderGame(players, ladder);
    }

    private void outputData() {
        String order = inputView.inputTargetResult();
        if (order.equals(END_ORDER)) {
            return;
        }
        if (order.equals(ALL_ORDER)) {
            outputView.printResultMention();
            printAll();
            outputData();
        }
        List<Integer> playerPositionList = players.getPlayersPosition(new Name(order));
        for (int position : playerPositionList) {
            outputView.printResultMention();
            outputView.printPlayerAndItem(order, goods.getItemsWithPosition(position));
            outputData();
        }
    }

    private void printAll() {
        players.getPlayers().forEach(player -> {
            outputView.printPlayerAndItem(player.getName(), goods.getItemsWithPosition(player.getPosition()));
        });
    }

    private void makePlayers() {
        List<Player> playersList = new ArrayList<>();
        List<String> playersName = inputView.inputNames();
        for (int i = 0; i < playersName.size(); i++) {
            playersList.add(new Player(new Name(playersName.get(i)), new Position(i)));
        }
        players = new Players(playersList);
    }

    private Goods makeGoods(int nameCount) {
        return new Goods(inputView.inputGoods().
                stream().
                map(item -> new Name(item)).
                collect(Collectors.toList()),
                nameCount);
    }
}