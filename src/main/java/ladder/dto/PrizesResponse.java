package ladder.dto;

import static java.util.stream.Collectors.*;

import java.util.List;
import ladder.domain.Prize;
import ladder.domain.Prizes;

public class PrizesResponse {
    private final List<String> prizes;

    public PrizesResponse(List<String> prizes) {
        this.prizes = prizes;
    }

    public static PrizesResponse ofPrizes(Prizes prizes) {
        return prizes.getPrizes().stream()
                .map(Prize::getPrize)
                .collect(collectingAndThen(toList(), PrizesResponse::new));
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
