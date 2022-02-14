package com.swathi.swathitest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MyList extends AppCompatActivity {
    RecyclerView rcMyList;
    List<MyListData> myListDataList;


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylistings);
        rcMyList = findViewById(R.id.rcMyList);

        myListDataList = new ArrayList<>();

        myListDataList.add(new MyListData("BMI", android.R.drawable.ic_dialog_email));
        myListDataList.add(new MyListData("GRADING", android.R.drawable.ic_dialog_dialer));
        myListDataList.add(new MyListData("SERVICE", android.R.drawable.ic_dialog_alert));
        myListDataList.add(new MyListData("BROADCAST", android.R.drawable.ic_lock_idle_alarm));
        myListDataList.add(new MyListData("TOAST", android.R.drawable.ic_delete));

        MyAdapter myAdapter = new MyAdapter(myListDataList);
        rcMyList.setHasFixedSize(true);
        rcMyList.setLayoutManager(new GridLayoutManager(MyList.this, 3));
        rcMyList.setAdapter(myAdapter);
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        List<MyListData> myListDataList;

        public MyAdapter(List<MyListData> myListData) {
            this.myListDataList = myListData;
        }

        @NonNull
        @NotNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item_new, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
            MyListData listData = myListDataList.get(position);
            holder.tvTitle.setText(listData.getTitle());
            holder.imgItem.setImageResource(listData.getImg());
            holder.llayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MyList.this, listData.getTitle(), Toast.LENGTH_SHORT).show();
                    if (listData.getTitle().equalsIgnoreCase("BMI")) {
                        Intent intent = new Intent(MyList.this, BMI.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("GRADING")) {
                        Intent intent = new Intent(MyList.this, BMI.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("SERVICE")) {
                        Intent intent = new Intent(MyList.this, BMI.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("BROADCAST")) {
                        Intent intent = new Intent(MyList.this, BMI.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("TOAST")) {
                        Toast.makeText(MyList.this, listData.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


        public int getItemCount() {
            return myListDataList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            AppCompatTextView tvTitle;
            AppCompatImageView imgItem;
            LinearLayout llayout;

            public MyViewHolder(@NonNull @NotNull View itemView) {
                super(itemView);

                tvTitle = itemView.findViewById(R.id.tvTitle);
                imgItem = itemView.findViewById(R.id.imgItem);
                llayout = itemView.findViewById(R.id.layItem);


            }

        }

    }
}
