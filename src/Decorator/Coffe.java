package Decorator;

public class Coffe implements ICoffe {
    private final String name;
    private final float cost;

    public Coffe(String name, float cost) {
        this.name = name;
        this.cost = cost;
    }
    
    public float getCost(){
        return cost;
    }
    
    public void type(){
        System.out.println(name);
    }
}


class BaseCoffe implements ICoffe {
    private final ICoffe wrapped;

    public BaseCoffe(ICoffe wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public void type(){
        wrapped.type();
    }
    
    @Override
    public float getCost(){
        return wrapped.getCost();
    }
}

class milkCoffe extends BaseCoffe{
    public milkCoffe(ICoffe wrapped) {
        super(wrapped);
    }
    

    @Override
    public void type(){
        super.type();
        System.out.println("milkCoffe " + getCost());
    }
    
    @Override
    public float getCost(){
        return super.getCost() + 10;
    }
}

class sugarCoffe extends BaseCoffe{
    public sugarCoffe(ICoffe wrapped) {
        super(wrapped);
    }
    

    @Override
    public void type(){
        super.type();
        System.out.println("sugarCoffe " + getCost());
    }
    
    @Override
    public float getCost(){
        return super.getCost() + 5;
    }
}

class whippedCreamCoffe extends BaseCoffe{
    public whippedCreamCoffe(ICoffe wrapped) {
        super(wrapped);
    }
    

    @Override
    public void type(){
        super.type();
        System.out.println("whippedCreamCoffe " + getCost());
    }
    
    @Override
    public float getCost(){
        return super.getCost() + 15;
    }   
}

class run{
    public static void main(String[] args) {
        ICoffe iCoffe =  new milkCoffe(new whippedCreamCoffe(new Coffe("Black coffe", 10)));
        iCoffe.type();
        System.out.println("Total Cost: " + iCoffe.getCost());
    }
}

