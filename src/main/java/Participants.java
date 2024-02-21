import java.util.List;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        validateParticipantsSize(participants);
        this.participants = participants;
    }

    private void validateParticipantsSize(List<Participant> participants) {
        if (participants == null || participants.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    public int getSize() {
        return participants.size();
    }
}
