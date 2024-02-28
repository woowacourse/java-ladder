package ladder.domain;

public record Result(String reward, Location location) {
    public boolean hasSameLocation(Location location) {
        return this.location.equals(location);
    }
}
