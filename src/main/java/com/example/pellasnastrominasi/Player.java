package com.example.pellasnastrominasi;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Player {

    private int life;
    private int lvl;
    private String name;
    private int atk;
    private double posX;
    private double posY;
    private double speedX=3;
    private double speedY=3;
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

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void moveLeft(){
        posX-=speedX;
    }
    public void moveRight(){
        posX+=speedX;
    }
    public void moveUp(){
        posY-=speedY;
    }
    public void moveDown(){
        posY+=speedY;
    }
}
