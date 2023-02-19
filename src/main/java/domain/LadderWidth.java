package domain;

public class LadderWidth {
	private final static String LADDER_WIDTH_NUMBER_ERROR_MSG = "너비는 1 이상이여야 합니다.";
	private final int width;

	public LadderWidth(final int number){
		validateWidth(number);
		this.width = number;
	}

	private void validateWidth(final int number){
		if(number <= 0){
			throw new IllegalArgumentException(LADDER_WIDTH_NUMBER_ERROR_MSG);
		}
	}

	public int getWidth(){
		return this.width;
	}
}
