package model;

import message.ExceptionMessage;

public class Winner {
    private static final String END_MESSAGE = "all";

    private final String winner;

    public Winner(Names names, String winner) {
        validateWinner(names, winner);
        this.winner = winner;
    }

    private void validateWinner(Names names, String winner) {
        if (!(names.getNames().contains(new Name(winner)) || winner.equals(END_MESSAGE))) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_WINNER_RESULT.getExceptionMessage());
        }
    }

    public boolean isAllEndWinner(){
        return this.winner.equals(END_MESSAGE);
    }

    public String getWinner() {
        return this.winner;
    }

}
