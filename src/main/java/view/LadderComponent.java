package view;

public enum LadderComponent {
    DIVISION("|"),
    LINE("-----"),
    EMPTY_LINE("     "),
    ;

    private final String output;

    LadderComponent(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public static LadderComponent match(boolean lineStatus){
        if(lineStatus){
            return LINE;
        }
        return EMPTY_LINE;
    }
}
