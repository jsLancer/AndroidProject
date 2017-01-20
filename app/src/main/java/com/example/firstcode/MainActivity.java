package com.example.firstcode;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstcode.util.BaseActivity;

public class MainActivity extends BaseActivity {

    TextView textView;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.btn1);

        if (savedInstanceState != null) {
            String data = savedInstanceState.getString("data");
            Log.d("data", data);
            textView.setText(data);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.firstcode.BroadcastReceiver.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String data = "String Data";
        outState.putString("data", data);
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        //true显示 false无法显示
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this);
//                String data = "String Data";
//                intent.putExtra("data", data);
//                startActivity(intent);
                showAlert();
                break;
            case R.id.remove_item:
                progressDiaog.dismiss();
                Toast.makeText(this, "Remove", Toast.LENGTH_SHORT).show();
                break;
            case R.id.app_bar_search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    ProgressDialog progressDiaog;
    private void showAlert() {
        progressDiaog = new ProgressDialog(this);
        progressDiaog.setTitle("Title");
        progressDiaog.setMessage("Loading...");
        progressDiaog.setCancelable(true);
        progressDiaog.show();

    }


}
