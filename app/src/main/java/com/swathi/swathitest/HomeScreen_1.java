package com.swathi.swathitest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen_1 extends AppCompatActivity {
    RecyclerView gridview;
    List<HomeScreen> myListdataList;

    public HomeScreen_1() {

    }

    public HomeScreen_1(RecyclerView gridview) {
        this.gridview = gridview;
    }

    public HomeScreen_1(int contentLayoutId, RecyclerView gridview) {
        super(contentLayoutId);
        this.gridview = gridview;
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview1);
        gridview = findViewById(R.id.gridview);
        myListdataList = new ArrayList<>();

        myListdataList.add(new HomeScreen("BMI", android.R.drawable.ic_media_ff));
        myListdataList.add(new HomeScreen("GRADING", android.R.drawable.ic_media_next));
        myListdataList.add(new HomeScreen("SERVICE", android.R.drawable.ic_media_pause));
        myListdataList.add(new HomeScreen("INTENT", android.R.drawable.ic_media_play));
        myListdataList.add(new HomeScreen("TOAST", android.R.drawable.ic_media_previous));
        myListdataList.add(new HomeScreen("RECYCLERVIEW", android.R.drawable.ic_media_pause));
        myListdataList.add(new HomeScreen("BROADCAST", android.R.drawable.ic_media_pause));
        myListdataList.add(new HomeScreen("STORAGE", android.R.drawable.ic_media_pause));
        myListdataList.add(new HomeScreen("SHAREDPREFERENCE", android.R.drawable.ic_media_ff));
        myListdataList.add(new HomeScreen("POPUP", android.R.drawable.ic_media_ff));
        myListdataList.add(new HomeScreen("SIMPLECALCULATOR", android.R.drawable.ic_media_next));
        myListdataList.add(new HomeScreen("THREAD", android.R.drawable.ic_media_next));
        myListdataList.add(new HomeScreen("LOCATION", android.R.drawable.ic_media_pause));
        myListdataList.add(new HomeScreen("FRAGMENT", android.R.drawable.ic_media_pause));



        MyAdapter myAdapter = new MyAdapter(myListdataList);
        gridview.setHasFixedSize(true);
        gridview.setLayoutManager(new GridLayoutManager(HomeScreen_1.this, 2));
        gridview.setAdapter(myAdapter);
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        List<HomeScreen> data;

        public MyAdapter(List<HomeScreen> myListData) {
            this.data = myListData;
        }

        @NonNull
        @NotNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_homescreen, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
            HomeScreen listData = data.get(position);
            holder.title.setText(listData.getTitle());
            holder.imgItem.setImageResource(listData.getImg());
            holder.llayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(HomeScreen_1.this, listData.getTitle(), Toast.LENGTH_SHORT).show();
                    if (listData.getTitle().equalsIgnoreCase("BMI")) {
                        Intent intent = new Intent(HomeScreen_1.this, BMI.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("GRADING")) {
                        Intent intent = new Intent(HomeScreen_1.this, Grading.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("SERVICE")) {
                        Intent intent = new Intent(HomeScreen_1.this, ServiceActivity.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("INTENT")) {
                        Intent impIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cartrade.com/"));
                        startActivity(impIntent);
                    } else if (listData.getTitle().equalsIgnoreCase("TOAST")) {
                        //Toast.makeText(HomeScreen_1.this, "Toast has been clicked", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HomeScreen_1.this, LifeCycleActivity.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("RECYCLERVIEW")) {
                        Intent intent = new Intent(HomeScreen_1.this, MyCardetails.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("BROADCAST")) {
                        Intent intent = new Intent(HomeScreen_1.this, Broadcast.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("STORAGE")) {
                        Intent intent = new Intent(HomeScreen_1.this, Storage.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("SHAREDPREFERENCE")) {
                        Intent intent = new Intent(HomeScreen_1.this, SharedPreference.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("POPUP")) {
                        Intent intent = new Intent(HomeScreen_1.this, ClickPopup.class);
                        startActivity(intent);
                    } else if (listData.getTitle().equalsIgnoreCase("SIMPLECALCULATOR")) {
                        Intent intent = new Intent(HomeScreen_1.this, SimpleCalculator.class);
                        startActivity(intent);

                    }else if (listData.getTitle().equalsIgnoreCase("THREAD")) {
                        Intent intent = new Intent(HomeScreen_1.this, MyThread.class);
                        startActivity(intent);
                    }
                    else if (listData.getTitle().equalsIgnoreCase("LOCATION")) {
                        Intent intent = new Intent(HomeScreen_1.this, MyLocation.class);
                        startActivity(intent);

                    }

                    else if (listData.getTitle().equalsIgnoreCase("FRAGMENT")) {
                        Intent intent = new Intent(HomeScreen_1.this, Fragment.class);
                        startActivity(intent);

                    }
                }


            });

        }


        public int getItemCount() {
            return data.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            AppCompatTextView title;
            AppCompatImageView imgItem;
            LinearLayout llayout;

            public MyViewHolder(@NonNull @NotNull View itemView) {
                super(itemView);

                title = itemView.findViewById(R.id.title);
                imgItem = itemView.findViewById(R.id.imgItem);
                llayout = itemView.findViewById(R.id.llayout);

            }

        }


    }
}


