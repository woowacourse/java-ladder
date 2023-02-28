package domain.ladder;

import exception.NotEnglishAndNumberException;
import exception.ladder.InvalidLadderResultException;
import exception.view.EmptyInputException;
import java.util.Objects;
import java.util.regex.Pattern;

public class LadderPrize {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String resultName;
    private final Pattern compile = Pattern.compile("^[^0-9a-zA-Z]*$");

    public LadderPrize(String resultName) {
        validate(resultName);
        this.resultName = resultName.strip();
    }

    private void validate(String resultName) {
        if (isNotEmpty(resultName)) {
            throw new EmptyInputException();
        }
        if (isInvalidLength(resultName.strip())) {
            throw new InvalidLadderResultException();
        }
        if (isNotEnglishOrNumber(resultName.strip())) {
            throw new NotEnglishAndNumberException();
        }
    }

    private boolean isNotEmpty(String results) {
        return results == null || results.isBlank();
    }

    private boolean isInvalidLength(String name) {
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
    }

    private boolean isNotEnglishOrNumber(String name) {
        return compile.matcher(name).matches();
    }

    public String getName() {
        return resultName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderPrize that = (LadderPrize) o;
        return resultName.equals(that.resultName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultName);
    }
}
