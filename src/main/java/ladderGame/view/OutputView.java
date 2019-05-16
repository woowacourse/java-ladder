package ladderGame.view;

import java.util.List;
import java.util.Map;

import ladderGame.domain.Floor;
import ladderGame.domain.User;

public class OutputView {
    public static void outputNames(List<User> users) {
        for (User user : users) {
            System.out.printf("%-6s", user.getName());
        }
        System.out.println();
    }

    public static void outputLadder(List<Floor> ladder) {
        for (Floor floor : ladder) {
            outputFloor(floor);
            System.out.println("|");
        }
    }

    private static void outputFloor(Floor floor) {
        for (boolean isStair : floor.getStairs()) {
            System.out.print("|");
            outputStair(isStair);
        }
    }

    private static void outputStair(boolean isStair) {
        if (isStair) {
            System.out.print("-----");
        }
        if (!isStair) {
            System.out.print("     ");
        }
    }

    public static void outputResults(List<String> results) {
        for (String result : results) {
            System.out.printf("%-6s", result);
        }
        System.out.println();
    }

    public static void outputResult(String result) {
        System.out.println(result);
    }

    public static void outputAll(Map<String, String> resultMap) {
        for(String key : resultMap.keySet()){
            String value = resultMap.get(key);
            System.out.println(key+" : "+value);
        }
    }
}
