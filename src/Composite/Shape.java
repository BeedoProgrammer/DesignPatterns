package Composite;

import java.util.*;

public interface Shape {
    public void draw();
}

class CompositeShape implements Shape{
    private ArrayList<Shape> shapes = new ArrayList<>();
    
    public void addShape(Shape shape){
        shapes.add(shape);
    }
    
    public void removeShape(Shape shape){
        shapes.remove(shape);
    }
    
    @Override
    public void draw(){
        for(int i = 0; i < shapes.size(); i++)
            shapes.get(i).draw();
    }
}

class Square implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing square");
    }
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing circle");
    }
}


class main {
    public static void main(String[] args) {
        CompositeShape compositeShape = new CompositeShape();
        CompositeShape compositeShape1 = new CompositeShape();
        
        compositeShape1.addShape(new Circle());
        compositeShape1.addShape(new Square());
        
        compositeShape.addShape(new Square());
        compositeShape.addShape(new Circle());
        compositeShape.addShape(compositeShape1);
        
        compositeShape.draw();
    }
}
