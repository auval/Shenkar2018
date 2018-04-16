package com.amiru.shenkar2018.storage;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by amir on 4/16/18.
 */
@Entity
public class CaptainsLogEntity {
    @PrimaryKey(autoGenerate = true)
    int id;
    long time;
    String log;

    public void setLog(String text) {
        log = text;
        time = System.currentTimeMillis();
    }

}
