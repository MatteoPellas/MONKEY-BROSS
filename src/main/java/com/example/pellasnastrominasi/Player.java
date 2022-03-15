package com.example.pellasnastrominasi;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;

public class Player {

    private int life;
    private int lvl;
    private String name;
    private int atk;
    private double posX;
    private double posY;
    private double speedX = 3;
    private double speedY = 3;
    private double width=20;
    private double heigth=50;
    private boolean crash = false;

    public Player(String name, int life, int lvl, int atk, double posX, double posY){
        this.name = name;
        this.life=life;
        this.lvl = lvl;
        this.atk = atk;
        this.posX=posX;
        this.posY = posY;
    }

    public int getAtk() {
        return atk;
    }

    public int getLife() {
        return life;
    }

    public int getLvl() {
        return lvl;
    }

    public String getName() {
        return name;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return heigth;
    }

    public double getWidth() {
        return width;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void moveLeft(){posX-=speedX;}

    public void moveRight(){
        posX+=speedX;
    }

    public void moveUp(){
        posY-=speedY;
    }

    public void moveDown(){
        posY+=speedY;
    }

    public void load(ArrayList<Rectangle> p, Player entity){

        for(int i =0; i<p.size();i++){

            double myLeft = entity.getPosX();
            double myRight = entity.getPosX()+entity.getWidth();
            double myTop = entity.getPosY();
            double myBottom = entity.getPosY()+entity.getHeigth();
            double otherLeft = p.get(i).getX();
            double otherRight = p.get(i).getX()+ p.get(i).getWidth();
            double otherTop = p.get(i).getY();
            double otherBottom = p.get(i).getY()+p.get(i).getHeigth();

            if ((myBottom < otherTop) || (myTop > otherBottom) || (myRight < otherLeft) || (myLeft > otherRight)){
                entity.setSpeedX(3);
                entity.setSpeedY(3);
            }else {
                crash = true;
            }
            if (crash == true){
                entity.setSpeedX(0);
                entity.setSpeedY(0);
            }
        }
    }
}