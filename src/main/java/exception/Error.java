package exception;

public enum Error {
	INVALID_NAME_LENGTH("이름은 1 ~ 5글자만 가능합니다"),
	INVALID_PEOPLE_SIZE("사람은 2 ~ 10 명이여야 합니다"),
	DUPLICATED_NAME("이름은 중복되지 않아야 합니다"),
	HEIGHT_RANGE_FROM_1_TO_100("높이는 1부터 100까지만 가능합니다"),
	NOT_A_NUMBER("높이는 숫자를 입력해야 합니다"),
	NAME_IS_NOT_EXIST("존재하지 않는 참여자입니다"),
	INVALID_RESULTS_SIZE("결과는 참가자의 수와 같아야 합니다"),
	INVALID_RESULT_LENGTH("결과는 1 ~ 5 글자만 가능합니다");

	private static final String PREFIX = "[ERROR] ";

	private final String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return PREFIX + message;
	}
}
