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
    private static final int WIDTH_PLAYERS_DIFFERENCE = 1;
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderMaker ladderMaker;

    public LadderController(InputView inputView, OutputView outputView, LadderMaker ladderMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
    }

    public void play() {
        Request inputRequest = inputData();
        Request gameRequest = playGame(inputRequest);
        outputData(gameRequest);
    }

    private Request inputData() {
        Players players = makePlayers();
        Goods goods = makeGoods(players.size());
        int height = inputView.inputLadderHeight();
        Ladder ladder = ladderMaker.make(new Height(height), new Width(players.size() - WIDTH_PLAYERS_DIFFERENCE));
        outputView.printResult(players.getPlayersName(), ladder);
        outputView.printNames(goods.getGoodsNames());
        return new Request(players, goods, ladder);
    }

    private Request playGame(Request request) {
        LadderGame ladderGame = new LadderGame(request.getLadder().getLineCountInt());
        ladderGame.playLadderGame(request.getPlayers(), request.getLadder());
        return new Request(ladderGame.getPlayers(), request.getGoods());
    }

    private void outputData(Request request) {
        Order order = new Order(inputView.inputTargetResult(), request.getPlayers().getPlayersName());
        if (order.isEnd()) {
            return;
        }
        if (order.isAll()) {
            printAll(request);
            return;
        }
        printOnePlayer(request, order);
    }

    private void printOnePlayer(Request request, Order order) {
        List<Integer> playerPositionList = request.getPlayers().getPlayersPosition(new Name(order.getValue()));
        outputView.printResultMention();
        for (int position : playerPositionList) {
            outputView.printPlayerAndItem(order.getValue(), request.getGoods().getItemsWithPosition(position));
        }
        outputData(request);
    }


    private void printAll(Request request) {
        outputView.printResultMention();
        request.getPlayers().getPlayers().forEach(player -> {
            outputView.printPlayerAndItem(player.getName(), request.getGoods().getItemsWithPosition(player.getPosition()));
        });
        outputData(request);
    }

    private Players makePlayers() {
        List<Player> playersList = new ArrayList<>();
        List<String> playersName = inputView.inputNames();
        for (int i = 0; i < playersName.size(); i++) {
            playersList.add(new Player(new Name(playersName.get(i)), new Position(i)));
        }
        Players players = new Players(playersList);
        return players;
    }

    private Goods makeGoods(int nameCount) {
        return new Goods(inputView.inputGoods().
                stream().
                map(item -> new Name(item)).
                collect(Collectors.toList()),
                nameCount);
    }
}