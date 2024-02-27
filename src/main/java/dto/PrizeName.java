package dto;

import model.Prize;

public record PrizeName(String prizeName) {
    public PrizeName(Prize prize) {
        this(prize.getPrizeName());
    }
}
