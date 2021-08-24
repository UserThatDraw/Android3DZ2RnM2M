package com.example.ricknmorty.data.db;

import android.content.Context;

import androidx.room.Room;

import com.example.ricknmorty.data.db.daos.CharacterDao;

public class RoomClient {
    public AppDatabase provideDatabase(Context context){
        return Room.databaseBuilder(context, AppDatabase.class,"rnmroom")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

   public CharacterDao provideCharacterDao(AppDatabase database){
        return database.characterDao();
    }
}
