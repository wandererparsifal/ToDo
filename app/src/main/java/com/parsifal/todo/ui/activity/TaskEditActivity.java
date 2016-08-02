package com.parsifal.todo.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parsifal.todo.R;

/**
 * Created by YangMing on 2016/7/28.
 */
public class TaskEditActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);
    }
}
