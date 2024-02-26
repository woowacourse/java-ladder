package view;

import java.util.Arrays;
import java.util.List;
import view.printer.Printer;
import view.reader.Reader;


public class InputView {
    public static final String NAME_DELIMITER = ",";

    private final Reader reader;
    private final Printer printer;
    private final InputValidator inputValidator;

    private InputView(Reader reader, Printer printer, InputValidator inputValidator) {
        this.reader = reader;
        this.printer = printer;
        this.inputValidator = inputValidator;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer, new InputValidator());
    }

    public List<String> inputPlayers() {
        printer.printLine("참여할 사람 이름을 입력하세요. (이름은 쉼표(" + NAME_DELIMITER + ")로 구분하세요)");
        String input = reader.readLineWithTrim();
        inputValidator.validatePlayers(input);

        return Arrays.stream(input.split(NAME_DELIMITER))
                .map(String::trim)
                .toList();
    }

    public int inputHeight() {
        printer.printLine("최대 사다리 높이는 몇 개인가요?");
        String input = reader.readLineWithTrim();
        inputValidator.validateHeight(input);

       return Integer.parseInt(input);
    }
}
