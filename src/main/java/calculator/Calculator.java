package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static List<String> inputSplit(String input) {
        if(StringUtils.isBlank(input)) {
            return Arrays.asList("0");
        }

        List<String> result = Arrays.asList(input.split(",|:"));
        return result;
    }
}
