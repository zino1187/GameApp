package com.example.zino.gameapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/*
 * Created by zino on 2016-07-01.
 */
public class Enemy extends GameObject{

    public Enemy(Bitmap bitmap, GameView gameView, int width, int height, int x, int y) {
        super(bitmap, gameView, width, height, x, y);
    }
    public void tick() {

    }
    public void render(Canvas canvas) {
        canvas.drawBitmap(bitmap, x,y, null);
    }
}
