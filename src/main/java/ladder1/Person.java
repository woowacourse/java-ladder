package ladder1;

public class Person {

	private String name;

    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getFormattedName() {
        return String.format("%-5s", name);
    }
}
