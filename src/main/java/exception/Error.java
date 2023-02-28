package exception;

public enum Error {
	INVALID_NAME_LENGTH("이름은 1 ~ 5글자만 가능합니다"),
	PEOPLE_FROM_2_TO_10("참여 인원은 2 ~ 10명이어야 합니다"),
	DUPLICATED_NAME("사람 이름은 중복되지 않아야 합니다"),
	HEIGHT_RANGE_FROM_1_TO_100("높이는 1부터 100까지만 가능합니다"),
	HEIGHT_ONLY_NUMBER("높이는 숫자를 입력해야 합니다"),
	INVALID_SEQUENCE_LENGTH("예상 결과는 1 ~ 5글자만 가능합니다"),
	RESULTS_FROM_2_TO_10("예상 결과 개수는 2 ~ 10개여야 합니다"),
	NONEXIST_PARTICIPANT("대상은 참여자에 존재하지 않습니다");

	private final String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		String PREFIX = "[ERROR] ";
		return PREFIX + message;
	}
}
