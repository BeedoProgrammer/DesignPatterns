package Prototype;

public abstract class ShapePrototype {
    private float size;
    private float x;
    private float y;

    public ShapePrototype(float size, float x, float y) {
        this.size = size;
        this.x = x;
        this.y = y;
    }
    
    public ShapePrototype(ShapePrototype shapePrototype) {
        this.size = shapePrototype.size;
        this.x = shapePrototype.x;
        this.y = shapePrototype.y;
    }
    
    public void display(){
        System.out.println(size);
        System.out.println(x);
        System.out.println(y);
    }
    
    protected abstract ShapePrototype clone();
}

class Circle extends ShapePrototype{
    private float radius;

    public Circle(float size, float x, float y, float radius) {
        super(size, x, y);
        this.radius = radius;
    }
    
    protected Circle(Circle circle) {
        super(circle);
        this.radius = circle.radius;
    }
    
    @Override
    public Circle clone(){
        return new Circle(this);
    }
    
    @Override
    public void display(){
        super.display();
        System.out.println(radius);
    }
}
        
class Rectangle extends ShapePrototype{
    private float length;
    private float width;
    
    public Rectangle(float size, float x, float y, float length, float width) {
        super(size, x, y);
        this.length = length;
        this.width = width;
    }
    
    protected Rectangle(Rectangle rectangle) {
        super(rectangle);
        this.length = rectangle.length;
        this.width = rectangle.width;
    }
    
    @Override
    public Rectangle clone(){
        return new Rectangle(this);
    }
    
    @Override
    public void display(){
        super.display();
        System.out.println(length);
        System.out.println(width);
    }
}

class main{
    public static void main(String[] args) {
        ShapePrototype rectangle1 = new Rectangle(10, 5, 5, 20, 15);
        rectangle1.display();
        
        System.out.println("");
        
        ShapePrototype rectangle2 = rectangle1.clone();
        rectangle2.display();
    }
}
