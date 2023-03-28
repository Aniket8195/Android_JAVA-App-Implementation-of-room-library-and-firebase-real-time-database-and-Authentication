package com.example.datab;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = Data.class,exportSchema = false,version = 1)
public abstract class DataHelper extends RoomDatabase {
    private static final String DB_NAME="DataDB";
    private static DataHelper instance;
    public static synchronized DataHelper getDB(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context,DataHelper.class,DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
   return instance;


    }
public abstract DataDao dataDao();
}
