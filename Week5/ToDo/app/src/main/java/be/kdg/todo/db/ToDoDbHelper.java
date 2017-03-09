package be.kdg.todo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ToDoDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ToDo.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ToDoContract.ToDoEntry.TABLE_NAME + "(" + ToDoContract.ToDoEntry.COLUMN_NAME_DESC + ")"; // TODO: gebruik Contract om SQL te vervolledigen

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ToDoContract.ToDoEntry.TABLE_NAME; // TODO: gebruik Contract om SQL te vervolledigen

    public ToDoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

        ///////////////
        // TEST DATA //
        ///////////////
        // TODO: uit commentaar zetten
        ContentValues values = new ContentValues();
        values.put(ToDoContract.ToDoEntry.COLUMN_NAME_DESC, "Verjaardagscadeau oma kopen");
        db.insert(ToDoContract.ToDoEntry.TABLE_NAME, null, values);
        values.put(ToDoContract.ToDoEntry.COLUMN_NAME_DESC, "Oefening UI2 maken");
        db.insert(ToDoContract.ToDoEntry.TABLE_NAME, null, values);
        values.put(ToDoContract.ToDoEntry.COLUMN_NAME_DESC, "Batterij smartphone vervangen");
        db.insert(ToDoContract.ToDoEntry.TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
