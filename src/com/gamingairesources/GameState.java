
package com.gamingairesources;
import java.util.*;

public abstract class GameState implements Comparable<GameState>{

    private int stateEvaluation;
    private boolean evaluated;
    private int playerTurn;



    public abstract int evaluateState();
    public abstract ArrayList<GameState>  generatePossibleMoves();

    public GameState(){                         //Used for testing?
        setPlayerTurn(1);
        setEvaluated(false);
        setStateEvaluation(0);
    }

    public GameState(int playerTurn){
        this.setPlayerTurn(playerTurn);
        setStateEvaluation(evaluateState());
        setEvaluated(true);
    }


    @Override
    public int compareTo(GameState x) {
        if(this.stateEvaluation < x.stateEvaluation)         return 1;
        else if(this.stateEvaluation > x.stateEvaluation)    return -1;
        return 0;
    }


    public int getStateEvaluation() {
        return stateEvaluation;
    }

    public void setStateEvaluation(int stateEvaluation) {
        this.stateEvaluation = stateEvaluation;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }
}
