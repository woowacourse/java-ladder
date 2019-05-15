package calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomSeparatorGroup {

    private Set<CustomSeparator> customSeparators;

    CustomSeparatorGroup() {
        customSeparators = new HashSet<>();
        customSeparators.add(new CustomSeparator(","));
        customSeparators.add(new CustomSeparator(":"));
    }

    public Set<CustomSeparator> getCustomSeparators() {
        return customSeparators;
    }

    public String combineSeparatorToRegex() {
        return customSeparators.stream()
                .map(CustomSeparator::getSeparator)
                .collect(Collectors.joining("|"));
    }

    public void addCustomSeparator(final CustomSeparator customSeparator) {
        this.customSeparators.add(customSeparator);
    }

}
