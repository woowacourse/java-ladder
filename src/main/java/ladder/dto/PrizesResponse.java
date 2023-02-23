package ladder.dto;

import static java.util.stream.Collectors.*;

import ladder.domain.Prize;
import ladder.domain.Prizes;

public class PrizesResponse {
    private final String prizes;

    public PrizesResponse(String prizes) {
        this.prizes = prizes;
    }

    public static PrizesResponse ofPrizes(Prizes prizes) {
        return prizes.getPrizes().stream()
                .map(Prize::getPrize)
                .map(result -> String.format("%-5s", result))
                .collect(collectingAndThen(joining(" "), PrizesResponse::new));
    }

    public String getPrizes() {
        return prizes;
    }
}
