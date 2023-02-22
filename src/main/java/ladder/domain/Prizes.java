package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes){
        this.prizes = prizes;
    }

    private Prizes(List<Prize> prizes, int expectedSize){
        validateSize(prizes, expectedSize);
        this.prizes = prizes;
    }

    public static Prizes from(List<String> names, int expectedSize){
        List<Prize> prizes = names.stream().map(Prize::new).collect(Collectors.toList());
        return new Prizes(prizes, expectedSize);
    }

    private void validateSize(List<Prize> prizes, int expectedSize){
        if(prizes.size() != expectedSize){
            throw new IllegalArgumentException(String.format("상품의 개수는 %d이어야합니다.", expectedSize));
        }
    }
}
