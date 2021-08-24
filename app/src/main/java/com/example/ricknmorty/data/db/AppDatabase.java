package com.example.ricknmorty.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.ricknmorty.data.db.daos.CharacterDao;
import com.example.ricknmorty.data.db.daos.EpisodeDao;
import com.example.ricknmorty.data.db.daos.LocationDao;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMLocations;

@Database(entities = {RnMCharacters.class, RnMEpisodes.class, RnMLocations.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CharacterDao characterDao();
    public abstract EpisodeDao episodeDao();
    public abstract LocationDao locationDao();
}
