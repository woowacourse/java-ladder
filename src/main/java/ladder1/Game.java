package ladder1;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static void main(String[] args) {
        
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        
        List<String> participantNames;
        int ladderHeight;

        try {
            participantNames = inputView.getParticipantNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // 오류 발생 시 프로그램을 종료
        }
        
        try {
        	ladderHeight = inputView.getLadderHeight();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return; // 오류 발생 시 프로그램을 종료
        }
        
        resultView.printParticipants(participantNames);
        
        List<Ladder> completeLadder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            Ladder l = new Ladder(participantNames.size(), ladderHeight);
            l.makeLadder();
            completeLadder.add(l);
        }
        
        for (Ladder l : completeLadder) {
            resultView.printLadder(l.getLadder());
        }
    }
}

