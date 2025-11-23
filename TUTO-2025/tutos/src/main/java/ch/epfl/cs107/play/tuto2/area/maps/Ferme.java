package ch.epfl.cs107.play.tuto2.area.maps;

import ch.epfl.cs107.play.engine.actor.Background;
import ch.epfl.cs107.play.engine.actor.Foreground;
import ch.epfl.cs107.play.tuto1.area.SimpleArea;
import ch.epfl.cs107.play.tuto2.area.Tuto2Area;

public class Ferme extends Tuto2Area {

    @Override
    protected void createArea() {
        registerActor(new Background(this));
        registerActor(new Foreground(this));
    }

    @Override
    public String getTitle() {
        return "zelda/Ferme";
    }
}
