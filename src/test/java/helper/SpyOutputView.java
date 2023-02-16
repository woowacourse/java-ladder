package helper;

import model.Ladder;
import model.Names;
import view.OutputView;

public class SpyOutputView extends OutputView {

    private int noticeInputParticipantsCallCount = 0;
    private int noticeInputHeightOfLadderCallCount = 0;
    private int noticeResultCallCount = 0;
    private int printNameOfParticipantsCallCount = 0;
    private int printLadderCallCount = 0;

    @Override
    public void noticeInputParticipants() {
        noticeInputParticipantsCallCount++;
    }

    @Override
    public void noticeInputHeightOfLadder() {
        noticeInputHeightOfLadderCallCount++;
    }

    @Override
    public void noticeResult() {
        noticeResultCallCount++;
    }

    @Override
    public void printNameOfParticipants(Names names) {
        printNameOfParticipantsCallCount++;
    }

    @Override
    public void printLadder(Ladder ladder) {
        printLadderCallCount++;
    }

    public int getNoticeInputParticipantsCallCount() {
        return noticeInputParticipantsCallCount;
    }

    public int getNoticeInputHeightOfLadderCallCount() {
        return noticeInputHeightOfLadderCallCount;
    }

    public int getNoticeResultCallCount() {
        return noticeResultCallCount;
    }

    public int getPrintNameOfParticipantsCallCount() {
        return printNameOfParticipantsCallCount;
    }

    public int getPrintLadderCallCount() {
        return printLadderCallCount;
    }
}
