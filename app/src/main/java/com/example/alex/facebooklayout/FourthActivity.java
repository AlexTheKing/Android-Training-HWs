package com.example.alex.facebooklayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    private Controller controller = new Controller(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
    }

    public void btnClick(View view) {
        EditText etext = (EditText) findViewById(R.id.editName);
        String userName = etext.getText().toString();
        if(TextUtils.isEmpty(userName)){
            printData("No name is entered");
            return;
        }
        controller.getGithub(userName);
        view.setEnabled(false);
    }

    public void printData(String data) {
        TextView tview = (TextView) findViewById(R.id.githubView);
        tview.setText(data);
        findViewById(R.id.btnGit).setEnabled(true);
    }

}
