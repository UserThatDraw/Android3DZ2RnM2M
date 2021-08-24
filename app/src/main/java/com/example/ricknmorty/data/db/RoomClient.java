package com.example.ricknmorty.data.db;

import android.content.Context;

import androidx.room.Room;

import com.example.ricknmorty.data.db.daos.CharacterDao;

public class RoomClient {
    AppDatabase provideDatabase(Context context){
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "rnmroom").build();
        return db;
    }

    CharacterDao provideCharacterDao(AppDatabase database){
        return database.characterDao();
    }
}
