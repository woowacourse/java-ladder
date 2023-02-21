package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    /*
    미션 1
    SimpleList 인터페이스의 ArrayList 구현체인 SimpleArrayList 를 구현해본다.
    내부적으로 동적으로 배열의 크기를 조절하는 동작을 이해하는 것을 목표로 한다.

    힌트
    머리로 생각하여 구현하는 것은 매우 어렵다. 툴을 사용하거나 그림을 그리며 개념을 잡고 구현해본다.
    자바에서 제공하는 java.util.List 구현체로 먼저 성공하는 테스트 코드를 작성하고, 직접 구현한 List 구현체로 변경한다.
    처음부터 좋은 코드를 작성할 생각을 버려라. 구현 후 리팩토링 한다.
    직접 구현하기 힘들다면 java.util.List 의 구현체 코드를 참고한다.
     */

    private static int DEFAULT_CAPACITY = 10;

    private String[] array;
    private int size;

    public SimpleArrayList(){
        this.array = new String[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        if(size >= array.length){
            String[] newArray = new String[array.length*2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
    }

    @Override
    public String set(int index, String value) {
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        String returnValue = array[index];
        array[index] = value;
        return returnValue;
    }

    @Override
    public String get(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean contains(String value) {
        return false;
    }

    @Override
    public int indexOf(String value) {
        for(int i = 0; i < size; i++){
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String value) {
        return false;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public void clear() {
        array = new String[DEFAULT_CAPACITY];
        size = 0;
    }

}
