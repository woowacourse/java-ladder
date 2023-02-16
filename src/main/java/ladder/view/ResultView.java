package ladder.view;

import ladder.domain.Foothold;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printNames(List<String> names) {
        for(String name : names){
            System.out.print(String.format("%6s", name));
        }
        System.out.println();
    }

    public void printLadder(List<List<Foothold>> state) {
        state.stream()
                .map(this::generateRow)
                .forEach(System.out::println);
    }

    private String generateRow(List<Foothold> row) {
        return row.stream()
                .map(Foothold::getMark)
                .collect(Collectors.joining("|", "     |", "|"));
    }
}
