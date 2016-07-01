package com.example.zino.gameapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/*
 * 주인공을 정의한다!! 이미 GameObject에서 필요한 변수 및 메서드를
 * 정의해놓았으므로, 중복해서 정의하지 말자!!
 */
public class Hero extends GameObject{

    public Hero(Bitmap bitmap ,GameView gameView, int width, int height, int x, int y){
        super(bitmap, gameView, width, height, x, y);
    }
    public void tick() {
        //velX++;
        //velY++;

        x=velX;
        y=velY;
    }

    public void render(Canvas canvas) {
        canvas.drawBitmap(bitmap, x,y, null);
    }
}
