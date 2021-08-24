package com.example.ricknmorty.data.db.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.ricknmorty.models.RnMCharacters;

import java.util.List;

@Dao
public interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(RnMCharacters rnmcharacters);

    @Query("SELECT * FROM rnmcharacters")
    List<RnMCharacters> getAll();

}
