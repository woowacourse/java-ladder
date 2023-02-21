package laddergame.model.Ladder;

import java.util.ArrayList;
import java.util.List;

import laddergame.model.Participants;

public class Ladder {
    private final Height height;
    private final List<Line> ladder;

    public Ladder(Height height, Participants participants) {
        this.height = height;
        List<Line> ladder = new ArrayList<>();
        makeLadder(participants.getNumber(), ladder);
        this.ladder = ladder;
    }

    //TODO : 테스트 용으로 만든 생성자 해결하기
    public Ladder(Height height, Participants participants, List<Line> lines) {
        this.height = height;
        this.ladder = lines;
    }

    private void makeLadder(int participantsCount, List<Line> ladder) {
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(new Line(participantsCount));
        }
    }

    public int getHeight() {
        return height.getHeight();
    }

    public Line get(int i) {
        return ladder.get(i);
    }

    public int getRewardPosition(int participantsPosition, int participantsCount) {
        for (int i = 0; i < height.getHeight(); i++) {
            Line line = ladder.get(i);
            participantsPosition = movePosition(participantsPosition, participantsCount, line);
        }
        return participantsPosition;
    }

    // TODO : 더 좋은 방법 생각해서 리팩토링하기
    private int movePosition(int participantsPosition, int participantsCount, Line line) {
        if (participantsPosition == 0 && line.hasLine(participantsPosition)) {
            return participantsPosition + 1;
        }
        if (participantsPosition == participantsCount - 1 && line.hasLine(participantsPosition - 1)) {
            return participantsPosition - 1;
        }
        if (participantsPosition != 0 && participantsPosition != participantsCount - 1 && line.hasLine(participantsPosition)) {
            return participantsPosition + 1;
        }
        if (participantsPosition != 0 && participantsPosition != participantsCount - 1 && line.hasLine(participantsPosition - 1)) {
            return participantsPosition - 1;
        }
        return participantsPosition;
    }

}
