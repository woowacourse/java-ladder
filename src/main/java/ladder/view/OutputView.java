package ladder.view;

import java.util.List;
import ladder.domain.Price;
import ladder.dto.LadderDto;
import ladder.dto.LineDto;
import ladder.dto.PlayerNamesDto;
import ladder.dto.PriceDto;

public class OutputView {


    private static final String LINE_PREFIX = "    |";
    private static final String EXIST_STICK = "-----|";
    private static final String BLANK_STICK = "     |";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void printResult(LadderDto ladderDto, PlayerNamesDto playerNamesDto, PriceDto priceDto) {
        printResultTitle();
        printPlayerNames(playerNamesDto);
        printLadder(ladderDto);
        PrintPrice(priceDto);
    }

    public void printReward(List<String> result, List<Price> prices) {
        System.out.print(System.lineSeparator());
        for (int i = 0; i < result.size(); i++) {
            System.out.printf(result.get(i) + " : " + prices.get(i).getPrice() + System.lineSeparator());
        }
    }

    public void printOneReward(String playerName, Price price) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LINE_SEPARATOR).append("실행결과").append(LINE_SEPARATOR);
        stringBuilder.append(price.getPrice()).append(LINE_SEPARATOR);
        System.out.println(stringBuilder);
    }

    private void printResultTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LINE_SEPARATOR).append("실행결과").append(LINE_SEPARATOR);
        System.out.println(stringBuilder);
    }

    private void printPlayerNames(PlayerNamesDto playerNames) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String playerName : playerNames.playerNames()) {
            String formattedPlayerName = String.format("%5s ", playerName);
            stringBuilder.append(formattedPlayerName);
        }
        System.out.println(stringBuilder);
    }

    private void PrintPrice(PriceDto priceDto) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String priceName : priceDto.priceNames()) {
            String formattedPriceName = String.format("%5s ", priceName);
            stringBuilder.append(formattedPriceName);
        }
        System.out.println(stringBuilder);
    }

    private void printLadder(LadderDto ladder) {
        for (LineDto line : ladder.lines()) {
            printLine(line);
        }
    }

    private void printLine(LineDto line) {
        System.out.printf(LINE_PREFIX);
        for (Boolean isExist : line.sticks()) {
            printStick(isExist);
        }
        System.out.println();
    }

    private void printStick(Boolean isExist) {
        if (isExist) {
            System.out.print(EXIST_STICK);
            return;
        }
        System.out.print(BLANK_STICK);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
