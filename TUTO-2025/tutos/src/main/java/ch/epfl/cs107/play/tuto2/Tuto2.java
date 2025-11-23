package ch.epfl.cs107.play.tuto2;

import ch.epfl.cs107.play.areagame.AreaGame;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.tuto1.area.maps.Ferme;
import ch.epfl.cs107.play.tuto1.area.maps.Village;
import ch.epfl.cs107.play.tuto2.actor.SimpleGhost2;
import ch.epfl.cs107.play.window.Keyboard;
import ch.epfl.cs107.play.window.Window;

public class Tuto2 extends AreaGame {
    private SimpleGhost2 player;

    @Override
    public String getTitle() {

        return "Tuto2";
    }

    private void createAreas(){
        addArea(new Village());
        addArea(new Ferme());
    }

    public void end(){
    }

    public void update(float deltaTime){
        //System.out.println("in update");
        super.update(deltaTime);
//        switchArea();

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

        if (player.isWeak()){
            //System.out.println("weeeak");
            switchArea();
        }

    }


    public boolean begin(Window window, FileSystem fileSystem){
        if (super.begin(window, fileSystem)) {
            // traitement specifiques à Tuto1
            createAreas();
            var area = setCurrentArea("zelda/Village", true);
            //Area area = getCurrentArea();
            player = new SimpleGhost2(new Vector(18,7), "ghost.1");
            area.registerActor(player);
            area.setViewCandidate(player);

            return true;
        }
        else return false;
    }
    public void switchArea() {
        // (player.isWeak()) {
        String nextName;
        var currentArea = getCurrentArea();
        String currentAreaName = currentArea.getTitle();

        if (currentAreaName.equals("zelda/Village")){
            nextName = "zelda/Ferme";

        } else{
            nextName = "zelda/Village";
        }
        currentArea.unregisterActor(player);
        var nextArea = setCurrentArea(nextName, false);
        player.strengthen();
        nextArea.registerActor(player);
        nextArea.setViewCandidate(player);
//            if (Objects.equals(getCurrentArea().getTitle(), "zelda/Ferme")) {
//                getCurrentArea().unregisterActor(player);
//                setCurrentArea("zelda/Village", true);
//                nextName="zelda/Village";
//
//            } else {
//                getCurrentArea().unregisterActor(player);
//                setCurrentArea("zelda/Ferme", true);
//                nextName="zelda/Ferme";
//
//
//            }
//            Area newArea = setCurrentArea(nextName, false);
//            newArea.registerActor(player);
//            newArea.setViewCandidate(player);
//            player.strengthen();

        //}
    }




}
