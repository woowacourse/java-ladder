package domain;

record LadderGameOperator(String rawOperator) {
    boolean isAll() {
        return rawOperator.equals("all");
    }
}
