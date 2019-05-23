package ladder.domain;

public class AlwaysTrueCreateLine implements LineCreate {
    @Override
    public boolean checkLine() {
        return true;
    }

}
