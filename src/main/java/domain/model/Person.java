package domain.model;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
        validateNameLength();
        validateNonBlank();
    }

    public String getName() {
        return this.name;
    }

    public void validateNameLength(){
        if (this.name.length() > 5){
            throw new IllegalStateException();
        }
    }

    public void validateNonBlank(){
        if(this.name.isBlank()){
            throw new IllegalArgumentException();
        }
    }
}
