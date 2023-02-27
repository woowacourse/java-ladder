package ladder.domain;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Player {
    private final Name name;
    private int index;
    private Optional<Result> result;

    public Player(String nameValue, int index) {
        this.name = new Name(nameValue);
        this.result = Optional.empty();
        this.index = index;
    }

    public Name getName() {
        return name;
    }

    public void saveResult(Result result) {
        this.result = Optional.ofNullable(result);
    }


    public boolean haveResult() {
        return this.result.isPresent();
    }

    public String getNameValue() {
        return this.name.value();
    }

    public Result getResult() {
        return this.result.orElseThrow(() -> new NoSuchElementException("플레이어의 결과가 존재하지 않습니다."));
    }

    public int getIndex() {
        return this.index;
    }

    public boolean haveNameOf(String nameValue) {
        return this.name.haveSameValueWith(nameValue);
    }

    public String getContentOfResult() {
        return getResult().content();
    }
}
