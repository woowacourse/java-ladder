package controller;

import domain.model.Goods;
import domain.model.Ladder;
import domain.model.Player;
import domain.model.Players;
import domain.service.LadderGame;
import domain.service.LadderMaker;
import domain.service.RandomBooleanGenerator;
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
    private static final int WIDTH_PLAYERS_DIFFERENCE = 1;

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Players players = makePlayers();
        Goods goods = makeGoods(players.size());
        LadderMaker ladderMaker = new LadderMaker(new RandomBooleanGenerator());
        Ladder ladder = ladderMaker.make(new Height(inputView.inputLadderHeight()), new Width(players.size() - WIDTH_PLAYERS_DIFFERENCE));
        outputView.printResult(players.getPlayersName(), ladder);
        outputView.printNames(goods.getGoodsNames());
        playGame(players, ladder);
        outputData(players, goods);
    }

    private void playGame(Players players, Ladder ladder) {
        LadderGame ladderGame = new LadderGame(ladder, players);
        ladderGame.playLadderGame();
    }

    private void outputData(Players players, Goods goods) {
        Order order = new Order(inputView.inputTargetResult(), players.getPlayersName());
        if (order.isEnd()) {
            return;
        }
        if (order.isAll()) {
            printAll(players, goods);
            return;
        }
        printOnePlayer(players, goods, order);
    }

    private void printAll(Players players, Goods goods) {
        outputView.printResultMention();
        players.getPlayers().forEach(player -> {
            outputView.printPlayerAndItem(player.getName(), goods.getItemsWithPosition(player.getPosition()));
        });
        outputData(players, goods);
    }

    private void printOnePlayer(Players players, Goods goods, Order order) {
        List<Integer> playerPositionList = players.getPlayersPosition(new Name(order.getValue()));
        outputView.printResultMention();
        for (int position : playerPositionList) {
            outputView.printPlayerAndItem(order.getValue(), goods.getItemsWithPosition(position));
        }
        outputData(players, goods);
    }

    private Players makePlayers() {
        List<Player> playersList = new ArrayList<>();
        List<String> playersName = inputView.inputNames();
        for (int i = 0; i < playersName.size(); i++) {
            playersList.add(new Player(new Name(playersName.get(i)), new Position(i)));
        }
        return new Players(playersList);
    }

    private Goods makeGoods(int nameCount) {
        return new Goods(inputView.inputGoods().
                stream().
                map(Name::new).
                collect(Collectors.toList()),
                nameCount);
    }
}