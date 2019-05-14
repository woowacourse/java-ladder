//package calculator.domain;
//
//import calculator.constants.Constants;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Numbers {
//    public static List<Integer> getFromString(String input, String delimiter) {
//        List<Integer> numbers = new ArrayList<>();
//        StringTokenizer st = new StringTokenizer(processingInput(input, delimiter), delimiter);
//        while(st.hasMoreTokens()) {
//            numbers.add(toValidInteger(st.nextToken()));
//        }
//        return numbers;
//    }
//
//    private static Integer toValidInteger(String stringNumber) {
//        validNumber(Integer.parseInt(stringNumber));
//        return Integer.valueOf(stringNumber);
//    }
//
//    private static void validNumber(int number) {
//        if (number < 0) {
//            throw new RuntimeException("음수는 입력이 불가합니다.");
//        }
//    }
//
//    private static String processingInput(String input, String delimiter) {
//        String expression = input;
//        if(!delimiter.equals(Constants.DEFAULT_DELIMITER)){
//            String[] processedInput = input.split(Constants.CUSTOM_END_IDENTIFIER_REGEX);
//            expression = processedInput[1];
//        }
//        return expression;
//    }
//}
