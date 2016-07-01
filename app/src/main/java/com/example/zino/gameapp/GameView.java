package com.example.zino.gameapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/*
  안드로이드건, 자바이건 모든 위젯 및 컴포넌트는 스스로를 그리기 때문에,
  개발자가 화면에 무언가를 직접 그래픽 처리하려면, 컴포넌트를 상속받아
  그래픽 처리를 재정의하면 된다...
  java 의 컴포넌트 그리기 메서는  = paint(Graphics g)
  android의 위젯의 그리기 메서드는 onDraw(Canvas c)
 */
public class GameView extends View implements Runnable{
    String TAG=this.getClass().getName();
    Context context;
    Thread thread; //게임의 엔진 역할을 수행하는 쓰레드!!
    Handler handler;
    Hero hero;

    //이 뷰를 순수 자바코드에서 호출하는 것이 아니라, xml에서 호출할때는
    //xml의 속성들이 같이 전달되므로, 그 값들을 받을 객체인 AttributeSet을 명시해야 한다..
    public GameView(Context context, AttributeSet set){
        super(context, set);


        thread = new Thread(this);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                //여기서 그래픽 처리를 담당하자!!
                render();
            }
        };

        init();
    }

    //케릭터 및 모든 게임에 보여질 오브젝트 등장시키기
    public void init(){
        //주인공 생성하기!!
        hero  = new Hero(this, 200,200,50,300);
    }

    protected void onDraw(Canvas canvas) {
        //실제 그래픽 처리를 담당하는 객체는 Canvas이다!!!
        canvas.drawColor(Color.YELLOW); //색상을 그리다...
        hero.render(canvas);
        super.onDraw(canvas);
    }

    //게임을 가동하는 메서드!!
    public void startGame(){
        thread.start();
    }

    //물리량의 변화를 처리하는 메서드!!
    public void tick(){
        hero.tick();
    }

    //화면에 그래픽 처리를 담당하는 메서드!!
    public void render(){
        Log.d(TAG, "게임 엔진 돌아가는 중...");

        this.invalidate(); //나의 onDraw() 메서드를 재호출!!
    }

    //무한루프로 게임의 엔진을 돌린다!!
    public void run() {
        while(true){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tick();
            handler.sendEmptyMessage(0);
        }
    }

}













