package be.kdg.todo.db;

import android.provider.BaseColumns;

public final class ToDoContract {
    private ToDoContract() {
    }

    public static class ToDoEntry implements BaseColumns {
        // TODO
        public static final String TABLE_NAME = "To_Do";
        public static final String COLUMN_NAME_DESC = "Taak";

        public static final String[] ALL_COLUMNS = {
                _ID,
                COLUMN_NAME_DESC
        };
    }
}
