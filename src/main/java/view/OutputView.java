package view;

import domain.LadderGameResult;
import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.Point;
import domain.player.Player;
import domain.player.Players;
import domain.product.Product;
import domain.product.Products;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OutputView {
    private static final String TOTAL_PLAYER_SEARCH = "all";
    private static final String TOTAL_RESULT_MESSAGE = "실행 결과";
    private static final String NOT_HAVE_PLAYER = "[ERROR] 입력하신 플레이어는 없습니다.";
    private static final String COLON = " : ";
    private static final String BLANK = " ";
    private static final String BAR = "|";

    public void printResult(Players players, Ladder ladder, Products products) {
        players.getPlayers().forEach(name ->
                System.out.printf("%" + players.getMaxPlayerNameLength() + "s ", name.getPlayerName()));
        System.out.println();
        ladder.getLines().forEach(line -> System.out.println(changeFormat(line, players.getMaxPlayerNameLength())));
        products.getProducts().forEach(product ->
                System.out.printf("%" + players.getMaxPlayerNameLength() + "s ", product.getProduct()));
        System.out.println();
    }

    private String changeFormat(Line line, int maxPlayerNameLength) {
        List<Point> points = line.getPoints();
        StringBuilder ladderLine = new StringBuilder(BLANK.repeat(maxPlayerNameLength - 1) + BAR);
        for (Point point : points) {
            ladderLine.append(tranceFrom(maxPlayerNameLength, point));
        }
        return ladderLine.toString();
    }

    public String tranceFrom(int maxPlayerNameLength, Point isExist) {
        return Way.tranceFrom(isExist.isConnected()).repeat(maxPlayerNameLength) + BAR;
    }

    public void printResultOfPlayerName(String playerName, LadderGameResult ladderGameResult) {
        Map<Player, Product> totalResult = ladderGameResult.getLadderResult();
        if (playerName.equals(TOTAL_PLAYER_SEARCH)) {
            allSearch(totalResult);
        }
        if (!playerName.equals(TOTAL_PLAYER_SEARCH)) {
            searchOfPlayerName(playerName, totalResult);
        }
    }

    private void allSearch(Map<Player, Product> totalResult) {
        System.out.println(TOTAL_RESULT_MESSAGE);
        totalResult.forEach((player, product) ->
                System.out.println(player.getPlayerName() + COLON + product.getProduct()));
    }

    private void searchOfPlayerName(String playerName, Map<Player, Product> totalResult) {
        System.out.println(TOTAL_RESULT_MESSAGE);
        Optional<Player> findPlayer = totalResult.keySet().stream()
                .filter((player) -> player.getPlayerName().equals(playerName)).findFirst();
        checkPlayerName(findPlayer);
        System.out.println(totalResult.get(findPlayer.get()).getProduct());
    }

    private void checkPlayerName(Optional<Player> findPlayer) {
        if (findPlayer.isEmpty()) {
            throw new IllegalArgumentException(NOT_HAVE_PLAYER);
        }
    }
}
