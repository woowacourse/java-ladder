package view.formatter;

import dto.ResultDto;
import java.util.List;

public class ResultDtosFormatter {

    public static String format(final List<ResultDto> resultDtos) {
        StringBuilder formattedResult = new StringBuilder();
        resultDtos.forEach(resultDto -> formattedResult.append(resultDto.personName())
                .append(" : ")
                .append(resultDto.itemName())
                .append("\n")
        );
        return formattedResult.toString();
    }
}
