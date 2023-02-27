package dto.prize;

import domain.prize.Prizes;
import java.util.List;

public class PrizesDto {
    private final List<String> prizeNames;

    public PrizesDto(List<String> prizeNames) {
        this.prizeNames = prizeNames;
    }

    public static PrizesDto from(Prizes prizes) {
        return new PrizesDto(prizes.getPrizeNames());
    }

    public List<String> getPrizeNames() {
        return prizeNames;
    }
}
