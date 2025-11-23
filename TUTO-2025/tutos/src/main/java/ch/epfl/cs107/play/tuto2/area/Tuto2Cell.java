package ch.epfl.cs107.play.tuto2.area;

import ch.epfl.cs107.play.areagame.actor.Interactable;
import ch.epfl.cs107.play.areagame.area.Area;
import ch.epfl.cs107.play.areagame.area.Cell;
import ch.epfl.cs107.play.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.areagame.area.AreaBehavior;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

public class Tuto2Cell extends Cell {
    private final Tuto2Behavior.Tuto2CellType type;

    /**
     * Default Cell constructor
     *
     * @param x (int): x-coordinate of this cell
     * @param y (int): y-coordinate of this cell
     */
    public Tuto2Cell(int x, int y, Tuto2Behavior.Tuto2CellType type) {
        super(x, y);
        this.type= type;
    }

    @Override
    protected boolean canLeave(Interactable entity) {
        return true;
    }

    @Override
    protected boolean canEnter(Interactable entity) {

        return  type.isWalkable;
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
