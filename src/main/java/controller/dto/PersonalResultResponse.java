package controller.dto;

import domain.prize.Prize;

public class PersonalResultResponse {

    private final String prize;

    private PersonalResultResponse(final String prize) {
        this.prize = prize;
    }

    public static PersonalResultResponse from(Prize prize) {
        return new PersonalResultResponse(prize.getValue());
    }

    public String getPrize() {
        return prize;
    }
    
}
