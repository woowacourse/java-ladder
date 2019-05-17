package laddergame.domain.rule;

public class AlwaysCreateRule implements Rule {
    @Override
    public boolean canCreate() {
        return true;
    }
}
