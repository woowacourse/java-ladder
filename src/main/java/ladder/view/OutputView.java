package ladder.view;

import ladder.dto.LadderDto;
import ladder.dto.LineDto;
import ladder.dto.PlayerNamesDto;

public class OutputView {


    public void printResult(LadderDto ladderDto, PlayerNamesDto playerNamesDto) {
        System.out.println("실행결과");
        System.out.println();

        for (String playerName : playerNamesDto.playerNames()) {
            System.out.printf("%5s ", playerName);
        }
        System.out.println();

        for (LineDto line : ladderDto.lines()) {
            System.out.printf("    |");
            for (Boolean isExist : line.sticks()) {
                if (isExist) {
                    System.out.print("-----|");
                }
                if (!isExist) {
                    System.out.print("     |");
                }
            }
            System.out.println();
        }
    }
}