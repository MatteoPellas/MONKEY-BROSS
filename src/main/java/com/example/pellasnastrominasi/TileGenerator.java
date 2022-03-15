package com.example.pellasnastrominasi;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import  javafx.scene.image.Image;


public class TileGenerator {

    int [] terrain = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,22,23,24,44,44,44,44,44,44,44,44,44,
            0,0,0,0,22,0,0,0,38,39,40,125,125,125,125,125,125,125,125,126,
            44,44,44,44,44,44,44,44,54,125,126,141,141,141,141,141,141,125,126,126,
            125,125,125,125,125,125,125,125,125,141,142,125,125,125,125,125,125,125,125,126,
            141,141,141,141,141,141,141,141,141,141,141,141,141,141,141,141,141,141,125,126,
            141,142,142,142,142,142,142,142,142,142,142,142,142,142,142,142,142,142,141,142};

    double level_width;
    double level_height;
    double tile_width;
    double tile_height;
    Image img= null;
    CaricaImmagini loader = new CaricaImmagini();
    private ArrayList <Rectangle> p = new ArrayList<>();


    double tileMapImgHeight;
    double tileMapImageWidth;
    public TileGenerator(String src, double level_width, double level_height, double tile_width, double tile_height, double tileMapImgHeight, double tileMapImageWidth) {
        //this.img = new Image(src);
        this.level_width = level_width;
        this.level_height = level_height;
        this.tile_width = tile_width;
        this.tile_height = tile_height;
        this.tileMapImgHeight = tileMapImgHeight;
        this.tileMapImageWidth = tileMapImageWidth;
    }

    public void draw(GraphicsContext gc) {

        for (int i = 0; i < this.terrain.length; i++) {
            //Ottengo le coordinate sulla canvas
            double dx = (i % this.level_width) * 32;
            double dy = Math.floor(i / this.level_height) * 32;
            double tile = this.terrain[i];

            //Ottengo le coordinate sulla tilemap
            double sx = ((tile  % (this.tileMapImageWidth/32))-1) * 32; //Devo fare -1 perchè il primo tile è il n°1
            double sy = Math.floor(tile / (this.tileMapImgHeight/32)) * 32;


            if (this.terrain[i] != 0) {
                //gc.drawImage(img, sx, sy, this.tile_width, this.tile_height, dx, dy, this.tile_width, this.tile_height);
                Rectangle rect = new Rectangle(dx, dy, tile_width, tile_height);
                p.add(rect);
                rect.draw(gc);



            }
        }

    }

    public ArrayList<Rectangle> getP(ArrayList<Rectangle>obtain) {
        for(int i = 0; i<p.size();i++){
            obtain.add(p.get(i));

        }
        return obtain;
    }
}
