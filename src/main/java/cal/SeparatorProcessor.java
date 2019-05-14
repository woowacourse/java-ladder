package cal;

public class SeparatorProcessor {
    public static String [] inputSeparate(String input){
        input = input.substring(2);
        String [] splitedInput = input.split("₩n");
        return splitedInput;
    }
}
