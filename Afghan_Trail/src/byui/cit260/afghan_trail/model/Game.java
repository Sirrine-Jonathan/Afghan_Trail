/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import java.io.Serializable;

/**
 *
 * @author jonsi
 */
public class Game implements Serializable {
    private int progress;
    private boolean isQuit;
    private Player player = new Player();
    public static String winMsg = "You Won!";
    public static String loseMsg = "You Are Dead!";
    
    public Game(){
        setProgress(0);
        setIsQuit(false);
    }
    
    public Game(Player player){
        setProgress(0);
        setIsQuit(false);
        this.player = player;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        if (progress < 0)
            progress = 0;
        else if (progress > 24)
            progress = 24;
        
        this.progress = progress;
    }

    public boolean isIsQuit() {
        return isQuit;
    }

    public void setIsQuit(boolean isQuit) {
        this.isQuit = isQuit;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        System.out.print("in set player\n");
        if (player == null)
            System.out.print("player is null");
        else
            this.player = player;
    }
    
    public void displayPlayer(){
        System.out.print(player.toString());
    }
    /*
        The most a player can be moved forward is 1 position of 25 on the map.
        This way the player does not skip any towns. 
        Whether he is moved after this event is decided on various factors:
            - speed 
            - wagon status
            - sick
            - stamina
     
        Adjustments to the speed are made in getAdjustedSpeed and do not effect
        the players speed property
     
        speed: The higher the speed the higher the chance is that the user
        will progress to the next position. The lowest it can go is 1 which
        corresponds to a 10 % chance. The highest it can go is 10.
    */ 
    public void progressPlayer(){
        int speed = getPlayer().getAdjustedSpeed();
        
        //debug line that shows the chances of moving forward
        System.out.print("\n\nOn the road again\n");
        System.out.print("Your chance of progressing is " + speed * 10 + "%\n");

        if (!player.isResting()){
            int rand = (int) Math.random() * 10;
            if (rand < speed){
                System.out.print("You were able to make it a short distance\n");
                setProgress(getProgress() + 1);
                getPlayer().setStamina(getPlayer().getStamina() - 3);
            }
            else{
                System.out.print("You were too slow to make any progress\n");
            }
        }
        else if (player.isResting()){
            System.out.print("You chose to rest this turn.\n");
            System.out.print(player.getName() + " is now rested up.\n");
            System.out.print("Stamina is at 100.\n");
            player.setResting(false);
            player.setStamina(100);
        }
        
        //report progress
        System.out.print("Progress: " + (getProgress() + 1) + "/25\n");
        

    }    
    
}
