package com.amiru.shenkar2018.storage;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by amir on 4/16/18.
 */
@Dao
public interface CaptainsLogDao {
    @Query("select id, time, log from CaptainsLogEntity;")
    LiveData<List<CaptainsLogEntity>> loadCaptainsLog();

    @Insert
    void insertToLog(CaptainsLogEntity logRow);
}
