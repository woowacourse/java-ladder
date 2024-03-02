package ladder.controller.dto;

import java.util.List;
import ladder.domain.Prize;
import ladder.domain.Prizes;

public record PrizesResponseDto(List<String> prizeNames) {

    public static PrizesResponseDto from(Prizes prizes) {
        List<String> prizeNames = prizes.getPrizes().stream()
                .map(Prize::name)
                .toList();

        return new PrizesResponseDto(prizeNames);
    }
}
