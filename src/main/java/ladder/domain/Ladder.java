package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.dto.LadderResponseDto;
import ladder.domain.dto.LineResponseDto;
import ladder.domain.randomGenerator.RungGenerator;

public class Ladder {

    private final List<Line> lines;

    public Ladder(Height height, int personCount, RungGenerator rungGenerator) {
        lines = makeLines(height, personCount, rungGenerator);
    }

    private List<Line> makeLines(Height height, int personCount, RungGenerator rungGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int currentHeight = 0; currentHeight < height.getHeight(); currentHeight++) {
            lines.add(new Line(rungGenerator, personCount));
        }

        return lines;
    }

    public LadderResponseDto getResultLadders() {
        List<LineResponseDto> lineResponseDtos = lines.stream()
                .map(Line::getRungs)
                .toList();

        return new LadderResponseDto(lineResponseDtos);
    }
}
