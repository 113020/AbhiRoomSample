package com.example.abhiroomsample;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Water.class}, version = 1, exportSchema = false)
public abstract class WaterDatabase extends RoomDatabase {
    public abstract WaterDao waterDao();
    public static final String DB_NAME = "water";

    private static volatile WaterDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static WaterDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WaterDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WaterDatabase.class, "water_database").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                WaterDao dao = INSTANCE.waterDao();
                dao.deleteAll();

                Water water = new Water("12/2/2019", "5:00", "Shower Head 1", 0.01, 25.3, "hourly",
                2, 2, 2, 2, 2, 0, "Regular", 27.00, "Save 20% of water");
                dao.insertSplash(water);

                /*water = new Water();
                dao.insertSplash(water);*/
            });
        }
    };

}
