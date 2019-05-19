package ladder.domain;

import ladder.domain.generator.DirectionsGenerator;
import ladder.domain.generator.DirectionsGeneratorFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Ladder {
    private static final int MIN_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(int height, DirectionsGenerator directionsGenerator) {
        validate(height);
        this.lines = generateLines(height, directionsGenerator);
    }

    private void validate(int height) {
        validateHeight(height);
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1이상 이어야 합니다.");
        }
    }

    private List<Line> generateLines(final int height, final DirectionsGenerator directionsGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(directionsGenerator.generate()));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public Map<String, String> play(final GamePlayers gamePlayers, final PlayerRewards playerRewards) {
        Map<String, String> result = new HashMap<>(gamePlayers.size());

        for (final Player player : gamePlayers.getPlayers()) {
            int position = player.getPosition();
            for (final Line line : lines) {
                position += line.move(position);
            }
            result.put(player.getName(), playerRewards.getReward(position));
        }

        return result;
    }
}