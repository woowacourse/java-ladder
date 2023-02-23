package domain;

import exception.Error;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> results, int participantSize) {
        validate(results, participantSize);

        List<Prize> prizes = results.stream()
                .map(Prize::new)
                .collect(Collectors.toList());

        return new Prizes(prizes);
    }

    private static void validate(List<String> results, int participantSize) {
        if (results.size() != participantSize) {
            throw new IllegalArgumentException(Error.INVALID_RESULTS_SIZE.getMessage());
        }
    }

    public String getPrizeByPosition(int position) {
        return prizes.get(position).getResult();
    }

    public List<String> getPrizes() {
        return prizes.stream()
                .map(Prize::getResult)
                .collect(Collectors.toUnmodifiableList());
    }
}
