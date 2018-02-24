/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.Hunt;
/**
 *
 * @author Brayden
 */
public class HuntView extends Hunt {

    public HuntView() {
    }
    
    public static void displayHelp(){
        //display event help for each event option
        System.out.print("Hunt Help\n");
    }

    public static char display() {
        String[] options = {
            "Hunt",
            "Ignore",
            "Rest"
        }; 
        BasicMenu brokenWagonMenu = new BasicMenu(
                "Looks like a good place to hunt", 
                options
        );
        String optionString = brokenWagonMenu.getOptionsString();
        System.out.println(brokenWagonMenu.getMessage() + '\n');
        char userInput = BasicMenu.getUserChar(optionString);
        return userInput;
    }
   
}