package laddergame.model.participants;

import java.util.List;

public class InquirySubject {
    private final Participant subject;
    private final Participants participants;
    private final boolean isALLCommand;

    public InquirySubject(Participant subject, Participants participants, boolean isALLCommand) {
        validateInquirySubject(subject, participants, isALLCommand);
        this.subject = subject;
        this.participants = participants;
        this.isALLCommand = isALLCommand;
    }

    private void validateInquirySubject(Participant subject, Participants participants, boolean isALLCommand) {
        if (isALLCommand && participants.contains(subject) || !isALLCommand && !participants.contains(subject)) {
            String message = "[ERROR] 조회 대상자는 all이거나 참여자들 중 하나여야 합니다. 입력값: " + subject.getName();
            throw new IllegalArgumentException(message);
        }
    }

    public List<IndexInfo> getIndexInfos() {
        List<IndexInfo> indexInfos = participants.getIndexInfos();
        if (isALLCommand) {
            return indexInfos;
        }
        return indexInfos.stream()
                .filter(indexInfo -> indexInfo.getIndex() == participants.indexOf(subject))
                .toList();
    }
}
