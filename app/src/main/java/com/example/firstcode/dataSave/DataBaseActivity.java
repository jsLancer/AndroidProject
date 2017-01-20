package com.example.firstcode.dataSave;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firstcode.R;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataBaseActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.create_db)
    Button createDb;
    @BindView(R.id.insert_db)
    Button insertDb;
    @BindView(R.id.delete_db)
    Button deleteDb;
    @BindView(R.id.update_db)
    Button updateDb;
    @BindView(R.id.query_db)
    Button queryDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        ButterKnife.bind(this);
        createDb.setOnClickListener(this);
        insertDb.setOnClickListener(this);
        deleteDb.setOnClickListener(this);
        updateDb.setOnClickListener(this);
        queryDb.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
        switch (v.getId()){
            case R.id.create_db:
                Toast.makeText(this, "创建数据库", Toast.LENGTH_SHORT).show();
                create();
                break;
            case R.id.insert_db:
                Toast.makeText(this, "添加数据", Toast.LENGTH_SHORT).show();
                insert();
                break;
            case R.id.delete_db:
                Toast.makeText(this, "删除数据", Toast.LENGTH_SHORT).show();
                delete();
                break;
            case R.id.query_db:
                Toast.makeText(this, "查询数据", Toast.LENGTH_SHORT).show();
                query();
                break;
            case R.id.update_db:
                Toast.makeText(this, "更新数据", Toast.LENGTH_SHORT).show();
                update();
                break;
            default:
                break;
        }
    }



    private void update() {
        Book book = new Book();
        book.setName("第一行代码");
        book.setAuthor("郭霖");
        book.setPages(570);
        book.setPrice(79);
        book.save();
        book.setName("第二行代码");
        book.setPrice(38);
        book.save();
    }

    private void query() {
        List<Book> books = DataSupport.findAll(Book.class);
        for(Book book : books){
            Log.e("Book", "book id:" + book.getId());
            Log.e("Book", "book name:" + book.getName());
            Log.e("Book", "book author:" + book.getAuthor());
            Log.e("Book", "book pages:" + book.getPages());
            Log.e("Book", "book price:" + book.getPrice());

        }
    }

    private void delete() {
        DataSupport.deleteAll(Book.class, "price < ?", "40");
    }

    private void insert() {
        Book book = new Book();
        book.setName("第一行代码");
        book.setAuthor("郭霖");
        book.setPages(570);
        book.setPrice(79);
        book.save();
    }

    private void create() {
        //创建数据库
        Connector.getDatabase();
    }
}
