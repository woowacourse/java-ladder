//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
//
//public class Cabinet {
//    class Person{
//        String name;
//        int carbinetNumber;
//
//        public Person(String name, int carbinetNumber) {
//            this.name = name;
//            this.carbinetNumber = carbinetNumber;
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        List<Integer> cabinetNumber = new ArrayList<>();
//        Random random = new Random();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        List<Person> persons = new ArrayList<>();
//
//        while(cabinetNumber.size() < 52){
//            cabinetNumber.add(random.nextInt(52)+1);
//        }
//
//        String name = null;
//
//        int i = 0;
//        while((name = br.readLine()) != null){
//            persons.add(new Person(name, 1));
//        }
//    }
//}
