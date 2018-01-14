package section9.autoboxingAndUnboxing;

import java.util.ArrayList;

public class AutoboxingAndUnboxingApp {

    public static void main(String[] args) {
        // Autoboxing
        ArrayList<Integer> intArrayList = new ArrayList<>();

        for(int i = 0; i <= 10; i++) {
            intArrayList.add(Integer.valueOf(i));
        }

        // unboxing
        for (int i = 0; i <=10; i++) {
            System.out.println( i + " --> " + intArrayList.get(i).intValue());
        }

        Integer myIntValue = 56; // Integer.valueOf(56);
        int myInt = myIntValue; // myIntValue.intValue();

        ArrayList<Double> myDoubleValue = new ArrayList<>();

        for (double dbl = 0.0; dbl <= 10.0; dbl++) {
            myDoubleValue.add(dbl);
        }

        for (int i = 0; i < myDoubleValue.size(); i++) {
            double value = myDoubleValue.get(i);
            System.out.println(i + " --> " + value);
        }
    }

}
