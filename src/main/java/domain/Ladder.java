package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import domain.generator.ConnectionGenerator;

public class Ladder {

    private final Lines lines;
    private final Height height;

    public Ladder(final int numberOfPlayer, final int height, final ConnectionGenerator connectionGenerator) {
        this.lines = new Lines(numberOfPlayer, height, connectionGenerator);
        this.height = new Height(height);
    }

    public Map<String, String> matchResult(List<Name> names, List<Result> results) {
        Map<String, String> finalResult = new LinkedHashMap<>();

        for (int i = 0; i < names.size(); i++) {
            int finalPosition = lines.goDown(i);

            finalResult.put(names.get(i).getName(), results.get(finalPosition).getResult());
        }

        return finalResult;
    }

    public Lines getLines() {
        return this.lines;
    }

    public Height getHeight() {
        return this.height;
    }
}
