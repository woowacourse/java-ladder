package ladder.domain.resource.line;

public interface LineGenerator {

    public Line generateLine();

    public void insertDirectionIntoLine(Line line, int count);
}
