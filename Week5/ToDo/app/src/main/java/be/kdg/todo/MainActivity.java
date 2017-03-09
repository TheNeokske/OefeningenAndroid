package be.kdg.todo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import be.kdg.todo.db.ToDoDao;
import be.kdg.todo.model.ToDoList;

public class MainActivity extends Activity {
    private EditText todoMessage;
    private Button addButton;
    private ListView listView;

    private ToDoDao toDoDao;
    private ToDoList toDoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseViews();
        addEventHandlers();

        toDoDao = new ToDoDao(this.getApplicationContext());
        toDoList = toDoDao.getAllToDoItems();

        ToDoListAdapter adapter = new ToDoListAdapter(this, toDoDao, toDoList);
        this.listView.setAdapter(adapter);
    }

    private void initialiseViews() {
        this.todoMessage = (EditText) findViewById(R.id.input_item);
        this.addButton = (Button) findViewById(R.id.add);
        this.listView = (ListView) findViewById(R.id.list_todo);
    }

    private void addEventHandlers() {
        this.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text;
                synchronized (this) {
                    text = todoMessage.getText().toString();
                    todoMessage.setText("");
                }

                if (!text.isEmpty()) {
                    // TODO: toevoegen DB en toevoegen lijst
                    toDoList.addItem(toDoDao.insertToDoItem(text));

                    ((ToDoListAdapter)listView.getAdapter()).notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        toDoDao.close();
        super.onDestroy();
    }
}
