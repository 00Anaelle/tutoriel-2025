package ch.epfl.cs107.play.tuto2.area.maps;

import ch.epfl.cs107.play.engine.actor.Background;
import ch.epfl.cs107.play.engine.actor.Foreground;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.tuto1.actor.SimpleGhost;
import ch.epfl.cs107.play.tuto1.area.SimpleArea;

public class Village extends SimpleArea {

    @Override
    protected void createArea() {
        registerActor(new Background(this));
        registerActor(new Foreground(this));
        SimpleGhost ghosti = new SimpleGhost(new Vector(20,10), "ghost.2");
        registerActor(ghosti);
    }

    @Override
    public String getTitle() {
        return "zelda/Village";
    }
}
