package com.example.zino.gameapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/*
 * 주인공을 정의한다!! 이미 GameObject에서 필요한 변수 및 메서드를
 * 정의해놓았으므로, 중복해서 정의하지 말자!!
 */
public class Hero extends GameObject{
    Bitmap bitmap;

    public Hero(GameView gameView, int width, int height, int x, int y){
        super(gameView, width, height, x, y);

        bitmap= BitmapFactory.decodeResource(gameView.getResources() , R.drawable.spaceship);
        //이미지 크기 재조정
        bitmap=Bitmap.createScaledBitmap(bitmap,width,height, false);

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
