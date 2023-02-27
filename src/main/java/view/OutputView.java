package view;

public class OutputView {
    
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String LADDER_RESULT_MSG = "사다리 결과";
    private static final String GAME_RESULT_MSG = "실행 결과";
    
    
    public static void printLadderResult( String names, String ladder, String results ) {
        System.out.println(LADDER_RESULT_MSG);
        System.out.println();
        System.out.println(names);
        System.out.println(ladder);
        System.out.println(results);
        System.out.println();
    }
    
    public static void printError( String errorMsg ) {
        System.out.println(ERROR_PREFIX + errorMsg);
    }
    
    public static void printGameResult( String result ) {
        System.out.println(GAME_RESULT_MSG);
        System.out.println(result);
        System.out.println();
    }
    
    public static void printAllGameResults( String allGameResults ) {
        System.out.println(GAME_RESULT_MSG);
        System.out.println(allGameResults);
    }
}
