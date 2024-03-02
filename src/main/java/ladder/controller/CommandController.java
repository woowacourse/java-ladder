package ladder.controller;

import ladder.constant.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class CommandController {
    private final Map<Command, Runnable> runnables;
    private final Consumer<String> runnableForNotCommand;

    public CommandController(Consumer<String> consumerForNotCommand) {
        this.runnables = new HashMap<>();
        this.runnableForNotCommand = consumerForNotCommand;
    }

    public void put(Command command, Runnable runnable) {
        runnables.put(command, runnable);
    }

    public boolean run(String command) {
        Optional<Command> optionalCommand = Command.from(command);
        if (optionalCommand.isPresent()) {
            return run(optionalCommand.get());
        }
        runnableForNotCommand.accept(command);
        return true;
    }

    private boolean run(Command command) {
        if (runnables.containsKey(command)) {
            runnables.get(command).run();
            return true;
        }
        return command != Command.EXIT;
    }
}
