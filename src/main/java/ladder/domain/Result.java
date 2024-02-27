package ladder.domain;

public record Result(String reward, int location) {
    public boolean hasSameLocation(int location) {
        return this.location == location;
    }
}
