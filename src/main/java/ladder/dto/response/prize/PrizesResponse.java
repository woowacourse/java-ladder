package ladder.dto.response.prize;

import java.util.List;
import ladder.domain.prize.Prizes;

public record PrizesResponse(List<PrizeResponse> prizeResponses) {
    public static PrizesResponse from(Prizes prizes) {
        final List<PrizeResponse> prizeResponses = prizes.getPrizes().stream()
                .map(PrizeResponse::from)
                .toList();

        return new PrizesResponse(prizeResponses);
    }
}
