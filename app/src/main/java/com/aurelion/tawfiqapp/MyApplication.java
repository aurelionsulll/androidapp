package com.aurelion.tawfiqapp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyApplication extends Application {


    Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        realm = Realm.getDefaultInstance();
    }


    public void ajouter(String login,String pass){
        int id;
        realm.beginTransaction();
        Number currentIdNum = realm.where(User.class).max("id");
        if(currentIdNum==null)
            id=1;
        else
            id =(int) currentIdNum.longValue()+1;

        User user = realm.createObject(User.class,id);
        user.setLogin(login);
        user.setPass(pass);
        realm.commitTransaction();
    }

    public RealmResults<User> getUsers(){
        return realm.where(User.class).findAll();
    }

    public int login(String loginParam,String passParam){
        User user = realm.where(User.class).equalTo("login",loginParam).equalTo("pass",passParam).findFirst();
        if(user!=null)
            return user.getId();
        return -1;
    }

    public User getUser(int id){
        return realm.where(User.class).equalTo("id",id).findFirst();
    }

    public void deleteUser(int id){
        realm.beginTransaction();
        RealmResults<User> result = realm.where(User.class).equalTo("id",id).findAll();
        result.deleteAllFromRealm();
        realm.commitTransaction();
    }

    public void updateUser(int id,String newLogin,String newPass){
        realm.beginTransaction();
        User user_to_update = (User)realm.where(User.class).equalTo("id",id).findAll().first();
        user_to_update.setLogin(newLogin);
        user_to_update.setPass(newPass);
        realm.commitTransaction();
    }
}
