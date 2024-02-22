import config.Config;

public class Application {

    public static void main(String[] args) {
        Config config = new Config();
        config.ladderGameController().run();
    }
}
