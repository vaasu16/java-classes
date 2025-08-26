class a1 {
    void m1() {
        System.out.println("from m1 method");
    }
}
class b1 extends a1{

    void m1(){
        System.out.println("from m2 method");
    }
}
public class dpoly {
    public static void main(String[] args){
        System.out.println("a");
        a1 b1 =new b1();
        b1.m1();
    }
}
