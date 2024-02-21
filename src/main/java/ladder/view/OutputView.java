package ladder.view;

import java.util.List;
import ladder.dto.LadderDto;
import ladder.dto.PlayersDto;

public class OutputView {

    public void printLadderResultMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printPlayerNames(PlayersDto playersDto) {
        List<String> playerNames = playersDto.playerNames();

        System.out.println();
        for (String playerName: playerNames) {
            System.out.printf("%5s ", playerName);
        }
        System.out.println();
    }


    public void printLadder(LadderDto ladderDto) {

    }


    public void printErrorMessage(String message) {
        System.out.println(message);
    }


}
