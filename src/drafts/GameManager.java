/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drafts;

//Singleton
public class GameManager extends MenuDialog implements GameManagerInterface {
    private int gamesPlayedCounter;
    static GameManager gameObject = new GameManager();
    
    private GameManager(){
    
    }
    public static GameManager getInstance()
    {
        return gameObject;
    }
    @Override
    public int getGamesPlayedCount() {
        return gamesPlayedCounter;
    }

    @Override
    public void setGamesPlayedCount(int count) {
        gamesPlayedCounter = count;
    }

    @Override
    public void startGame() {
        System.out.println("Game has been initialized!");
        System.out.println("EVERYTHING IS MANUAL, THIS IS A LOCAL 1v1 GAME, IF YOU WANT TO END A TURN WHEN YOU FINISHED MOVING YOU GOT TO DO IT MANYALLY.");
        gamesPlayedCounter = 0;
    }
    @Override
    public void nextGame() {
        gamesPlayedCounter++;
        System.out.println("Game " + gamesPlayedCounter + " has started!");
    }
     @Override
    public void endGame() {
       System.exit(0);
    }
}
