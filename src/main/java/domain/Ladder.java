package domain;

import dto.LadderDTO;
import dto.LineDTO;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(final List<Line> ladder) {
        this.ladder = ladder;
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
