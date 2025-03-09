//This implementation uses a static inner helper class to hold the singleton instance.
//The inner class is not loaded into memory until it's referenced for
//the first time in the getInstance() method.
public class BillPughSingleton {
    private BillPughSingleton(){}

    // static inner class that holds the instance
    private static class SingletonHelper {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    // public method to get the instance
    public static BillPughSingleton getInstance() {
        return SingletonHelper.instance;
    }
}

//  1. When the getInstance() method is called for the first time, it triggers the loading of the SingletonHelper class.
//  2. When the inner class is loaded, it creates the INSTANCE of BillPughSingleton.
//  3. The final keyword ensures that the INSTANCE cannot be reassigned.

//The Bill Pugh Singleton implementation, while more complex than Eager Initialization provides a perfect balance of
//lazy initialization, thread safety, and performance, without the complexities of some other patterns like double-checked locking.
