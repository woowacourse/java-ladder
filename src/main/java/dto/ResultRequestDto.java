package dto;

public class ResultRequestDto {

    private final String message;

    public ResultRequestDto(String message) {
        this.message = message;
    }

    public boolean isAllResults() {
        return message.equals("all");
    }

    public String getMessage() {
        return message;
    }
}
