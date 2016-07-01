package com.example.zino.gameapp;

import android.graphics.Canvas;

import java.util.ArrayList;

/*
 * GameView 라는 무대에 등장하는 모든 오브젝트는 각각 tick, render가
 * 호출되어야 하므로, 이 모든 로직을 GameView에서 담당하면 유지보수성이
 * 떨어진다. 따라서 별도의 전담 객체로 하여금 게임에 사용될 오브젝트 들을
 * 등장 및 소멸시킬 역할을 전가시켜보자!!!
 * 주목!! - 등장이란 해당 객체의 tick, render가 호출되었다는 의미이다...
 */
public class ObjectManager {
    ArrayList<GameObject> objectList=new ArrayList<GameObject>();

    //등록하기
    public void addObject(GameObject gameObject){
        objectList.add(gameObject);
    }

    //명단지우기
    public void removeObject(GameObject gameObject){
        objectList.remove(gameObject);
    }

    //등록된 모든 게임오브젝트를 대상으로 tick, render를 호출해준다!!
    public void tick(){
        for(int i=0; i<objectList.size();i++){
            objectList.get(i).tick();
        }
    }
    public void render(Canvas canvas){
        for(int i=0;i<objectList.size();i++){
            objectList.get(i).render(canvas);
        }
    }

}











