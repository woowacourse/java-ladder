package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.dto.LadderResponseDto;
import ladder.domain.dto.LineResponseDto;
import ladder.domain.randomGenerator.RungGenerator;

public class Ladder {

    private final List<Line> lines;

    public Ladder(Height height, int personCount, RungGenerator rungGenerator) {
        lines = makeLines(height, personCount, rungGenerator);
    }

    private List<Line> makeLines(Height height, int personCount, RungGenerator rungGenerator) {
        return IntStream.range(0, height.getHeight())
                .mapToObj(currentHeight -> new Line(rungGenerator, personCount))
                .toList();
    }

    public LadderResponseDto getResultLadders() {
        List<LineResponseDto> lineResponseDtos = lines.stream()
                .map(Line::getRungs)
                .toList();

        return new LadderResponseDto(lineResponseDtos);
    }
}
