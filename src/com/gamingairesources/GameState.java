
package com.gamingairesources;
import java.lang.reflect.Array;
import java.util.*;

public abstract class GameState implements Comparable<GameState>{

    private int stateEvaluation;
    private boolean evaluated;
    private int playerTurn;



    public abstract int evaluateState();
    public abstract ArrayList<GameState> generatePossibleMoves();
    public abstract int interpretNoMoves();

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

    public int searchMove(GameState currentState, int depth, int alpha, int beta){
        if(depth == 0){
            return evaluateState();
        }

        ArrayList<GameState> childrenMoves = new ArrayList<>();
        if(childrenMoves.size() == 0){
            return interpretNoMoves();
        }

        for(GameState childMove : childrenMoves){
            int evaluation = searchMove(childMove,depth-1, -1*beta, -1*alpha);

            //Move is too strong, so AI should make another move.
            if(evaluation >= beta){
                return beta;
            }

            alpha = Math.max(alpha, evaluation);

        }
        
        return alpha;
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
