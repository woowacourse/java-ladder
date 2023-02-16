package helper;

import java.util.Collections;
import java.util.List;
import model.Height;
import model.Ladder;
import model.LadderMaker;
import model.Names;

public class SpyLadderMaker extends LadderMaker {

    private int initParticipantsCallCount = 0;
    private int getParticipantsNameCallCount = 0;
    private int initLadderCallCount = 0;
    private int getLadderCallCount = 0;

    public SpyLadderMaker() {
        super(null);
    }

    @Override
    public void initParticipants(List<String> inputNames) {
        initParticipantsCallCount++;
    }

    @Override
    public Names getParticipantsName() {
        getParticipantsNameCallCount++;
        return new Names(Collections.emptyList());
    }

    @Override
    public void initLadder(Height height, int peopleCount) {
        initLadderCallCount++;
    }

    @Override
    public Ladder getLadder() {
        getLadderCallCount++;
        return null;
    }

    public int getInitParticipantsCallCount() {
        return initParticipantsCallCount;
    }

    public int getGetParticipantsNameCallCount() {
        return getParticipantsNameCallCount;
    }

    public int getInitLadderCallCount() {
        return initLadderCallCount;
    }

    public int getGetLadderCallCount() {
        return getLadderCallCount;
    }
}
