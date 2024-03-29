package com.example.nyt.database;


import android.os.AsyncTask;

import com.example.nyt.database.AppDatabase;
import com.example.nyt.database.AsyncTaskDelegate;
import com.example.nyt.model.Book;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertBooksAsyncTask extends AsyncTask<Book, Integer, String> {
    // This is just a scaffold example for a task that would handle inserting books into the database.
    // You need to complete the doInBackground and onPostExecute methods.
    // Then you will need to make your own class for a task that handles retrieving Books from the
    // database.
    // Refer to the tutorial slide for more information.

    // We store a variable for an object that implements our interface, so we know that whatever
    // is in here, knows how to handle the result of our task.
    private AsyncTaskDelegate delegate;

    // This asynctask will also need to be given a database instance, so it can perform database
    // queries. If your Room database class is named something else, change this.
    private AppDatabase database;



    @Override
    protected String doInBackground(Book... books) {

        database.bookDao().insertAll(Arrays.asList(books));


        return "Insert Completed";
    }

    @Override
    protected void onPostExecute(String s) {

        delegate.handleTaskResult(s);

    }

    public void setDelegate(AsyncTaskDelegate delegate) {
        this.delegate = delegate;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }


}
