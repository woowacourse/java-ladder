package laddergame.model;

import java.util.List;

public class InquirySubject {
    private static final Participant ALL_SUBJECTS = new Participant("all");

    private final Participant subject;
    private final Participants participants;

    public InquirySubject(Participant subject, Participants participants) {
        validateInquirySubject(subject, participants);
        this.subject = subject;
        this.participants = participants;
    }

    private void validateInquirySubject(Participant subject, Participants participants) {
        if (!(ALL_SUBJECTS.equals(subject) || participants.contains(subject))) {
            throw new IllegalArgumentException("조회 대상자는 all이거나 참여자들 중 하나여야 합니다.");
        }
    }

    public List<IndexInfo> getIndexInfos() {
        List<IndexInfo> indexInfos = participants.getIndexInfos();
        if (ALL_SUBJECTS.equals(subject)) {
            return indexInfos;
        }
        return indexInfos.stream()
                .filter(indexInfo -> indexInfo.getIndex() == participants.indexOf(subject))
                .toList();
    }
}
