/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import byui.cit260.afghan_trail.model.Item;
import java.lang.Math;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author jonsi
 */
public class Inventory {
    private int capacity = 12;
    private ArrayList<Item> inventoryItems = new ArrayList<Item>(12); 
    
    public Inventory(){
    }
    
    public Inventory(int capacity){
        inventoryItems.ensureCapacity(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Item> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(ArrayList<Item> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
    
    public void addNewItem(Item item){
        System.out.print("Inside addNewItem\n");
        inventoryItems.add(item);
        System.out.print("after inventory.add(item)\n");
    }
    
    public Item removeRandomItem(){
        if (inventoryItems.size() > 0){
            int rand = (int) Math.ceil(Math.random() * inventoryItems.size());
            Item removedItem = inventoryItems.get(rand);
            inventoryItems.remove(rand);
            return removedItem;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Inventory{" + "capacity=" + capacity + ", inventoryItems=" + inventoryItems + '}';
    } 
    
    
}