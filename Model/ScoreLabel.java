package Model;

import Controller.GameObject;
import javafx.scene.control.Label;

import java.util.Observable;

public class ScoreLabel implements  java.util.Observer {
    private Label scoreLabel;
    private Label highestScore;
private Score scoreobj;
GameObject.FallingObjectType objectType;
public ScoreLabel(Score scoreobj,Label highestScore,Label scoreLabel)
{
    this.scoreobj = scoreobj;
    scoreobj.addObserver(this);
    highestScore.setText("Highest Score: "+ scoreobj.readFile());
}


    @Override
    public void update(Observable o, Object arg) {
        scoreobj.setScore(scoreobj.ScoreCalc(objectType,scoreobj.getScore()));
    }
}
