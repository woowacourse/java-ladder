package laddergame.model;

public class Prize {

    private final String prize;

    public Prize(String prize) {
        this.prize = prize.trim();
    }

    public String getPrize() {
        return prize;
    }
}
