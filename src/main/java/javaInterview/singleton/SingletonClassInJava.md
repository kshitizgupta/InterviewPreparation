

` 
public class Singleton implements Serializable {
    static private Singleton instance = null;
    private static final Object mutex = new Object();

    private Singleton(){
        if(instance!=null){
            throw new IllegalStateException("Illegal access of constructor");
        }
    }
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (mutex) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolve(){
        return instance;
    }
}
`

###### Why not use Singleton.class instead of mutex
Synchronizing class will lock it’s object too, that’s why we should always create a temporary variable for synchronizing 
block of code.

###### Why not use String for mutex?
String is not a very good candidate to be used with synchronized keyword because they are stored in string pool and we 
don’t want to lock a string that might be getting used by another piece of code

###### Why not use synchronized on the method itself?
That would slower the performance even after the instance is initialized. Only on thread at a given time will be able to 
access the function and rest will be locked.

###### What is the use of volatile keyword?
instance = new Singleton() are actually three step instructions. construct empty object with all the fields as null, 
assign to instance and cflush the values. As per java semantics, its not guaranteed that these 3 will occur in saem order
JVM may reorder the instructions. So say thread1 creates empty object an assigns it to instance, At the same time if 
thread2 gets into the function, for it instance == null check will fail and an object will null values will be returned
which is obviously not expected.
Variables that are marked as volatile ensures that object creation, assignment and assigning values is transactional.
So the other threads dont see a half cooked value. They either see instance as null or completely initialized object.
                       


