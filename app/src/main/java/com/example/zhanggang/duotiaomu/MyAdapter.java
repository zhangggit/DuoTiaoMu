package com.example.zhanggang.duotiaomu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：
 * 时  间：2017/8/31 - 21:14.
 * 创建人：张刚
 */

class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Data> list;
    Context context;

    public MyAdapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //根据不同的下标 加载不同的布局
        switch (viewType) {
            case 0:
                return new ViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false));
            default:
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
                return new ViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder2) {
            ViewHolder2 mholder = (ViewHolder2) holder;
            mholder.title.setText(list.get(position).title);
        }else if (holder instanceof ViewHolder) {
            ViewHolder mholder = (ViewHolder) holder;
            Data data = list.get(position);
            String picture = data.picture;
            Log.e("TAG",picture+"1111");
            mholder.name.setText(list.get(position).name);
//            Glide.with(context).load(list.get(position).picture).into(mholder.imageview);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).type % 12;
    }

    @Override
    public int getItemCount() {
        return list.size()==0?0:list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageview;
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            imageview=itemView.findViewById(R.id.imageview_item);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        public ViewHolder2(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
