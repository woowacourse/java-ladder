package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> value;

    public Prizes(final List<Prize> value) {
        this.value = value;
    }

    public static Prizes from(final List<String> names) {
        List<Prize> value = generatePrizes(names);
        return new Prizes(value);
    }

    private static List<Prize> generatePrizes(final List<String> names) {
        return names.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public String check(final int position) {
        return value.get(position).getValue();
    }

    public int size() {
        return value.size();
    }

    public List<String> getResultNames() {
        return value.stream()
                .map(Prize::getValue)
                .collect(Collectors.toList());
    }
}
