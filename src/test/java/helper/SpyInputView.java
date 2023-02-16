package helper;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import view.InputView;

public class SpyInputView extends InputView {

    private static final int MINIMUM_HEIGHT_VALUE = 1;

    private int inputNameOfParticipantsCallCount = 0;
    private int inputHeightOfLadderCallCount = 0;

    public SpyInputView() {
        super(null);
    }

    @Override
    public List<String> inputNameOfParticipants() {
        inputNameOfParticipantsCallCount++;
        return Collections.emptyList();
    }

    @Override
    public int inputHeightOfLadder() {
        inputHeightOfLadderCallCount++;
        return MINIMUM_HEIGHT_VALUE;
    }

    public int getInputNameOfParticipantsCallCount() {
        return inputNameOfParticipantsCallCount;
    }

    public int getInputHeightOfLadderCallCount() {
        return inputHeightOfLadderCallCount;
    }
}
