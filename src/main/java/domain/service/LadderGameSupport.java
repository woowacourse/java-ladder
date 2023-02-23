package domain.service;

import domain.model.Ladder;
import domain.model.Layer;
import domain.model.PassGenerator;
import domain.vo.Height;
import domain.vo.Location;
import domain.vo.Name;
import domain.vo.Result;
import domain.vo.Width;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameSupport {

    public static final int INITIAL_VERTICAL = 0;
    private final PassGenerator passGenerator;

    public LadderGameSupport(PassGenerator passGenerator) {
        this.passGenerator = passGenerator;
    }

    public Ladder makeLadder(final Height height, final Width width) {
        final List<Layer> layers = IntStream.range(0, height.getValue())
            .mapToObj(index -> new Layer(new ArrayList<>(), passGenerator))
            .collect(Collectors.toList());
        final Ladder ladder = new Ladder(height, width, layers);
        ladder.makeLineInLayers();
        return ladder;
    }

    public Map<Name, Result> makeResultBoard(final Ladder ladder, final List<Name> names,
        final List<Result> results) {
        final Map<Name, Result> resultBoard = new HashMap<>();
        IntStream.range(0, names.size()).forEach(index -> {
            int resultIndex = ladder.ride(new Location(index, INITIAL_VERTICAL));
            Result result = results.get(resultIndex);
            resultBoard.put(names.get(index), result);
        });
        return resultBoard;
    }
}
