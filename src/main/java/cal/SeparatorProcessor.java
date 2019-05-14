package cal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparatorProcessor {
    public static String [] inputSeparate(String input){
        input = input.substring(2);
        String [] splitedInput = input.split("₩n");
        return splitedInput;
    }

    public static List<String> splitSeparator(String separators){
        return  new ArrayList<String>(Arrays.asList(separators.split("")));
    }
}
