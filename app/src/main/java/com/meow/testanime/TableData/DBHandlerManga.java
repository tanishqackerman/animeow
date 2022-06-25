package com.meow.testanime.TableData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.meow.testanime.Attributes.AttributesAnime;
import com.meow.testanime.Attributes.AttributesManga;
import com.meow.testanime.DBModels.MangaDB;

import java.util.ArrayList;
import java.util.List;

public class DBHandlerManga extends SQLiteOpenHelper {

    public DBHandlerManga(Context context) {
        super(context, AttributesManga.DB_NAME, null, AttributesManga.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE " + AttributesManga.MANGA_TABLE + "(" + AttributesManga.KEY_MANGA_NAME + " TEXT PRIMARY KEY, " + AttributesManga.KEY_MANGA_IMGURL + " TEXT, " + AttributesManga.KEY_MANGA_SCORE + " TEXT, " + AttributesManga.KEY_MANGA_PUBLISHPERIOD + " TEXT, " + AttributesManga.KEY_MANGA_NOCH + " TEXT, " + AttributesManga.KEY_MANGA_VOLUMES + " TEXT, " + AttributesManga.KEY_MANGA_LEARNMORE + " TEXT, " + AttributesManga.KEY_MANGA_ABOUT + " TEXT" + ")";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addMangaWatchList(MangaDB mangaDB) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AttributesManga.KEY_MANGA_NAME, mangaDB.getAnimename());
        values.put(AttributesManga.KEY_MANGA_IMGURL, mangaDB.getImgurl());
        values.put(AttributesManga.KEY_MANGA_SCORE, mangaDB.getMangascore());
        values.put(AttributesManga.KEY_MANGA_PUBLISHPERIOD, mangaDB.getMangapublishingperiod());
        values.put(AttributesManga.KEY_MANGA_NOCH, mangaDB.getMangach());
        values.put(AttributesManga.KEY_MANGA_VOLUMES, mangaDB.getMangavol());
        values.put(AttributesManga.KEY_MANGA_LEARNMORE, mangaDB.getLearnmore());
        values.put(AttributesManga.KEY_MANGA_ABOUT, mangaDB.getMangaabout());
        db.insert(AttributesManga.MANGA_TABLE, null, values);
        db.close();
    }

    public List<MangaDB> getMangaWatchList() {
        List<MangaDB> mangaWatchList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + AttributesManga.MANGA_TABLE;
        Cursor cursor = db.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                MangaDB mangaDB = new MangaDB();
                mangaDB.setAnimename(cursor.getString(0));
                mangaDB.setImgurl(cursor.getString(1));
                mangaDB.setMangascore(cursor.getString(2));
                mangaDB.setMangapublishingperiod(cursor.getString(3));
                mangaDB.setMangach(cursor.getString(4));
                mangaDB.setMangavol(cursor.getString(5));
                mangaDB.setLearnmore(cursor.getString(6));
                mangaDB.setMangaabout(cursor.getString(7));
                mangaWatchList.add(mangaDB);
            } while (cursor.moveToNext());
        }
        return mangaWatchList;
    }

    public int updateManga(MangaDB mangaDB) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AttributesManga.KEY_MANGA_NAME, mangaDB.getAnimename());
        values.put(AttributesManga.KEY_MANGA_IMGURL, mangaDB.getImgurl());
        values.put(AttributesManga.KEY_MANGA_SCORE, mangaDB.getMangascore());
        values.put(AttributesManga.KEY_MANGA_PUBLISHPERIOD, mangaDB.getMangapublishingperiod());
        values.put(AttributesManga.KEY_MANGA_NOCH, mangaDB.getMangach());
        values.put(AttributesManga.KEY_MANGA_VOLUMES, mangaDB.getMangavol());
        values.put(AttributesManga.KEY_MANGA_LEARNMORE, mangaDB.getLearnmore());
        values.put(AttributesManga.KEY_MANGA_ABOUT, mangaDB.getMangaabout());
        return db.update(AttributesManga.MANGA_TABLE, values, AttributesManga.KEY_MANGA_NAME + "=?", new String[]{String.valueOf(mangaDB.getAnimename())});
    }

    public void deleteMangaFromWatchList(MangaDB mangaDB) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(AttributesManga.MANGA_TABLE, AttributesManga.KEY_MANGA_NAME + "=?", new String[]{String.valueOf(mangaDB.getAnimename())});
        db.close();
    }

    public int getCount() {
        String select = "SELECT * FROM " + AttributesManga.MANGA_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        return cursor.getCount();
    }

    public boolean hasObject(String fieldValue) {
        SQLiteDatabase sqldb = this.getReadableDatabase();
        String Query = "SELECT * FROM " + AttributesManga.MANGA_TABLE + " WHERE " + AttributesManga.KEY_MANGA_NAME + " =?";
        Cursor cursor = sqldb.rawQuery(Query, new String[]{fieldValue});
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
}
