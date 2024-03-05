package view.formatter;

import dto.ResultsDto;

public class ResultsDtoFormatter {

    public static String format(final ResultsDto resultsDto) {
        StringBuilder formattedResult = new StringBuilder();
        resultsDto.personAndItemName().forEach(resultDto -> formattedResult.append(resultDto.personName())
                .append(" : ")
                .append(resultDto.itemName())
                .append("\n")
        );
        return formattedResult.toString();
    }
}
