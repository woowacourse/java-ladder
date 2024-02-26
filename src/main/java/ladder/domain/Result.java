package ladder.domain;

public record Result(String value, int location) {
    public boolean hasSameLocation(int location) {
        return this.location == location;
    }
}
