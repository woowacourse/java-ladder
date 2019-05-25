package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class LadderMatchingIndice {
    private final List<Integer> toIndice;

    LadderMatchingIndice(List<Integer> toIndice) {
        validate(toIndice);

        this.toIndice = toIndice;
    }

    private void validate(List<Integer> toIndice) {
        if (DuplicationChecker.hasDuplication(toIndice)) {
            throw new IllegalArgumentException("중복된 인덱스가 존재합니다.");
        }

        if (hasInvalidIndex(toIndice)) {
            throw new IllegalArgumentException("범위를 넘어선 인덱스가 존재합니다.");
        }
    }

    private boolean hasInvalidIndex(List<Integer> toIndice) {
        Predicate<? super Integer> isIn = (index) -> 0 <= index && index < toIndice.size();

        return toIndice.stream().filter(isIn).count() != toIndice.size();
    }

    public static LadderMatchingIndice from(List<Integer> toIndice) {
        return new LadderMatchingIndice(toIndice);
    }

    public int to(int from) {
        return toIndice.get(from);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderMatchingIndice that = (LadderMatchingIndice) o;
        return Objects.equals(toIndice, that.toIndice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toIndice);
    }
}
