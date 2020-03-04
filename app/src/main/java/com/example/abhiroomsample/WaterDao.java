package com.example.abhiroomsample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WaterDao {
    // Insert parameter Splash database entity into the Water Database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertSplash(Water water);

    // Update Splash database entity, given as parameter, that matches with the primary key of each database entity
    @Update
    public void updateSplash(Water water);

    // Delete (from the table) the Splash database entity, given as parameter, that matches with the primary key of each database entity
    @Delete
    public void deleteSplash(Water water);

    // Get all the Splash entities
    @Query("SELECT * FROM water")
    public LiveData<List<Water>> getAllSplashes();

    // Get all the Splash entities that correspond with the fixture parameter
    @Query("SELECT * FROM water WHERE fixture=:fixture")
    public LiveData<List<Water>> getByFixture(String fixture);

    // Get all the Splash entities that correspond with the time interval
    @Query("SELECT * FROM water WHERE time_interval=:interval")
    public LiveData<List<Water>> getByTimeInterval(String interval);

    // Get all the Splash entities that correspond with water bill calculation method
    @Query("SELECT * FROM water WHERE water_bill_method=:method")
    public LiveData<List<Water>> getByBillMethod(String method);

    @Query("DELETE FROM water")
    public void deleteAll();
}
