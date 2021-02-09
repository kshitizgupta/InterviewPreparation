//package javaInterview;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOError;
//import java.io.IOException;
//
//interface BaseDef {
//    void show();
//}
//
//class Child implements BaseDef {
//    @Override
//    public void show() throws FileNotFoundException {
//
//    }
//}
//
//class Base {
//    void show() throws IOException {
//    }
//}
//
//class Child2 extends Base {
//    @Override
//    public void show() throws FileNotFoundException {
//    }
//}
//
//class Test {
//    public static void main(String[] args) {
//        Base b1 = new Child2();
//        Child2 c1 = new Child2();
//        Base b2 = new Base();
//
//        try {
//            b1.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            c1.show();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}