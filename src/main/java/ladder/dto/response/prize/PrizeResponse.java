package ladder.dto.response.prize;

import ladder.domain.prize.Prize;

public record PrizeResponse(String name) {
    public static PrizeResponse from(Prize prize) {
        String name = prize.name();

        return new PrizeResponse(name);
    }
}
