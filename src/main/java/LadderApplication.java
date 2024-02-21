public class LadderApplication {
    public static void main(String[] args) {
        try {
            LadderGame.run();
        } catch (StackOverflowError error) {
            System.out.println("반복된 입력의 반복으로 프로그램을 종료합니다.");
        }
    }
}
