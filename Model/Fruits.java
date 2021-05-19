package Model;

import Controller.FruitFactory;
import Controller.GameActions;
import Controller.GameObject;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Fruits implements GameObject {
    int x;
    int y;

    @Override
    public Enum getObjectType() {
       return FallingObjectType.FRUIT;
    }

    @Override
    public int getXlocation(){
        return x;
    }

    @Override
    public  int getYlocation(){
        return y;
    }

    @Override
    public  int getMaxHeight(){
        return 735;
    }

    @Override
    public abstract int getInitialVelocity();

    @Override
    public abstract int getFallingVelocity();
    @Override
    public Boolean isSliced() {
        return true;
    }

    @Override
    public Boolean hasMovedOffScreen(){
        return false;
    }

    @Override
    public void slice() {

    }

    @Override
    public void move(double time) {

    }

    @Override
    public abstract BufferedImage[] getBufferedImages();

    @Override
    public abstract Image toImage();
    public GameObject createGameObject (){
        FruitFactory fruitFactory = new FruitFactory();
       GameObject g =  fruitFactory.getFruits();
       return g;
    }
}
