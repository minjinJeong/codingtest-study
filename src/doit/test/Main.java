package doit.test;

public class Main {
    public static void main(String[] args) {
        A b = new B();
        b.paint();
        b.draw();
        
        // System.out.println(b.data);
        // b.data = 0;
        // System.out.println(b.data);
    }
}

    class A {

        int data = 100;

        public A() {
            data = 200;
            System.out.println("A() " + data);
        }

        public A(int data) {
            this.data = data;
            System.out.println("A(int data) " + data);
        }

        public void paint() {
            System.out.println("A");
            draw();
        }

        public void draw() {
            System.out.println("B");
            draw();
            this.test();
        }

        public void test() {
            System.out.println("Parent");
        }
    }

    class B extends A {

        int data = 1000;

        public B() {
            data = 2000;
            System.out.println("B() " + data);
        }

        public B(int data) {
            this.data = data;
            System.out.println("B(int data) " + data);
        }
        
        public void paint() {
            super.draw();
            System.out.println("C");
            this.draw();
        }

        public void draw() {
            System.out.println("D");
        }

        public void test() {
            System.out.println("Child");
        }
    }