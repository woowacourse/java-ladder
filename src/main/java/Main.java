import controller.LadderController;

public class Main {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        try {
            ladderController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
