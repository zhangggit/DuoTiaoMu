package com.example.zhanggang.duotiaomu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    List<Data> list = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

        adapter = new MyAdapter(list,this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,12);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //得到类型
                int type = adapter.getItemViewType(position);
                switch (type){
                    case 0:
                        return 12;  //下标0的数据占12单位
                    case 1:
                        return 4;   //下标1的数据占4个单位
                    case 2:
                        return 4;
                    case 3:
                        return 4;
                    case 4:
                        return 3;   //下标4的数据占3个单位
                    case 5:
                        return 3;
                    case 6:
                        return 3;
                    case 7:
                        return 3;
                    case 8:
                        return 6;   //下标8的数据占4个单位
                    case 9:
                        return 6;
                    default:
                        return 4;
                }
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void init() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 30; i++) {
                    Data data = new Data("主题", "名字" + i, "http://cover2.u17i.com/2017/05/5475960_1495520371_2LOf5OgcNCkN.sbig.jpg");
                    data.setType(i);
                    list.add(data);
                }
            }
        }.start();
    }
}
