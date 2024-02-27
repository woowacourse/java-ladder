package fixture;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.prize.Prizes;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PrizesFixture {
    public static Prizes 상품들(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> "상품" + i)
                .collect(collectingAndThen(toList(), Prizes::from));
    }

    public static Prizes 상품들(String... names) {
        return Prizes.from(Arrays.asList(names));
    }
}
