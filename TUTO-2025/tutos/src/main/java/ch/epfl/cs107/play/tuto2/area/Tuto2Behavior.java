package ch.epfl.cs107.play.tuto2.area;

import ch.epfl.cs107.play.areagame.area.AreaBehavior;
import ch.epfl.cs107.play.window.Window;

public class Tuto2Behavior extends AreaBehavior {


    /**
     * Default AreaBehavior Constructor
     *
     * @param window (Window): graphic context, not null
     * @param name   (String): name of the behavior image, not null
     */
    public Tuto2Behavior(Window window, String name) {
        super(window, name);
        int width = getWidth();
        int height = getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                Tuto2CellType cellType = Tuto2CellType.toType(getRGB(height-1-y, x));

                setCell(x, y, new Tuto2Cell(x, y, cellType));
            }
        }

    }

    public enum Tuto2CellType {
        NULL(0, false),
        WALL(-16777216, false),
        // #000000 RGB code of black
        IMPASSABLE(-8750470, false), // #7A7A7A, RGB color of gray
        INTERACT(-256, true),
        // #FFFF00, RGB color of yellow
        DOOR(-195580, true),
        WALKABLE(-1, true),;
        final int type;
        final boolean isWalkable;
        // #FD0404, RGB color of red
        // #FFFFFF, RGB color of white

        Tuto2CellType(int type, boolean isWalkable){
            this.type = type;
            this.isWalkable = isWalkable;
        }

//        public static Tuto2CellType toType(int type){
//            if (type == 0){
//                return  Tuto2CellType.NULL;
//            }else if (type == (-16777216)){
//                return Tuto2CellType.WALL;
//            }else if (type ==(-8750470 )){
//                return Tuto2CellType.IMPASSABLE;
//            }else if (type == (-256)){
//                return Tuto2CellType.INTERACT;
//            } else if ( type == -195580) {
//                return Tuto2CellType.DOOR;
//            } else if (type == -1) {
//                return Tuto2CellType.WALKABLE;
//            }else{
//                return Tuto2CellType.NULL;
//            }
//        }
        public static Tuto2CellType toType(int type) {
            for (Tuto2CellType t : Tuto2CellType.values()) {
                if (t.type == type) {
                    return t;
                }
            }
            return Tuto2CellType.NULL;
        }
    }



}
