package com.example.todolist;

import com.example.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    public void initialize(){
        TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card fot Jhon",
                LocalDate.of(2016, Month.APRIL, 25));
        TodoItem item2 = new TodoItem("Doctor's Appointment", "See Dr. Smith",
                LocalDate.of(2016, Month.APRIL, 25));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();

        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadLine().toString());

        itemDetailsTextArea.setText(sb.toString());
    }
}
