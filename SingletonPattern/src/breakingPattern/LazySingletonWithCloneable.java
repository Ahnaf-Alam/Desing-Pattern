package breakingPattern;

public class LazySingletonWithCloneable extends BusinessClass{
    public static LazySingletonWithCloneable instance;

    private LazySingletonWithCloneable(){}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static LazySingletonWithCloneable getInstance(){
        if(instance == null) {
            instance = new LazySingletonWithCloneable();
        }

        return instance;
    }
}
