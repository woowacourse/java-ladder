package ladder.view;

import ladder.dto.LadderDto;
import ladder.dto.LineDto;
import ladder.dto.PlayerNamesDto;
import ladder.dto.PriceDto;

public class OutputView {


    private static final String LINE_PREFIX = "    |";
    private static final String EXIST_STICK = "-----|";
    private static final String BLANK_STICK = "     |";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printResult(LadderDto ladderDto, PlayerNamesDto playerNamesDto, PriceDto priceDto) {
        printResultTitle();
        printPlayerNames(playerNamesDto);
        printLadder(ladderDto);
        PrintPrice(priceDto);
    }

    private void printResultTitle() {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
    }

    private void printPlayerNames(PlayerNamesDto playerNames) {
        for (String playerName : playerNames.playerNames()) {
            System.out.printf("%5s ", playerName);
        }
        System.out.println();
    }

    private void PrintPrice(PriceDto priceDto) {
        for (String priceName : priceDto.priceNames()) {
            System.out.printf("%5s ", priceName);
        }
        System.out.println();
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
