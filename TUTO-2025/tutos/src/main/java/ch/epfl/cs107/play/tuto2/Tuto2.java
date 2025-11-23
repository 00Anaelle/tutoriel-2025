package ch.epfl.cs107.play.tuto2;

import ch.epfl.cs107.play.areagame.AreaGame;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Orientation;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.tuto2.area.maps.Ferme;
import ch.epfl.cs107.play.tuto2.area.maps.Village;
import ch.epfl.cs107.play.tuto2.actor.GhostPlayer;

import ch.epfl.cs107.play.window.Window;

public class Tuto2 extends AreaGame {
    private GhostPlayer player;
    private static final float CAMERA_SCALE_FACTOR = 13f;

    @Override
    public String getTitle() {
        return "Tuto2";
    }

    private void createAreas(){
        addArea(new Village());
        addArea(new Ferme());
    }

    public boolean begin(Window window, FileSystem fileSystem){
        if (super.begin(window, fileSystem)) {
            window.setRelativeTransform(Transform.I.scaled(CAMERA_SCALE_FACTOR));
            System.out.println(window.getRelativeTransform());


            createAreas();

            var area = setCurrentArea("zelda/Village", true);

            player= new GhostPlayer(area,Orientation.DOWN, new DiscreteCoordinates(5,15), "ghost.1");

            player.enterArea(area, new DiscreteCoordinates(5, 15));
            area.setViewCandidate(player); // caméra
            return true;
        }
        else return false;
    }

    public void update(float deltaTime){
        super.update(deltaTime);

        if (player.isWeak()){
            switchArea();
        }
    }

    public void switchArea() {
        var currentArea = getCurrentArea();
        String currentAreaName = currentArea.getTitle();

        String nextName;
        DiscreteCoordinates respawn = new DiscreteCoordinates(0,0);
        if (currentAreaName.equals("zelda/Village")){
            nextName = "zelda/Ferme";
            respawn = new DiscreteCoordinates(2, 10);

        } else{
            nextName = "zelda/Village";
            respawn = new DiscreteCoordinates(5, 15);
        }
        player.leaveArea(currentArea);

        // Passer dans la nouvelle aire
        var nextArea = setCurrentArea(nextName, false);

        // Le joueur retrouve sa force
        player.strengthen();

        // Le joueur entre dans la nouvelle aire
        player.enterArea(nextArea, respawn);

        // Caméra
        nextArea.setViewCandidate(player);
    }
    public void end(){
    }




}
