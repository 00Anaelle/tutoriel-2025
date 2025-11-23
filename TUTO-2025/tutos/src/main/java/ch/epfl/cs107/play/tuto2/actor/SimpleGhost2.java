package ch.epfl.cs107.play.tuto2.actor;

import ch.epfl.cs107.play.engine.actor.Entity;
import ch.epfl.cs107.play.engine.actor.Sprite;
import ch.epfl.cs107.play.engine.actor.TextGraphics;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

import java.awt.*;

public class SimpleGhost2 extends Entity {
    //Représentation graphique du fantôme
    private Sprite sprite;
    //pas besoin de redéclarer position et nom d'image, la classe mère Entity s'en charge.

    private float hp;
    private TextGraphics hpText;

    public SimpleGhost2(Vector position, String spriteName){
        super(position);
        this.sprite=new Sprite(spriteName, 1f, 1f, this);
        this.hp=3;
        this.hpText=new TextGraphics(Integer.toString((int)hp), 0.4f, Color.BLUE);
        //lie le texte au fantôme
        hpText.setParent(this);
        //décale un peu le texte par rapport à la postion du fantôme pour que le texte soit au dessu de lui.
        this.hpText.setAnchor(new Vector(-0.3f, 0.1f));

    }

    public boolean isWeak(){
//        if(hp<=0){
//            return true;
//        }else{
//            return false;
//        }juste mais beaucoup top long, on peut très bien faire comme ci dessous
        //System.out.println("hp: "+hp);
        return hp<=0;
    }

    public  void strengthen(){
        hp=3;
        hpText.setText(Integer.toString((int) hp));
    }


    public void draw(Canvas canvas){
        sprite.draw(canvas);
        hpText.draw(canvas);
    }
    public  void update(float deltaTime){
        hp = Math.max(0f, hp-deltaTime);
//        if (hp-deltaTime>=0){
//            hp-=deltaTime;
//        }
        hpText.setText(Integer.toString((int) hp));
        super.update(deltaTime);

    }

    public void moveUp (){
        setCurrentPosition(getPosition().add(0f, 0.05F));
    }
    public void moveDown (){
        setCurrentPosition(getPosition().add(0f, -0.05F));
    }
    public void moveLeft (){
        setCurrentPosition(getPosition().add(-0.05f, 0F));
    }
    public void moveRight (){
        setCurrentPosition(getPosition().add(0.05f, 0F));
    }

    public void respawn(Vector position){
        setCurrentPosition(position);
    }



}
