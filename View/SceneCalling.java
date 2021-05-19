package View;

import Controller.GameObject;
import Model.Banana;
import Model.Score;
import Model.ScoreLabel;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;

public class SceneCalling extends Application {
    ArcadeMode arcadeMode=new ArcadeMode();
    NormalMode normalMode=new NormalMode();
    OpeningScene openingScene = new OpeningScene();
    private static Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public  Stage getStage() {
        return stage;
    }



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fruit Ninja");
        setStage(primaryStage);
        openingScene.getscene();
    }


    public static void main (String[]args){
        Label label = new Label();
        Label hlabel = new Label();
        Score score = new Score(label);
        System.out.println(score.getScore());
        ScoreLabel scoreLabel = new ScoreLabel(score,hlabel,label);
        Banana banana = new Banana();
        score.ScoreCalc(banana.getObjectType(),score.getScore());
        System.out.println(score.getScore());



        ///launch(args);
    }

}