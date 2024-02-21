package ladder.view.model;

public class ConsoleReaaderTest implements Reader {

    private final String input;

    public ConsoleReaaderTest(String input) {
        this.input = input;
    }

    @Override
    public String readLine() {
        return this.input;
    }
}
