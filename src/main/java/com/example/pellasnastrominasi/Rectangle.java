package com.example.pellasnastrominasi;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Rectangle {
    boolean crash = false;

    private double x,y,width,heigth;
    public Rectangle(){
        this.x =0;
        this.y = 0;
        this.width = 0;
        this.heigth = 0;
    }
    public Rectangle(double x, double y, double width, double heigth){
        this.x =x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
    }

    public double getHeigth() {
        return heigth;
    }

    public double getWidth() {
        return width;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public void draw(GraphicsContext gc){
        gc.fillRect(x, y, width, heigth);
    }


}
