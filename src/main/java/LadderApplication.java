public class LadderApplication {

    public static void main(String[] args) {
        try {
            LadderGameController.run();
        } catch (StackOverflowError error) {
            System.out.println("잘못된 입력의 반복으로 프로그램을 종료합니다.");
        }
    }
}
