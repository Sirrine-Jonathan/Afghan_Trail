/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.BrokenWagon;
import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.exceptions.BrokenWagonException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Brayden
 */
public class BrokenWagonView extends BasicView{
    
    public BrokenWagonView(){
        super();
        
        
        String[] options = {
            "Fix",
            "Ignore",
            "Rest",
            "Event Help"
        };
        String message = "Your wagon is broken";
        setOptions(options);
        setMessage(message);
        
    }
    public BrokenWagonView(String[] options, String message){
        super(options, message);
    }
    public BrokenWagonView(char keys[]) throws BrokenWagonException{
        this();
        if (keys.length < options.length)
            throw new BrokenWagonException("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    public void displayHelp(){
        //display event help for each event option
        System.out.print("Broken Wagon Help\n");
        System.out.print("FIX WAGON exhaust your wagon supplies, and some "
                + "stamina in order to try and fix up your wagon!\n" ); 
System.out.print("IGNORE means you really don't care that your wagon is broken,"
        + "because you're a strong independant woman, who don't need no wagon."
        + "It also progresses to the next stage of the game.\n");
System.out.print("REST This means a broken wagon can wait - you need a nap!\n");
    }
   
    public void doAction(String[] options, char action,
                         Game game, Player player){
        int actionInt = getFunctionNumberFromChar(action);
        switch (actionInt){
            
            //Fix
            case 0:
                
                System.out.print("You chose '" + options[0] + "'\n");
        {
            try {
                BrokenWagon.fix(player);
            } catch (BrokenWagonException e) {
                System.out.print(e.getMessage());
            }
        }
                break;
             
            //Ignore    
            case 1:
                
                 System.out.print("You chose '" + options[1] + "'\n");
                 BrokenWagon.ignore(player);
                break;
             
            //Rest    
            case 2:
                
                 System.out.print("You chose '" + options[2] + "'\n");
                 BrokenWagon.rest(player);
                break;
        }
    }
}