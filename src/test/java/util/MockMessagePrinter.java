package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MockMessagePrinter implements MessagePrinter {

    private final List<String> printedMessages = new ArrayList<>();
    private boolean isLine = false;

    @Override
    public void print(String message) {
        if (isLine) {
            String previousWord = printedMessages.get(printedMessages.size() - 1);
            previousWord = previousWord.concat(message);
            printedMessages.add(printedMessages.size() - 1, previousWord);
            return;
        }

        printedMessages.add(message);
        isLine = true;
    }

    @Override
    public void println(String message) {
        printedMessages.add(message);
        isLine = false;
    }

    public List<String> getMessages() {
        return Collections.unmodifiableList(this.printedMessages);
    }
}
