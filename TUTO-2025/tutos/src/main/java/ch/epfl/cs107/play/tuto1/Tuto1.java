package ch.epfl.cs107.play.tuto1;

import ch.epfl.cs107.play.areagame.AreaGame;
import ch.epfl.cs107.play.areagame.area.Area;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.tuto1.actor.SimpleGhost;
import ch.epfl.cs107.play.tuto1.area.maps.Ferme;
import ch.epfl.cs107.play.tuto1.area.maps.Village;
import ch.epfl.cs107.play.window.Keyboard;
import ch.epfl.cs107.play.window.Window;

import java.util.Objects;

public class Tuto1 extends AreaGame {
    private SimpleGhost player;

    @Override
    public String getTitle() {
        return "Tuto1";
    }

    private void createAreas(){
        addArea(new Village());
        addArea(new Ferme());
    }

    public void end(){
    }

    public void update(float deltaTime){
        super.update(deltaTime);
        switchArea();

        Keyboard keyboard = getWindow().getKeyboard();

        // 3. flèche haut
        if(keyboard.get(Keyboard.UP).isDown()) {
            player.moveUp();
        }
        // 4. flèche bas
        if(keyboard.get(Keyboard.DOWN).isDown()) {
            player.moveDown();
        }

        // 5. flèche gauche
        if(keyboard.get(Keyboard.LEFT).isDown()) {
            player.moveLeft();
        }

        // 6. flèche droite
        if(keyboard.get(Keyboard.RIGHT).isDown()) {
            player.moveRight();
        }

    }


    public boolean begin(Window window, FileSystem fileSystem){
        if (super.begin(window, fileSystem)) {
            // traitement specifiques à Tuto1
            createAreas();
            setCurrentArea("zelda/Ferme", true);
            Area area = getCurrentArea();
            player = new SimpleGhost(new Vector(18,7), "ghost.1");
            area.registerActor(player);
            area.setViewCandidate(player);

            return true;
        }
        else return false;
    }
    public void switchArea() {
        if (player.isWeak()) {
            System.out.println("weakkk");
            if (Objects.equals(getCurrentArea().getTitle(), "zelda/Ferme")) {
                setCurrentArea("zelda/Village", true);

            } else {
                setCurrentArea("zelda/Ferme", true);
            }
            Area newArea = getCurrentArea();
            newArea.registerActor(player);
            newArea.setViewCandidate(player);
            player.strengthen();
        }
    }




}
