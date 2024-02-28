package view.formatter;

import java.util.Map;

public class ResultFormatter {

    public String format(final Map<String, String> result) {
        StringBuilder formattedResult = new StringBuilder();
        result.forEach((personName, itemName) -> formattedResult.append(personName)
                .append(" : ")
                .append(itemName)
                .append("\n")
        );
        return formattedResult.toString();
    }
}
