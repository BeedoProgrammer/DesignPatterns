package Bridge;
//Shape: Abstraction (defines high-level behavior like draw()).
//Renderer: Implementation (defines the low-level rendering behavior like render()).

public interface Renderer { //Implementation 
    public void render();

} 
class RenderVector implements Renderer{ //concrete class of Implementation
    public void render(){
        System.out.println("renderVector");
    }
}

class RenderRaster implements Renderer{ //concrete class of Implementation
    public void render(){
        System.out.println("renderRaster");
    }
}

abstract class Shape{ //Abstraction
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    
    public abstract void draw();
}

class Square extends Shape{
    public Square(Renderer renderer) {
        super(renderer);
    }
    
    @Override
    public void draw(){
        System.out.println("Draw square with ");
        renderer.render();
    }
}

class Circle extends Shape{
    public Circle(Renderer renderer) {
        super(renderer);
    }
    
    @Override
    public void draw(){
        System.out.println("Draw circle with ");
        renderer.render();
    }
}

class Main {
    public static void main(String[] args) {
        Shape square = new Square(new RenderVector());
        square.draw();
        
        Shape circle = new Circle(new RenderRaster());
        circle.draw();
    }
}
