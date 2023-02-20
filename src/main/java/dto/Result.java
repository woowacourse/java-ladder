package dto;

public class Result {

    private final String participantName;
    private final String prize;

    public Result(String participantName, String prize) {
        this.participantName = participantName;
        this.prize = prize;
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getPrize() {
        return prize;
    }
}
