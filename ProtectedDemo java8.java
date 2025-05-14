package BM23AI069;

class A {
    int defaultVar = 10;
    protected int protectedVar = 20;
    private int privateVar = 30;
    public int publicVar = 40;

    public int getPrivateVar() {
        return privateVar;
    }
}

class B extends A {
    void display() {
        System.out.println("From class B");
        System.out.println("Protected: " + protectedVar);
        System.out.println("Private via method: " + getPrivateVar());
        System.out.println("Public: " + publicVar);
    }
}

class C {
    void display() {
        A a = new A();
        System.out.println("From class C");
        System.out.println("Public: " + a.publicVar);
    }
}

public class ProtectedDemo {
    public static void main(String[] args) {
        B b = new B();
        b.display();

        C c = new C();
        c.display();
    }
}