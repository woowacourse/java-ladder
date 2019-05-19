package stringadder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSpliter {
    private static final int END_ADDITIONAL_SEPARATOR_POSITION = 1;
    private static final int START_ADDITIONAL_SEPARATOR_POSITION = 2;
    private static final String ADDITINAL_SEPARATOR_PATEERN = "//.*\\n";
    private List<String> seperators = new ArrayList<>(Arrays.asList(",", ":"));

    public StringSpliter(List<String> seperators) {
        this.seperators.addAll(seperators);
    }

    public StringSpliter() {
    }

    List<String> splitBySeparators(String numbersWithSeparator) {
        String separatorsToRex = String.join("|", seperators);

        return Arrays.asList(numbersWithSeparator.split(separatorsToRex));
    }

    String setAdditionalSeparatorsFrom(String input) {
        Pattern pattern = Pattern.compile(ADDITINAL_SEPARATOR_PATEERN);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            seperators.add(input.substring(matcher.start() + START_ADDITIONAL_SEPARATOR_POSITION,
                    matcher.end() - END_ADDITIONAL_SEPARATOR_POSITION));
            input = input.substring(matcher.end());
        }
        return input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringSpliter that = (StringSpliter) o;
        return Objects.equals(seperators, that.seperators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seperators);
    }
}
