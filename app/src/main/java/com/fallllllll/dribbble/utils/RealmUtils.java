package com.fallllllll.dribbble.utils;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * Created by 康颢曦 on 2017/4/13/013.
 */

public class RealmUtils {
    public  static  <E extends RealmModel> void deleteAll(Class<E> reamClass){
        RealmResults results = Realm.getDefaultInstance().where(reamClass).findAll();
        if (results.size()>0){
            Realm.getDefaultInstance().beginTransaction();
            results.deleteAllFromRealm();
            Realm.getDefaultInstance().commitTransaction();
        }
    }

}
