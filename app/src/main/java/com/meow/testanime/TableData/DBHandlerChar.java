package com.meow.testanime.TableData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.meow.testanime.Attributes.AttributesChar;
import com.meow.testanime.DBModels.CharDB;

import java.util.ArrayList;
import java.util.List;

public class DBHandlerChar extends SQLiteOpenHelper {

    public DBHandlerChar(Context context) {
        super(context, AttributesChar.DB_NAME, null, AttributesChar.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE " + AttributesChar.CHAR_TABLE + "(" + AttributesChar.KEY_CHAR_NAME + " TEXT PRIMARY KEY, " + AttributesChar.KEY_CHAR_IMGURL + " TEXT, " + AttributesChar.KEY_CHAR_LEARNMORE + " TEXT, " + AttributesChar.KEY_CHAR_ABOUT + " TEXT" + ")";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addCharWatchList(CharDB charDB) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AttributesChar.KEY_CHAR_NAME, charDB.getCharname());
        values.put(AttributesChar.KEY_CHAR_IMGURL, charDB.getImgurl());
        values.put(AttributesChar.KEY_CHAR_LEARNMORE, charDB.getLearnmore());
        values.put(AttributesChar.KEY_CHAR_ABOUT, charDB.getCharabout());
        db.insert(AttributesChar.CHAR_TABLE, null, values);
        db.close();
    }

    public List<CharDB> getCharWatchList() {
        List<CharDB> charList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + AttributesChar.CHAR_TABLE;
        Cursor cursor = db.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                CharDB charDB = new CharDB();
                charDB.setCharname(cursor.getString(0));
                charDB.setImgurl(cursor.getString(1));
                charDB.setLearnmore(cursor.getString(2));
                charDB.setCharabout(cursor.getString(3));
                charList.add(charDB);
            } while (cursor.moveToNext());
        }
        return charList;
    }

    public int updateChar(CharDB charDB) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AttributesChar.KEY_CHAR_NAME, charDB.getCharname());
        values.put(AttributesChar.KEY_CHAR_IMGURL, charDB.getImgurl());
        values.put(AttributesChar.KEY_CHAR_LEARNMORE, charDB.getLearnmore());
        values.put(AttributesChar.KEY_CHAR_ABOUT, charDB.getCharabout());
        return db.update(AttributesChar.CHAR_TABLE, values, AttributesChar.KEY_CHAR_NAME + "=?", new String[]{String.valueOf(charDB.getCharname())});
    }

    public void deleteCharFromWatchList(CharDB charDB) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(AttributesChar.CHAR_TABLE, AttributesChar.KEY_CHAR_NAME + "=?", new String[]{String.valueOf(charDB.getCharname())});
        db.close();
    }

    public int getCount() {
        String select = "SELECT * FROM " + AttributesChar.CHAR_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        return cursor.getCount();
    }

    public boolean hasObject(String fieldValue) {
        SQLiteDatabase sqldb = this.getReadableDatabase();
        String Query = "SELECT * FROM " + AttributesChar.CHAR_TABLE + " WHERE " + AttributesChar.KEY_CHAR_NAME + " =?";
        Cursor cursor = sqldb.rawQuery(Query, new String[]{fieldValue});
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
}
