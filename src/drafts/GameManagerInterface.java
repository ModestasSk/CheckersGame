/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drafts;

/**
 *
 * @author pc
 */
public interface GameManagerInterface {
     int getGamesPlayedCount();
     void setGamesPlayedCount(int count);
     void startGame();
     void nextGame();
     void endGame();
}
