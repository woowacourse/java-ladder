package view;

import domain.model.Goods;
import domain.model.Ladder;
import domain.model.Layer;
import domain.model.Player;
import domain.vo.Name;

import java.util.List;

public class OutputView {

    private static final String RESULT_ANNOUNCEMENT = "\n사다리 결과";
    private static final int INTERVAL_UNIT = 6;
    private static final String FRONT_SPACE = "    ";
    private static final String LINE_DELIMITER = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String UNCONNECTED_LINE = "     ";
    private static final String NAME_SPACE = " ";
    private static final String PRINT_RESULT_MASSAGE = "실행 결과";

    public void printLadderResult(List<Name> names, Ladder ladder) {
        System.out.println(RESULT_ANNOUNCEMENT);
        printNames(names);
        printLadder(ladder);
    }

    private void printLadder(Ladder ladder) {
        for (Layer layer : ladder.getLayers()) {
            printLayer(layer);
        }
    }

    private void printLayer(Layer layer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FRONT_SPACE).append(LINE_DELIMITER);
        List<Boolean> lines = layer.getLines();
        lines.forEach(line -> stringBuilder.append(selectLine(line)).append(LINE_DELIMITER));
        System.out.println(stringBuilder);
    }

    private String selectLine(boolean line) {
        if (line) {
            return CONNECTED_LINE;
        }
        return UNCONNECTED_LINE;
    }

    private void printNames(final List<Name> names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        names.forEach(name -> {
            int difference = INTERVAL_UNIT - name.get().length();
            stringBuilder.append(name.get()).append(NAME_SPACE.repeat(difference));
        });
        System.out.println(stringBuilder);
    }
    public void printResult(){
        System.out.println(PRINT_RESULT_MASSAGE);
    }
    public void printTargetResult(Goods goods){
        System.out.println(goods.getName());
    }
    public void printAllTargetResult(List<Player> playerList,List<Goods> goodsList){
        Player player;
        for (int i = 0; i < playerList.size(); i++) {
            player = playerList.get(i);
            System.out.println(player.getName() + " : " + goodsList.get(player.getPosition()));
        }
    }
}
