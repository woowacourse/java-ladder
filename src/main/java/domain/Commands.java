package domain;


public enum Commands {

    TERMINATE("all");

    private final String value;

    Commands(final String value) {
        this.value = value;
    }

    public static boolean terminate(String command){
        return TERMINATE.value.equals(command);
    }

}
