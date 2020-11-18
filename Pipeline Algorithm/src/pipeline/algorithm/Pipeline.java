/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeline.algorithm;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


/**
 *
 * @author 320
 */
public class Pipeline{
    
    private ArrayList<Shapes> allShapes;
    
    public Pipeline(){
        this.allShapes = new ArrayList<>();
    }
    // add items to list
    public void addItems(ArrayList<Shapes> allShapes) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count, weight;
        String color, name;
        
        System.out.print("How many items would you like to add? : ");
        count = Integer.valueOf(br.readLine());
        
        for(int i = 0 ; i < count ; i++){
            System.out.println("Enter shape #" + (i+1) + " data:");
            System.out.print("\tShape Type: ");
            name = br.readLine();
            System.out.print("\tColor: ");
            color = br.readLine();
            System.out.print("\tWeight: ");
            weight = Integer.valueOf(br.readLine());
            
            allShapes.add(new Shapes(String.valueOf(i+1),name, color, weight));
        }
        
    }

    public ArrayList<Shapes> getAllShapes(){
        return this.allShapes;
    }
    
    public static void main(String [] args) throws IOException{
        
        System.out.println("PIPELINE ALGORITHM");
        
        Pipeline pipe = new Pipeline();
        pipe.addItems(pipe.getAllShapes());
        System.out.println("Adding items.....");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pipeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Unfiltered Shapes");
        for(Shapes nonFiltered: pipe.getAllShapes()){
            System.out.println("\t" + nonFiltered.toString());

        }
        List<Shapes> filteredShapes = pipe.getAllShapes().stream()
                .filter(thisShape -> thisShape.getShape().equalsIgnoreCase("Circle"))
                .filter(thisShape -> thisShape.getColor().equalsIgnoreCase("Blue"))
                .sorted(Comparator.comparingInt(Shapes::getWeight))
                .collect(Collectors.toList());
        
        System.out.println("Filtering items.....");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pipeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Shapes filtered: filteredShapes){
            System.out.println("\t" + filtered.toString());
            
        }
        
    }
}
