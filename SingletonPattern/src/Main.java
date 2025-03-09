public class Main {
    public static void main(String[] args) {
        System.out.println("Here is the test class for singleton pattern");

        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(instance.hashCode());

        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance2.hashCode());
    }
}