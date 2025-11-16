package ch.epfl.cs107.play.tuto1.actor;

import ch.epfl.cs107.play.engine.actor.Entity;
import ch.epfl.cs107.play.engine.actor.Sprite;
import ch.epfl.cs107.play.engine.actor.TextGraphics;
import ch.epfl.cs107.play.math.Vector;

public class SimpleGhost extends Entity {

    private Sprite sprite;
    private float energie;
    private TextGraphics hpText;

    public SimpleGhost (Vector position, String spriteName){
        new Sprite(spriteName, 1f, 1f, this);
        energie=10;


    }
}
