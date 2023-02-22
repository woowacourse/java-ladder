package ladder.view;

import ladder.domain.ladder.Bar;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import ladder.view.constant.LadderOutputSymbol;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static ladder.view.constant.LadderOutputSymbol.LADDER_VERTICAL_SYMBOL;

public class ResultView implements Result {

    private static final String BLANK_BETWEEN_NAMES = " ";
    private static final String FORMAT_BLANK = " ";
    private static final String OUTPUT_RESULT_MESSAGE = "실행결과";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String OUTPUT_PATTERN = "%" + Name.NAME_MAXIMUM_LENGTH + "s";
    private static final String PATTERN_PLAYER_RESULT = "%s : %s";
    private static final char START_KOREAN = '가';
    private static final char END_KOREAN = '힣';

    @Override
    public void printError(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    @Override
    public void printLadder(Players players, Ladder ladder, Rewards rewards) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        System.out.println(convertPlayerNames(players));
        System.out.println(convertLadderSymbol(ladder));
        System.out.println(convertRewards(rewards));
    }

    @Override
    public void printGameResult(Map<Player, Reward> gameResult) {
        System.out.println(convertGameResult(gameResult));
    }

    private String convertGameResult(Map<Player, Reward> gameResult) {
        if (gameResult.size() == 1) {
            return covertSingleGameResult(gameResult);
        }
        return convertMultipleGameResult(gameResult);
    }

    private String convertMultipleGameResult(Map<Player, Reward> gameResult) {
        return gameResult.keySet()
                .stream()
                .map(player -> convertPlayerResult(player, gameResult.get(player)))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String covertSingleGameResult(Map<Player, Reward> gameResult) {
        Optional<Player> first = gameResult.keySet()
                .stream()
                .findFirst();
        return gameResult.get(first.orElseThrow()).getReward();
    }

    private String convertPlayerResult(Player player, Reward reward) {
        return String.format(PATTERN_PLAYER_RESULT, player.getName(), reward.getReward());
    }

    private String convertRewards(Rewards rewards) {
        return rewards.getRewards().stream()
                .map(reward -> formatContent(reward.getReward()))
                .collect(Collectors.joining(BLANK_BETWEEN_NAMES));
    }

    private String convertPlayerNames(Players players) {
        return players.getNames().stream()
                .map(this::formatContent)
                .collect(Collectors.joining(BLANK_BETWEEN_NAMES));
    }

    private String formatContent(String content) {
        return FORMAT_BLANK.repeat(Name.NAME_MAXIMUM_LENGTH - calculateLength(content))
                + content;
    }

    private int calculateLength(String content) {
        int countKorean = 0;
        for (int index = 0; index < content.length(); index++) {
            char charAt = content.charAt(index);
            countKorean += countKorean(charAt);
        }
        return content.length() + countKorean;
    }

    private int countKorean(char letter) {
        if (letter >= START_KOREAN && letter <= END_KOREAN) {
            return  1;
        }
        return 0;
    }

    private String convertLadderSymbol(Ladder ladder) {
        return ladder.getLadder().stream()
                .map(this::convertLineSymbol)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String convertLineSymbol(Line line) {
        return line.getLine().stream()
                .map(this::convertBarSymbol)
                .collect(Collectors.joining(
                        LADDER_VERTICAL_SYMBOL.getSymbol(),
                        String.format(OUTPUT_PATTERN, LADDER_VERTICAL_SYMBOL.getSymbol()),
                        LADDER_VERTICAL_SYMBOL.getSymbol()
                ));
    }

    private String convertBarSymbol(Bar bar) {
        return LadderOutputSymbol
                .decideLadderSymbol(bar)
                .repeat(Name.NAME_MAXIMUM_LENGTH);
    }

}
