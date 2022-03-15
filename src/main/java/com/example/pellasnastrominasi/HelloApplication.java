package com.example.pellasnastrominasi;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage theStage) {
        theStage.setTitle( "MONKEY BROSS" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<Rectangle> rects = new ArrayList<>();
        Player player = new Player("prova",100,100,20,50,50);


        String terrain = "Tile/RPG Nature Tileset.png";


        TileGenerator map = new TileGenerator(terrain,20,20,32,32,512,512);


        Canvas canvas = new Canvas( 1080, 720 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();


        final long startNanoTime = System.nanoTime();

        //input
        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();

                        if ( !input.contains(code) )
                            input.add( code );
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        input.remove( code );
                    }
                });

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {


                //controllo input
                gc.clearRect(0, 0, canvas.getWidth(),canvas.getHeight());
                if(input.contains("LEFT")){
                    player.moveLeft();
                }
                if(input.contains("RIGHT")){
                    player.moveRight();
                }
                if(input.contains("UP")){
                    player.moveUp();
                }
                if(input.contains("DOWN")){
                    player.moveDown();
                }

                //disegna
                gc.fillRect(player.getPosX(), player.getPosY(), player.getWidth(), player.getHeigth());
                map.getP(rects);
                player.load(map.getP(rects),player);
                map.draw(gc);


            }
        }.start();


        theStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}