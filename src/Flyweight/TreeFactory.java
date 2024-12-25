package Flyweight;

import java.util.HashMap;
import java.util.*;

public class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();
    
    public static TreeType getType(String type, String texture, String color){
        if(treeTypes.get(type) == null)
            treeTypes.put(type, new TreeType(type, texture, color));
        return treeTypes.get(type);
    }
}

class store{
    private final List<Tree> trees = new ArrayList<>();
    
    public void storeTree(float x, float y, String type, String texture, String color){
        TreeType Treetype = TreeFactory.getType(type, texture, color);
        trees.add(new Tree(x, y, Treetype));
    }
    
    public void render(){
        for(int i = 0; i < trees.size(); i++)
            trees.get(i).render();
    }
}
