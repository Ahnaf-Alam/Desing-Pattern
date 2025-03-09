package breakingPattern;

import java.io.Serializable;

public class LazySingletonUsingSerialization implements Serializable {
    public static LazySingletonUsingSerialization instance;
    private LazySingletonUsingSerialization(){}

    private Object readResolve() {
        return instance;
    }

    public static LazySingletonUsingSerialization getInstance(){
        if(instance == null) {
            instance = new LazySingletonUsingSerialization();
        }

        return instance;
    }
}
