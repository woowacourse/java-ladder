package laddergame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerNames {
    public List<String> makeNames(String input) {
        List<String> names = new ArrayList<>(Arrays.asList(input.split(",")));
        return names;
    }
}
