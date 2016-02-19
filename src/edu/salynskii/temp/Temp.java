package edu.salynskii.temp;

/**
 * Created by Alimantu on 29/10/15.
 */
class A{
    public int val = 111;
    public void method(){
        System.out.println("A " + val);
    };
}

class B extends A{
    public int val = 222;
    public void method(){
        System.out.println("B " + val);
    };
}

public class Temp{

    public static void main(String[] args) {
        A a = new B();
        a.method();
        System.out.println(a.val);
    }

}
