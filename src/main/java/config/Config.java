package config;

import controller.InputMapper;
import controller.LadderGameController;
import domain.NonContinuousLineGenerator;
import domain.RowLineGenerator;
import view.InputView;
import view.MessageResolver;
import view.ResultView;

public class Config {
    public InputView inputView() {
        return new InputView();
    }

    public InputMapper inputMapper() {
        return new InputMapper();
    }

    public ResultView resultView() {
        return new ResultView(messageResolver());
    }

    public MessageResolver messageResolver() {
        return new MessageResolver();
    }

    public RowLineGenerator rowLineGenerator() {
        return new NonContinuousLineGenerator();
    }

    public LadderGameController ladderGameController() {
        return new LadderGameController(inputView(), inputMapper(), resultView(), rowLineGenerator());
    }
}
