package com.example.ricknmorty.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.ricknmorty.data.db.daos.CharacterDao;
import com.example.ricknmorty.models.RnMCharacters;

@Database(entities = {RnMCharacters.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CharacterDao characterDao();
}
