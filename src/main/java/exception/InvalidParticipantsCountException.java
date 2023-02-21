package exception;

public class InvalidParticipantsCountException extends IllegalArgumentException {

    public InvalidParticipantsCountException() {
        super("참가자는 1명이상 10이하입니다. 다시 입력해주세요.");
    }
}
