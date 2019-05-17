package laddergame.controller.rule;

public class AlwaysCreateRule implements Rule {
    @Override
    public boolean canCreate() {
        return true;
    }
}
