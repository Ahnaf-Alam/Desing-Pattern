public class LazySingleton {
    public static LazySingleton instance;

    private LazySingleton(){
        if(instance != null) {
            throw new IllegalArgumentException();
        }
    }

    public static LazySingleton getInstance(){
        if(instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }
}
