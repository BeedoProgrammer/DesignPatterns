package ChainOfResponsibility;

public interface Handler {
    public void handle(int complexity);
    public void setNextHandler(Handler nextHandler);
}

class FirstHandler implements Handler{
    private Handler nextHandler;
    
    @Override
    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }
    
    @Override
    public void handle(int complexity){
        if(complexity == 1)
            System.out.println("Problem 1 Handled");
        else if(nextHandler != null)
            nextHandler.handle(complexity);
    }
}

class SecondHandler implements Handler{
    private Handler nextHandler;
    
    @Override
    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }
    
    @Override
    public void handle(int complexity){
        if(complexity == 2)
            System.out.println("Problem 2 Handled");
        else if(nextHandler != null)
            nextHandler.handle(complexity);
    }
}

class ThirdHandler implements Handler{
    private Handler nextHandler;
    
    @Override
    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }
    
    @Override
    public void handle(int complexity){
        if(complexity == 3)
            System.out.println("Problem 3 Handled");
        else
            System.out.println("Cant be handled");
    }
}

class main {
    public static void main(String[] args) {
        Handler handler1 = new FirstHandler();
        Handler handler2 = new SecondHandler();
        Handler handler3 = new ThirdHandler();
        
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        
        handler1.handle(1);
        handler1.handle(2);
        handler1.handle(3);
        handler1.handle(4);
    }
}