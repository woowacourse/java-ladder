package dto;

import model.prize.Prize;

public record PrizeName(String prizeName) {
    public PrizeName(Prize prize) {
        this(prize.getPrizeName());
    }
}
