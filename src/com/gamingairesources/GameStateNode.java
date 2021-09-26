package com.gamingairesources;

import java.util.ArrayList;
import java.util.Collections;

public class GameStateNode {

        GameState current;
        GameState parent;
        ArrayList<GameState> children;

        public GameStateNode(GameState current, GameState parent){
            this.current = current;
            this.parent = parent;
            children = current.generatePossibleMoves();
            Collections.sort(children);

        }

        public GameStateNode(GameState current, GameState parent, ArrayList<GameState> children){
            this.current = current;
            this.parent = parent;
            this.children = children;
        }









}
