package exception;

public enum Error {
	INVALID_NAME_LENGTH("이름은 1 ~ 5글자만 가능합니다"),
	PEOPLE_FROM_2_TO_10("참여 인원은 2 ~ 10명이어야 합니다."),
	DUPLICATED_NAME("사람 이름은 중복되지 않아야 합니다"),
	HEIGHT_RANGE_FROM_1_TO_100("높이는 1부터 100까지만 가능합니다"),
	HEIGHT_ONLY_NUMBER("높이는 숫자를 입력해야 합니다");

	private final String message;
	private final String PREFIX = "[ERROR] ";

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return PREFIX + message;
	}
}
