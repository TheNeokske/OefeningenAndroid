package be.kdg.todo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import be.kdg.todo.model.ToDoItem;
import be.kdg.todo.model.ToDoList;

public class ToDoDao {
    private final SQLiteDatabase database;
    private final ToDoDbHelper dbHelper;

    public ToDoDao(Context context) {
        dbHelper = new ToDoDbHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ToDoItem insertToDoItem(String description) {
        // TODO
        ContentValues contentValues = new ContentValues();
        contentValues.put(ToDoContract.ToDoEntry.COLUMN_NAME_DESC, description);
        return new ToDoItem(database.insert(ToDoContract.ToDoEntry.TABLE_NAME, null, contentValues), description);
    }

    public void deleteToDoItem(ToDoItem item) {
        // TODO
        String selection = ToDoContract.ToDoEntry.COLUMN_NAME_DESC + " LIKE ?";
        String[] selectionArgs = {item.getDescription()};
        database.delete(ToDoContract.ToDoEntry.TABLE_NAME, selection, selectionArgs);
    }

    public ToDoList getAllToDoItems() {
        // TODO

        ToDoList toDoList = new ToDoList();

        Cursor cursor = database.rawQuery("select * from " + ToDoContract.ToDoEntry.TABLE_NAME,null);
        while (cursor.moveToNext()){
            String desc = cursor.getString(cursor.getColumnIndex(ToDoContract.ToDoEntry.COLUMN_NAME_DESC));
            long id = cursor.getLong(0);
            ToDoItem toDoItem = new ToDoItem(id,desc);
            toDoList.addItem(toDoItem);
        }

        return toDoList;
    }
}
