package com.swathi.swathitest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MyCardetails extends AppCompatActivity {
    RecyclerView carrecycularview;
    List<MyCarModel> myListDataList;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardetails1);
        carrecycularview = findViewById(R.id.carrecycularview);

        myListDataList = new ArrayList<>();

        myListDataList.add(new MyCarModel("Tata Taigo", "TS08UB6005", "250000", "14-1-2018", android.R.drawable.ic_menu_report_image));
        myListDataList.add(new MyCarModel("Honda Amaze", "AP05EN9335", "300000", "17-07-2020", android.R.drawable.ic_menu_report_image));
        myListDataList.add(new MyCarModel("BMW", "TS08FA8489", "350000", "23-10-2017", android.R.drawable.ic_menu_report_image));
        myListDataList.add(new MyCarModel("Audi", "AP05EB848", "400000", "02-12-2015", android.R.drawable.ic_menu_report_image));

        MyAdapter myAdapter = new MyAdapter(myListDataList);
        carrecycularview.setHasFixedSize(true);
        carrecycularview.setLayoutManager(new LinearLayoutManager(this));
        //carrecycularview.setLayoutManager(new GridLayoutManager(this,3));
        carrecycularview.setAdapter(myAdapter);

    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        List<MyCarModel> myListDataList;

        public MyAdapter(List<MyCarModel> myListData) {
            this.myListDataList = myListData;
        }

        @NonNull
        @NotNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardetails, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
            MyCarModel listData = myListDataList.get(position);
            holder.title.setText(listData.getTitle());
            holder.regno.setText(listData.getRegno());
            holder.price.setText(listData.getPrice());
            holder.reg_date.setText(listData.getReg_date());
            holder.carimage.setImageResource(listData.getMyImage());
            holder.linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MyCardetails.this, "Welcome to Car World", Toast.LENGTH_SHORT).show();
                }

            });
            holder.imgclear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MyCardetails.this, "Closing the window", Toast.LENGTH_SHORT).show();
                }
            });
            holder.carimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MyCardetails.this, "Zoom in or Zoom out", Toast.LENGTH_SHORT).show();
                }
            });
        }


        public int getItemCount() {
            return myListDataList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            AppCompatTextView title, price, regno, reg_date;
            LinearLayout linear;
            AppCompatImageView imgclear, carimage;

            public MyViewHolder(@NonNull @NotNull View itemView) {
                super(itemView);

                title = itemView.findViewById(R.id.title);
                regno = itemView.findViewById(R.id.regno);
                price = itemView.findViewById(R.id.price);
                reg_date = itemView.findViewById(R.id.reg_date);
                imgclear = itemView.findViewById(R.id.imgClear);
                linear = itemView.findViewById(R.id.linear);
                carimage = itemView.findViewById(R.id.carimage);
            }

        }

    }
}

