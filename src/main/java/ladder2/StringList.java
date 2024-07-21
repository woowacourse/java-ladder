package ladder2;

public class StringList {

	private String word;

    public StringList(String word) {
        this.word = word;
    }
    
    public String getWord() {
    	return word;
    }
    public void setWord(String word) {
    	this.word = word;
    }
    
    public String getFormattedWord() {
        return String.format("%-5s", word);
    }
}
