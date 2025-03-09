import breakingPattern.LazySingletonUsingSerialization;
import breakingPattern.LazySingletonWithCloneable;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        System.out.println("Here is the test class for singleton pattern");

//        LazySingleton instance = LazySingleton.getInstance();
//        System.out.println(instance.hashCode());

        // Breaking singleton pattern using cloneable interface
//        LazySingleton instance2 = LazySingleton.getInstance();
//        System.out.println(instance2.hashCode());

//        LazySingletonWithCloneable inst1 = LazySingletonWithCloneable.getInstance();
//        LazySingletonWithCloneable inst2 = (LazySingletonWithCloneable) inst1.clone();

        // Breaking singleton pattern using refelction
//        LazySingleton reflection  = null;
//        Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
//
//        for(Constructor con: constructors) {
//            con.setAccessible(true);
//            reflection = (LazySingleton) con.newInstance();
//        }
//        System.out.println(reflection.hashCode());

        // Breaking singleton pattern using serialization and deserialization

        LazySingletonUsingSerialization instance = LazySingletonUsingSerialization.getInstance();
        System.out.println(instance.hashCode());

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"));
        out.writeObject(instance);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("file.txt"));
        LazySingletonUsingSerialization inst2 = (LazySingletonUsingSerialization) in.readObject();
        in.close();

        System.out.println(inst2.hashCode());
    }
}