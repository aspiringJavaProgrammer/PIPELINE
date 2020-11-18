/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeline.algorithm;

/**
 *
 * @author 320
 */
public class Shapes {
    
    private String shape, color, id;
    private int weight;
    
    public Shapes(String id, String shape, String color, int weight){
        this.shape = shape;
        this.color = color;
        this.weight = weight;
        this.id = id;
        
    }

    @Override
    public String toString() {
        return "Shapes{" + "shape=" + shape + ", color=" + color + ", id=" + id + ", weight=" + weight + '}';
    }
    
    public String getShape(){
        return this.shape;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    public String getID(){
        return this.id;
    }
}
