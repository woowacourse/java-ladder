package ladder.dto;

import static java.util.stream.Collectors.*;

import ladder.domain.Prize;
import ladder.domain.Prizes;

public class PrizesResponse {
    private final String prizes;

    public PrizesResponse(String prizes) {
        this.prizes = prizes;
    }

    public static PrizesResponse ofResults(Prizes prizes) {
        String resultsString = prizes.getPrizes().stream()
                .map(Prize::getPrize)
                .map(result -> String.format("%-5s", result))
                .collect(joining(" "));
        return new PrizesResponse(resultsString);
    }

    public String getPrizes() {
        return prizes;
    }
}
