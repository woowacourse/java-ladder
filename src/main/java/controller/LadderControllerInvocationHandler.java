package controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import utils.LadderStatus;
import view.OutputView;

public class LadderControllerInvocationHandler implements InvocationHandler {

    private static final String APPLICATION_EXCEPTION_MESSAGE = "애플리케이션에 문제가 발생했습니다.";

    private final LadderController ladderController;
    private final OutputView outputView;

    public LadderControllerInvocationHandler(LadderController ladderController, OutputView outputView) {
        this.ladderController = ladderController;
        this.outputView = outputView;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(ladderController, args);
        } catch (InvocationTargetException exception) {
            Object[] flowArgs = processApplicationFlow(exception.getCause(), args);

            return this.invoke(proxy, method, flowArgs);
        }
    }

    private Object[] processApplicationFlow(Throwable throwable, Object[] args) {
        if (!Objects.isNull(throwable) && isUserException(throwable)) {
            outputView.printExceptionMessage(throwable.getMessage());
            return args;
        }
        outputView.printExceptionMessage(APPLICATION_EXCEPTION_MESSAGE);
        return new Object[] {LadderStatus.APPLICATION_EXCEPTION};
    }

    private boolean isUserException(Throwable throwable) {
        return throwable instanceof IllegalArgumentException;
    }
}
