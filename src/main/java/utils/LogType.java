package utils;

public enum LogType implements Log {

    ERROR_MESSAGE() {
        public void log(String message) {
            System.out.println("[ERROR] " + message);
        }
    };
}
