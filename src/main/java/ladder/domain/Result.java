package ladder.domain;

public class Result {
    private final Name result;
    private final Position position;

    public Result(String result, int position) {
        this.result = new Name(result);
        this.position = new Position(position);
    }

    public boolean isMappedPosition(Position position) {
        return this.position.equals(position);
    }

    public String getResult() {
        return result.getName();
    }
}
