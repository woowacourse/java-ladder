package view;

import model.Name;
import model.Player;
import model.Players;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final int STARTING_INDEX_OF_RIGHT_FORMATTING = 1;
    private static final String PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public void printPlayerNamesMessage() {
        System.out.println(PLAYER_NAME_MESSAGE);
    }

    public void printLadderHeightMessage() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
    }

    public void printAllPlayerNames(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(makeLeftFormattingFirstName(players));
        stringBuilder.append(makeRightFormattingNamesFromSecond(players));
        System.out.println(stringBuilder);
    }

    private String makeLeftFormattingFirstName(Players players) {
        Name firstPlayerName = players.getPlayer(0).getName();
        return String.format("%-5s ", firstPlayerName.getName());
    }

    private String makeRightFormattingNamesFromSecond(Players players) {
        return IntStream.range(STARTING_INDEX_OF_RIGHT_FORMATTING, players.size())
                .mapToObj(players::getPlayer)
                .map(Player::getName)
                .map(name -> String.format("%5s", name.getName()))
                .collect(Collectors.joining(" "));
    }
}
