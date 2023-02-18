package utils;

public enum LogType implements Log{

    ERROR_MESSAGE("[ERROR] ") {
        public void log(String message) {
            System.out.println(ERROR_MESSAGE.messageType + message);
        }
    };

    private final String messageType;
    LogType(String messageType) {
        this.messageType = messageType;
    }
}
