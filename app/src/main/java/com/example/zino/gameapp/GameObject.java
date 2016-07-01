package com.example.zino.gameapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/*
 * 게임에 등장할 모든 케릭터들은 공통의 기능을 가지고 있다..
 *
 * 1.tick  --> 물리량 변화
 * 2.render --> 그래픽 처리
 *
 * private > default > protected > public
 */
abstract public class GameObject {
    Bitmap bitmap;
    GameView gameView;
    int width;
    int height;
    int x; //x좌표
    int y; //y좌표
    int velX; //x좌표에서의 증가량 - 움직이려면 이 값을 조정하면 된다
    int velY; //y좌표에서의 증가량 - 움직이려면 이 값을 조정하면 된다

    public GameObject(Bitmap bitmap, GameView gameView, int width, int height, int x, int y) {
        this.bitmap=bitmap;
        this.gameView = gameView;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    abstract public void tick();
    abstract public void render(Canvas canvas);

}
