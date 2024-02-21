package view;

public enum LadderStructure {
    DIVISION("|"),
    LINE("-----"),
    EMPTY_LINE("     "),
    ;


    private final String output;

    LadderStructure(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public static LadderStructure match(boolean line){
        if(line){
            return LINE;
        }
        return EMPTY_LINE;
    }
}
