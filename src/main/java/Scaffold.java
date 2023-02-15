public enum Scaffold {

    EXIST("----"),
    NONE("    ");

    private final String status;

    Scaffold(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
