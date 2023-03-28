package com.example.datab;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataDao {
@Query("select * from Data")
    List<Data> getAll();

@Insert
    void addData(Data data);

@Update
    void updatedata(Data data);

@Delete
    void deletedata(Data data);


}
