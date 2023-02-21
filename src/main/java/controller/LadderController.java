package controller;

import domain.model.Goods;
import domain.model.Ladder;
import domain.service.LadderGame;
import domain.service.LadderMaker;
import domain.service.PlayerMaker;
import domain.vo.Height;
import domain.vo.Name;
import domain.vo.Width;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderMaker ladderMaker;

    public LadderController(InputView inputView, OutputView outputView, LadderMaker ladderMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
    }

    public void play() {
        List<Name> names = makePlayers();
        Goods goods = makeGoods(names.size());
        int height = inputView.inputLadderHeight();
        Ladder ladder = ladderMaker.make(new Height(height), new Width(names.size() - 1));
        outputView.printResult(names, ladder);
        outputView.printNames(goods.getGoodsNames());
        LadderGame ladderGame = new LadderGame(names.size()-1);
    }
    private List<Name> makePlayers(){
        return inputView.inputNames()
                .stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }
    private Goods makeGoods(int nameCount){
        return new Goods(inputView.inputGoods().
                stream().
                map(item->new Name(item)).
                collect(Collectors.toList()),
                nameCount);
    }
}