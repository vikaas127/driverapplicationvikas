package com.jaats.agrovehicledriver.dbUtils;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.jaats.agrovehicledriver.dbUtils.dao.PathDao;
import com.jaats.agrovehicledriver.dbUtils.entity.PathEntity;


/**
 * Created by Jemsheer K D on 02 January, 2018.
 * Package com.jaats.agrovehicledriver.database
 * Project AFS_Bus_App
 */

@Database(entities = {PathEntity.class,}, version = 1, exportSchema = false)
public abstract class LaTaxiRoomDatabase extends RoomDatabase {


    public abstract PathDao pathDao();

    private static LaTaxiRoomDatabase INSTANCE;


    public static LaTaxiRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LaTaxiRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LaTaxiRoomDatabase.class, "path_database")
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }
        return INSTANCE;
    }

}
