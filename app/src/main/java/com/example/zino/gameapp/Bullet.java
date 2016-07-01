package com.example.zino.gameapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by zino on 2016-07-01.
 */
public class Bullet extends GameObject{
    public Bullet(Bitmap bitmap, GameView gameView, int width, int height, int x, int y) {
        super(bitmap, gameView, width, height, x, y);
    }

    @Override
    public void tick() {
        velX++;
        x=velX;
    }

    @Override
    public void render(Canvas canvas) {
        canvas.drawBitmap(bitmap, x,y, null);
    }
}
