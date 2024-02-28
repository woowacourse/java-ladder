package laddergame.model.laddergame;

import java.util.List;
import laddergame.model.executionresults.ExecutionResults;
import laddergame.model.participants.IndexInfo;
import laddergame.model.participants.InquirySubject;

public class ResultProcessor {
    private final InquirySubject inquirySubject;
    private final ExecutionResults executionResults;
    private final LadderGame ladderGame;

    public ResultProcessor(InquirySubject inquirySubject, ExecutionResults executionResults,
                           LadderGame ladderGame) {
        this.inquirySubject = inquirySubject;
        this.executionResults = executionResults;
        this.ladderGame = ladderGame;
    }

    public List<GameResult> getGameResults() {
        List<IndexInfo> indexInfos = inquirySubject.getIndexInfos();
        return indexInfos.stream()
                .map(indexInfo -> indexInfo.getUpdatedIndexInfo(ladderGame))
                .map(this::getGameResult)
                .toList();
    }

    private GameResult getGameResult(IndexInfo info) {
        return new GameResult(info.getParticipant(), executionResults.findByIndex(info.getIndex()));
    }
}
