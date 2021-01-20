package udemyLearning;

import java.util.*;
import java.util.stream.Collectors;

public class MyObject {
    private boolean bool;
    private int value;
    private String name;

    public static void main(String[] args) {


        MyObject[] instanceOf = new MyObject[50];

        for (int i = 0; i < instanceOf.length; i++){
            instanceOf[i] = new MyObject(randomString(), randomNr(1,50), randomBool());
        }
        for (int i = 0; i < instanceOf.length; i++){
    //        System.out.println(instanceOf[i]);
        }
        for (int i = 0; i < instanceOf.length; i++){
    //        System.out.println((i+1) + ". " + instanceOf[i].getValue());

        }

        List<MyObject> listValues = Arrays.asList(instanceOf);
////=============   3.1 ============/////
        List<MyObject> valueAbove20 = listValues.stream()
                .filter(x -> x.getValue() > 20)
                .sorted(Comparator.comparingInt(MyObject::getValue))
                .collect(Collectors.toList());

        System.out.println(valueAbove20.size());
        System.out.println("3.1: Value above 20:  "+ valueAbove20);
////=============   3.2 ============/////

        OptionalDouble averageValue = listValues.stream()
                .mapToInt(MyObject::getValue)
                .average();

        System.out.println("3.2: Average value is: " + averageValue);

////=============   3.3 ============/////
        List<MyObject> changeNameIfTrue = listValues.stream()
                .filter(MyObject::isBool)
                .peek(x -> x.setName("this is true"))
                .collect(Collectors.toList());
        System.out.println("3.3: " + changeNameIfTrue);

    }
    public MyObject(String name, int value, boolean bool) {
        this.bool = bool;
        this.value = value;
        this.name = name;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return this.name + " - " + this.value + " - " + this.bool;
    }
  

    public static String randomString(){

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int length = 10;

        for (int i = 0; i < length; i++){

            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static int randomNr(int minValue, int maxvalue){
        return (int)(Math.random() * (maxvalue - minValue +1 ) + minValue);
    }
    public static boolean randomBool(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
