package edu.salynskii.test;
import com.netcracker.edu.java.tasks.ComplexNumber;
import com.netcracker.edu.java.tasks.ComplexNumberImpl;

/**
 * Created by Alimantu on 21/10/15.
 */
public class TestComplexNumberImpl {
    public static void main(String[] args) {
        ComplexNumber complexNumber = new ComplexNumberImpl("2+i");
        //Correct examples: "-5+2i", "1+i", "+4-i", "i", "-3i", "3".
        System.out.println(complexNumber.toString());
        complexNumber.set("-5+2i");
        System.out.println(complexNumber.toString());
        complexNumber.set("1+i");
        System.out.println(complexNumber.toString());
        complexNumber.set("+4-i");
        System.out.println(complexNumber.toString());
        complexNumber.set("i");
        System.out.println(complexNumber.toString());
        complexNumber.set("-3i");
        System.out.println(complexNumber.toString());
        complexNumber.set("3");
        System.out.println(complexNumber.toString());
        //Incorrect examples: "1+2*i", "2+2", "j"
        complexNumber.set("2+2i   j   ");
        System.out.println(complexNumber.toString());
    }
}
