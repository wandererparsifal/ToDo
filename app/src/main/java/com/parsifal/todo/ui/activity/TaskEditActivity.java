package com.parsifal.todo.ui.activity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parsifal.todo.R;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by YangMing on 2016/7/28.
 */
public class TaskEditActivity extends AppCompatActivity {

    private Toolbar toolbar = null;

    private MaterialEditText mEditTitle = null;

    private MaterialEditText mEditContent = null;

    private boolean isTitleExist = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);

        toolbar = (Toolbar) findViewById(R.id.toolbar_task_edit);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.vector_drawable_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_edit_done:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        mEditTitle = (MaterialEditText) findViewById(R.id.edit_title);
        mEditTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (0 == s.length()) {
                    if (isTitleExist) {
                        isTitleExist = !isTitleExist;
                        invalidateOptionsMenu();
                    }
                } else {
                    if (!isTitleExist) {
                        isTitleExist = !isTitleExist;
                        invalidateOptionsMenu();
                    }
                }
            }
        });
        mEditContent = (MaterialEditText) findViewById(R.id.edit_content);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.taskedit, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (isTitleExist) {
            menu.findItem(R.id.action_edit_done).setVisible(true);
            if (Build.VERSION.SDK_INT >= 23) {
                Drawable drawable = menu.findItem(R.id.action_edit_done).getIcon();
                final AnimatedVectorDrawable vectorDrawable = (android.graphics.drawable.AnimatedVectorDrawable) drawable;
                vectorDrawable.start();
            }
        } else {
            menu.findItem(R.id.action_edit_done).setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
