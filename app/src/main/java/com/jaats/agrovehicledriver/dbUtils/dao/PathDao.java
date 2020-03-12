package com.jaats.agrovehicledriver.dbUtils.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import com.jaats.agrovehicledriver.dbUtils.entity.PathEntity;

/**
 * Created by Jemsheer K D on 13 February, 2018.
 * Package com.jaats.agrovehicledriver.dbUtils.dao
 * Project Dearest
 */

@Dao
public interface PathDao {

    @Query("SELECT * FROM path")
    List<PathEntity> loadAllPaths();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<PathEntity> pathEntityList);


    @Query("select * from path where tripID = :tripID ORDER BY id ASC")
    List<PathEntity> getAllPath(String tripID);

    @Query("DELETE FROM path")
    void deleteAll();

    @Insert
    void insert(PathEntity pathEntity);

    @Update
    void update(PathEntity pathEntity);

    @Delete
    void delete(PathEntity pathEntity);

}
