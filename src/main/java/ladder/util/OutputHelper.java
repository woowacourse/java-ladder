package ladder.util;

import java.util.List;

public class OutputHelper {
    static String generateOutputText(List<String> outputs) {
        StringBuilder sb = new StringBuilder();

        for (String name : outputs) {
            sb.append(makeName(name));
        }
        return sb.toString();
    }

    private static String makeName(String output) {
        StringBuilder sb = new StringBuilder();
        sb.append(output);
        for(int i = 0; i< 6 - output.length(); i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
