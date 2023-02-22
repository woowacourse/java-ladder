package controller;

import domain.model.Goods;
import domain.model.Ladder;
import domain.model.Player;
import domain.service.LadderGame;
import domain.service.LadderMaker;
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
    private int maxPosition;
    private Ladder ladder;
    private List<Name> names;
    private List<Player> players;
    public LadderController(InputView inputView, OutputView outputView, LadderMaker ladderMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
    }
    public void play(){
    }
    private void inputData() {
        names = makePlayers();
        maxPosition = names.size()-1;
        Goods goods = makeGoods(names.size());
        int height = inputView.inputLadderHeight();
        ladder = ladderMaker.make(new Height(height), new Width(maxPosition));
        outputView.printResult(names, ladder);
        outputView.printNames(goods.getGoodsNames());
    }
    private void playGame(){
        LadderGame ladderGame = new LadderGame(maxPosition);
        ladderGame.playLadderGame(names,ladder);
        players = ladderGame.getPlayers();
    }
    public void outputData(){
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