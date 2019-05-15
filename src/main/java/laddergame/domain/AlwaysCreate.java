package laddergame.domain;

public class AlwaysCreate implements Rule {
    @Override
    public boolean canCreate() {
        return true;
    }
}
