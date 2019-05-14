package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<String> separators = new ArrayList<>();
        for (CustomSeparator customSeparator : customSeparators) {
            separators.add(customSeparator.getSeparator());
        }
        return String.join("|", separators);
    }

    public void addCustomSeparator(final CustomSeparator customSeparator) {
        this.customSeparators.add(customSeparator);
    }

}
