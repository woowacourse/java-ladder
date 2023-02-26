package view;

import domain.item.Item;
import domain.item.Items;
import domain.ladder.Bridge;
import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladderGame.GameInit;
import domain.ladderGame.GameResult;
import domain.player.Name;
import domain.player.Players;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputView {

    private static final String INIT_RESULT_SHOW_MESSAGE = "\n사다리 결과";
    private static final String GAME_RESULT_SHOW_MESSAGE = "\n실행 결과;";
    private static final String BRIDGE_TRUE = "-----";
    private static final String BRIDGE_FALSE = "     ";
    private static final String LINE_BAR_MESSAGE = "|";
    private static final String LINE_SPACE_MESSAGE = "    ";
    private static final String PLAYER_SHOW_FORMAT = "%5s ";
    private static final String BRIDGE_SHOW_FORMAT = "%s";
    private static final String ITEM_SHOW_FORMAT = "%5s ";

    public void showInitResult(GameInit gameInit) {
        showInitResultMessage();
        showPlayers(gameInit.getPlayers());
        showLadder(gameInit.getLadder());
        showItems(gameInit.getItems());
        System.out.println();
    }

    public void showAllResult(GameResult gameResult) {
        System.out.println(GAME_RESULT_SHOW_MESSAGE);
        LinkedHashMap<String, String> results = gameResult.getResults();
        results.forEach((target, result) -> printTargetResult(target, result));
    }

    public void showTargetResult(String target, GameResult gameResult) {
        if (target.equals("all"))
            return;
        System.out.println(GAME_RESULT_SHOW_MESSAGE);
        LinkedHashMap<String, String> results = gameResult.getResults();
        printTargetResult(target, results.get(target));
    }

    private void showInitResultMessage() {
        System.out.println(INIT_RESULT_SHOW_MESSAGE);
    }

    private void showPlayers(Players players) {
        List<Name> playersName = players.getPlayersName();
        for (Name playerName : playersName) {
            printMessageInFormat(playerName.getName(), PLAYER_SHOW_FORMAT);
        }
        System.out.println();
    }

    private void showLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            List<Bridge> bridges = line.getBridges();
            showBridges(bridges);
            System.out.println();
        }
    }

    private void showItems(Items items) {
        for (Item item : items.getItems()) {
            printMessageInFormat(item.getItem(), ITEM_SHOW_FORMAT);
        }
    }

    private void showBridges(List<Bridge> bridges) {
        System.out.printf(LINE_SPACE_MESSAGE + LINE_BAR_MESSAGE);
        for (Bridge bridge : bridges) {
            printMessageInFormat(draw(bridge) + LINE_BAR_MESSAGE, BRIDGE_SHOW_FORMAT);
        }
    }

    private void printMessageInFormat(String playerName, String format) {
        System.out.printf(format, playerName);
    }

    private String draw(Bridge bridge) {
        if (bridge.isPassable()) {
            return BRIDGE_TRUE;
        }
        return BRIDGE_FALSE;
    }

    private void printTargetResult(String target, String result) {
        System.out.println(target + " : " + result);
    }
}
