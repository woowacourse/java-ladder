package domain;

import exception.Error;

public class Result {
	private final String sequence;

	public Result(String sequence) {
		validate(sequence);
		this.sequence = sequence;
	}

	public String getSequence() {
		return this.sequence;
	}

	private void validate(String sequence) {
		sequence = sequence.trim();
		if (sequence.length() < 1 || sequence.length() > 5) {
			throw new IllegalArgumentException(Error.INVALID_SEQUENCE_LENGTH.getMessage());
		}
	}
}
