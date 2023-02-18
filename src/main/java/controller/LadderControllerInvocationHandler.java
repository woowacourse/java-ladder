package controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import view.OutputView;

public class LadderControllerInvocationHandler implements InvocationHandler {

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
        } catch (InvocationTargetException e) {
            outputView.printExceptionMessage(e.getCause().getMessage());
            return this.invoke(proxy, method, args);
        }
    }
}
