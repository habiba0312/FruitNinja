package Model;

import Controller.GameObject;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Score extends java.util.Observable{
    int score;
    GameObject object;
    Label highest;
    ScoreLabel scoreLabel;
    private ArrayList<Observer> observers;
    public Score(Label highest) {
        observers = new ArrayList<Observer>();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update(this,observers);
    }
        public void openFile() {

        }
        public int readFile() {
            int a = 0;
            Scanner x = null;
            try {
                x = new Scanner(new File("C:\\Users\\Maryam Gheith\\Desktop\\FruitNinja2\\Fruit Ninja\\src\\Model\\score.txt"));
            } catch (FileNotFoundException e) {
                System.out.println("hjhgj");
            }
            while(x.hasNext()) {
                x.useDelimiter("\n");
                a = x.nextInt();
                setScore(a);
            }
        x.close();
            return a;
    }
    public void writeToFile(int score)
    {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\Maryam Gheith\\Desktop\\FruitNinja2\\Fruit Ninja\\src\\Model\\score.txt",false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter buffer = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(buffer);
        printWriter.print(score);
        printWriter.close();
    }
    public int ScoreCalc (Enum<GameObject.FallingObjectType> objectType, int score)
    {
        if(objectType == GameObject.FallingObjectType.DBOMB)
            score-=10;
        else if(objectType== GameObject.FallingObjectType.FRUIT)
            score+=10;
        else if(objectType== GameObject.FallingObjectType.FBOMB)
            score=0;
        return score;

    }



}

