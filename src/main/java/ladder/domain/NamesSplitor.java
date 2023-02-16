package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamesSplitor {
    public static List<String> split(String names){

        return Arrays.stream(names.split(","))
                .collect(Collectors.toUnmodifiableList());
    }
}
