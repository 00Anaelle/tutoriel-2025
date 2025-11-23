package ch.epfl.cs107.play.tuto2.actor;

import ch.epfl.cs107.play.areagame.actor.MovableAreaEntity;
import ch.epfl.cs107.play.areagame.area.Area;
import ch.epfl.cs107.play.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.engine.actor.Sprite;
import ch.epfl.cs107.play.engine.actor.TextGraphics;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Orientation;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class GhostPlayer extends MovableAreaEntity {
    private float hpVal=10f;
    private float hp=hpVal;
    private final TextGraphics hpText;
    private final Sprite sprite;



    public GhostPlayer(Area owner, Orientation orientation, DiscreteCoordinates coordinates, String sprite){
        super(owner,orientation,coordinates);

        this.sprite=new Sprite(sprite, 1f, 1f, this);

        this.hpText=new TextGraphics(Integer.toString((int)hp), 0.4f, Color.BLUE);
        hpText.setParent(this);
        this.hpText.setAnchor(new Vector(-0.3f, 0.1f));
    }

    public void enterArea(Area area, DiscreteCoordinates position){
        area.registerActor(this);
        setOwnerArea(area);
        setCurrentPosition(position.toVector());
        resetMotion();
    }

    public void leaveArea(Area area){
        area.unregisterActor(this);
    }

    public boolean isWeak(){
        return hp<=0;
    }

    public  void strengthen(){
        hp=hpVal;
        hpText.setText(Integer.toString((int) hp));
    }

    public void draw(Canvas canvas){
        sprite.draw(canvas);
        hpText.draw(canvas);
    }

    /// Animation duration in frame number
    private final static int ANIMATION_DURATION = 8;

    public  void update(float deltaTime){
        Keyboard keyboard = getOwnerArea().getKeyboard();

        if (keyboard.get(Keyboard.LEFT).isPressed()) {
            if (getOrientation() == Orientation.LEFT) {
                move(ANIMATION_DURATION);
            } else {
                orientate(Orientation.LEFT);
            }
        }

        if (keyboard.get(Keyboard.RIGHT).isPressed()) {
            if (getOrientation() == Orientation.RIGHT) {
                move(ANIMATION_DURATION);
            } else {
                orientate(Orientation.RIGHT);
            }
        }

        if (keyboard.get(Keyboard.UP).isPressed()) {
            if (getOrientation() == Orientation.UP) {
                move(ANIMATION_DURATION);
            } else {
                orientate(Orientation.UP);
            }
        }

        if (keyboard.get(Keyboard.DOWN).isPressed()) {
            if (getOrientation() == Orientation.DOWN) {
                move(ANIMATION_DURATION);
            } else {
                orientate(Orientation.DOWN);
            }
        }
        hp = Math.max(0f, hp-deltaTime);
        hpText.setText(Integer.toString((int) hp));

        super.update(deltaTime);
    }

    @Override
    public List<DiscreteCoordinates> getCurrentCells() {
        return
                Collections.singletonList(getCurrentMainCellCoordinates());
    }

    @Override
    public boolean takeCellSpace() {
        return true;
    }

    @Override
    public boolean isCellInteractable() {
        return true;
    }

    @Override
    public boolean isViewInteractable() {
        return false;
    }

    @Override
    public void acceptInteraction(AreaInteractionVisitor v, boolean isCellInteraction) {

    }
}
