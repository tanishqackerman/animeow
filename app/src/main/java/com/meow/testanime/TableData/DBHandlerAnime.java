package com.meow.testanime.TableData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.meow.testanime.AnimeDetails;
import com.meow.testanime.Attributes.AttributesAnime;
import com.meow.testanime.DBModels.AnimeDB;

import java.util.ArrayList;
import java.util.List;

public class DBHandlerAnime extends SQLiteOpenHelper {

    public DBHandlerAnime(Context context) {
        super(context, AttributesAnime.DB_NAME, null, AttributesAnime.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE " + AttributesAnime.ANIME_TABLE + "(" + AttributesAnime.KEY_ANIME_NAME + " TEXT PRIMARY KEY, " + AttributesAnime.KEY_ANIME_IMGURL + " TEXT, " + AttributesAnime.KEY_ANIME_SCORE + " TEXT, " + AttributesAnime.KEY_ANIME_AIRINGPERIOD + " TEXT, " + AttributesAnime.KEY_ANIME_NOEP + " TEXT, " + AttributesAnime.KEY_ANIME_AGERATING + " TEXT, " + AttributesAnime.KEY_ANIME_LEARNMORE + " TEXT, " + AttributesAnime.KEY_ANIME_TRAILERURL + " TEXT, " + AttributesAnime.KEY_ANIME_SYPNOSIS + " TEXT" + ")";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addAnimeWatchList(AnimeDB animeDB) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AttributesAnime.KEY_ANIME_NAME, animeDB.getAnimename());
        values.put(AttributesAnime.KEY_ANIME_IMGURL, animeDB.getImgurl());
        values.put(AttributesAnime.KEY_ANIME_SCORE, animeDB.getAnimescore());
        values.put(AttributesAnime.KEY_ANIME_AIRINGPERIOD, animeDB.getAnimeairingperiod());
        values.put(AttributesAnime.KEY_ANIME_NOEP, animeDB.getAnimeep());
        values.put(AttributesAnime.KEY_ANIME_AGERATING, animeDB.getAnimeage());
        values.put(AttributesAnime.KEY_ANIME_LEARNMORE, animeDB.getLearnmore());
        values.put(AttributesAnime.KEY_ANIME_TRAILERURL, animeDB.getAnimetrailer());
        values.put(AttributesAnime.KEY_ANIME_SYPNOSIS, animeDB.getAnimesypnosis());
        db.insert(AttributesAnime.ANIME_TABLE, null, values);
        db.close();
    }

    public List<AnimeDB> getAnimeWatchList() {
        List<AnimeDB> animeWatchList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + AttributesAnime.ANIME_TABLE;
        Cursor cursor = db.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                AnimeDB animeDB = new AnimeDB();
                animeDB.setAnimename(cursor.getString(0));
                animeDB.setImgurl(cursor.getString(1));
                animeDB.setAnimescore(cursor.getString(2));
                animeDB.setAnimeairingperiod(cursor.getString(3));
                animeDB.setAnimeep(cursor.getString(4));
                animeDB.setAnimeage(cursor.getString(5));
                animeDB.setLearnmore(cursor.getString(6));
                animeDB.setAnimetrailer(cursor.getString(7));
                animeDB.setAnimesypnosis(cursor.getString(8));
                animeWatchList.add(animeDB);
            } while (cursor.moveToNext());
        }
        return animeWatchList;
    }

    public int updateAnime(AnimeDB animeDB) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AttributesAnime.KEY_ANIME_NAME, animeDB.getAnimename());
        values.put(AttributesAnime.KEY_ANIME_IMGURL, animeDB.getImgurl());
        values.put(AttributesAnime.KEY_ANIME_SCORE, animeDB.getAnimescore());
        values.put(AttributesAnime.KEY_ANIME_AIRINGPERIOD, animeDB.getAnimeairingperiod());
        values.put(AttributesAnime.KEY_ANIME_NOEP, animeDB.getAnimeep());
        values.put(AttributesAnime.KEY_ANIME_AGERATING, animeDB.getAnimeage());
        values.put(AttributesAnime.KEY_ANIME_LEARNMORE, animeDB.getLearnmore());
        values.put(AttributesAnime.KEY_ANIME_TRAILERURL, animeDB.getAnimetrailer());
        values.put(AttributesAnime.KEY_ANIME_SYPNOSIS, animeDB.getAnimesypnosis());
        return db.update(AttributesAnime.ANIME_TABLE, values, AttributesAnime.KEY_ANIME_NAME + "=?", new String[]{String.valueOf(animeDB.getAnimename())});
    }

    public void deleteAnimeFromWatchList(AnimeDB animeDB) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(AttributesAnime.ANIME_TABLE, AttributesAnime.KEY_ANIME_NAME + "=?", new String[]{String.valueOf(animeDB.getAnimename())});
        db.close();
    }

    public int getCount() {
        String select = "SELECT * FROM " + AttributesAnime.ANIME_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        return cursor.getCount();
    }

//    public boolean hasObject(String fieldValue) {
//        SQLiteDatabase sqldb = this.getReadableDatabase();
//        String Query = "SELECT * FROM " + AttributesAnime.ANIME_TABLE + " WHERE " + AttributesAnime.KEY_ANIME_NAME + " =?";
//        Cursor cursor = sqldb.rawQuery(Query, new String[]{fieldValue});
//        if(cursor.getCount() <= 0){
//            cursor.close();
//            return false;
//        }
//        cursor.close();
//        return true;
//    }

    public boolean hasObject(String id) {
        SQLiteDatabase db = getWritableDatabase();
        String selectString = "SELECT * FROM " + AttributesAnime.ANIME_TABLE + " WHERE " + AttributesAnime.KEY_ANIME_NAME + " =?";
        Cursor cursor = db.rawQuery(selectString, new String[] {id});
        boolean hasObject = false;
        if(cursor.moveToFirst()){
            hasObject = true;
            int count = 0;
            while(cursor.moveToNext()){
                count++;
            }
        }
        cursor.close();
        db.close();
        return hasObject;
    }
}
