package domain;

import dto.LadderDTO;
import dto.LineDTO;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(final Height height, final int width, final LadderGenerator randomLadderGenerator) {
        this.ladder = randomLadderGenerator.generate(width, height);
    }

    public List<Line> getLadder() {
        return new ArrayList<>(ladder);
    }

    public LadderDTO getLadderDTO() {
        List<LineDTO> lineDTOs = new ArrayList<>();
        for (Line line : ladder) {
            lineDTOs.add(line.getLineDTO());
        }
        return new LadderDTO(lineDTOs);
    }
}
