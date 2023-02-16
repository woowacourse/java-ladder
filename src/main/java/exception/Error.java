package exception;

public enum Error {
	INVALID_NAME_LENGTH("이름은 1 ~ 5글자만 가능합니다"),
	LACK_OF_PEOPLE("사람은 최소 두명 이상이어야 합니다"),
	TOO_MANY_PEOPLE("사람은 최대 10명 이어야 합니다"),
	DUPLICATED_NAME("사람 이름은 중복되지 않아야 합니다"),
	HEIGHT_RANGE_FROM_1_TO_100("높이는 1부터 100까지만 가능합니다");

	private final String message;
	private final String PREFIX = "[ERROR] ";

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return PREFIX + message;
	}
}
