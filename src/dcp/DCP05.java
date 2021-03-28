package dcp;

public class DCP05 {

    public static void main(String[] args) {
        Pair<Integer> p = Pair.cons(3,4);
        System.out.println("The pair is: " + p);
        Integer a = Pair.car(p);
        System.out.println("Output of Pair.car(): " + a);
        Integer b = Pair.cdr(p);
        System.out.println("Output of Pair.cdr(): " + b);
    }
}

// Pair.java



class Pair<T>{

    private T a;
    private T b;

    public Pair(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public static<T> Pair<T> cons(int a, int b) {
        return new<T> Pair(a, b);
    }

    public static <T> T car(Pair p) {
        return (T)p.a;
    }

    public static <T> T cdr(Pair p) {
        return (T)p.b;
    }

    @Override
    public String toString() {
        return "(" + a + "," + b + ")";
    }
}

