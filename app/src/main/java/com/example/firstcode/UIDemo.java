package com.example.firstcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class UIDemo extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();

    private EditText input;

    private Button sendBtn;

    private RecyclerView recyclerView;

    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uidemo);

        initMsgs();
        input = (EditText) findViewById(R.id.input);
        sendBtn = (Button) findViewById(R.id.send);
        recyclerView = (RecyclerView) findViewById(R.id.msg_list);
        adapter = new MsgAdapter(msgList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(adapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = input.getText().toString();

                if(!content.equals("")){
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    //刷新显示
                    adapter.notifyItemInserted(msgList.size() - 1);
                    //定位到最后一行
                    recyclerView.scrollToPosition(msgList.size() - 1);

                    input.setText("");
                }
            }
        });
    }

    private void initMsgs() {

        Msg msg1 = new Msg("Hello", Msg.TYPE_RECEIVED);
        Msg msg2 = new Msg("Hello", Msg.TYPE_SEND);
        Msg msg3 = new Msg("Hello", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);
    }
}
