package Flyweight;

class TreeType {
    private final String type;
    private final String texture;
    private final String color;

    public TreeType(String type, String texture, String color) {
        this.type = type;
        this.texture = texture;
        this.color = color;
    }
    
    public void render(float x, float y){
        System.out.println("tree rendered " + type + texture + color + " at x: " + x + "y: " + y);
    }
}

class Tree {
    private final float x;
    private final float y;
    private final TreeType type;

    public Tree(float x, float y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    
    public void render(){
        type.render(x, y);
    }
}
