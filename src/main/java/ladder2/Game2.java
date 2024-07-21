package ladder2;

import java.util.ArrayList;
import java.util.List;

public class Game2 {

    public static void main(String[] args) {
        
        InputView2 inputView = new InputView2();
        ResultView2 resultView = new ResultView2();
        
        List<String> participantNames;
        List<String> resultList;
        int ladderHeight;

        try {
            participantNames = inputView.getParticipantNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // 오류 발생 시 프로그램을 종료
        }
        
        try {
        	resultList = inputView.getResult(participantNames);
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
        
        resultView.printStringList(participantNames);
        
        List<Ladder2> completeLadder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            Ladder2 l = new Ladder2(participantNames.size(), ladderHeight);
            l.makeLadder();
            completeLadder.add(l);
        }
        
        for (Ladder2 l : completeLadder) {
            resultView.printLadder(l.getLadder());
        }
        
        resultView.printStringList(resultList);
        
        String selection = inputView.selectMember();
        
        int n = 0;
        int location = 0;
        
        for(String name : participantNames) {
        	location += findLocation(name,n,selection);
        	n++;
        }
        
        if(selection.equals("all")) {
        	location = -1;
        }
       
        
        if(location!=-1) {
        	resultView.printResult(completeLadder, location, resultList);
        }
        
        if(location == -1) {
        	resultView.printAllResult(completeLadder,resultList,participantNames);
        }
        
    }
    
    public static int findLocation(String name, int i, String selection) {
    	if(name.equals(selection)) {
    		return i;
    	}
    	return 0;
    }
}

