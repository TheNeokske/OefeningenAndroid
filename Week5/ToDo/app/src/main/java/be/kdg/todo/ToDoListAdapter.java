package be.kdg.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import be.kdg.todo.db.ToDoDao;
import be.kdg.todo.model.ToDoItem;
import be.kdg.todo.model.ToDoList;

public class ToDoListAdapter extends BaseAdapter {
    private final Context context;
    private final ToDoDao toDoDao;
    private final ToDoList toDoList;


    public ToDoListAdapter(Context context, ToDoDao toDoDao, ToDoList toDoList) {
        this.context = context;
        this.toDoDao = toDoDao;
        this.toDoList = toDoList;
    }

    @Override
    public int getCount() {
        return this.toDoList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout layout;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (RelativeLayout)inflater.inflate(R.layout.list_item_todo, parent, false);
        }
        else {
            layout = (RelativeLayout)convertView;
        }

        final ToDoItem item = this.toDoList.getItem(position);

        TextView todoText = (TextView) layout.findViewById(R.id.todo_text);
        todoText.setText(item.getDescription());

        Button delete = (Button) layout.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: verwijderen DB en verwijderen lijst
                toDoDao.deleteToDoItem(item);
                toDoList.remove(item);

                ToDoListAdapter.this.notifyDataSetChanged();
            }
        });

        return layout;
    }
}
