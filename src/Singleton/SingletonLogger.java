package Singleton;

public class SingletonLogger {
    private static volatile SingletonLogger instance; //volatile make thread wait for instance to intialize before taking it
    private String message;

    private SingletonLogger() {
        this.message = "Default Logger Message";;
    }
    
    public static SingletonLogger getInstance(){
        //can use local variable to sore instance and use it in conditions below to increase performance by avoiding reading it each time from main memory
        if(instance == null){ // better performance(faster), doesnt make threads wait if instance is initialized
            synchronized (SingletonLogger.class) { //For threads
                if(instance == null)
                    instance = new SingletonLogger();
            }
        }
        
        return instance;
    }
    
    public void showMessage() {
        System.out.println(message);
    }
}

class run{
    public static void main(String[] args) {
        SingletonLogger logger1 = SingletonLogger.getInstance();

        logger1.showMessage();
        
        SingletonLogger logger2 = SingletonLogger.getInstance();

        logger2.showMessage();
    }
}
