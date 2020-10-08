package com.robi.tenminuteschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.robi.tenminuteschool.adapter.AdapterMainList;
import com.robi.tenminuteschool.databinding.ActivityMainBinding;
import com.robi.tenminuteschool.model.ItemSub;
import com.robi.tenminuteschool.model.Items;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding bindingMain;
    private AdapterMainList mAdapter;
    private List<Items> itemsList = new ArrayList<>();
    private List<ItemSub> itemSubList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingMain = ActivityMainBinding.inflate(getLayoutInflater());
        View view = bindingMain.getRoot();
        setContentView(view);

        initView();
    }

    private void initView() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        bindingMain.rvList.setLayoutManager(layoutManager);

        mAdapter = new AdapterMainList(itemsList, MainActivity.this);
        bindingMain.rvList.setItemAnimator(new DefaultItemAnimator());
        bindingMain.rvList.setAdapter(mAdapter);

        prepareItems();
    }

    //preparing data for main list
    private void prepareItems() {
        Items customList = new Items("Chapter 1", 0, getSubItems("Chapter 1"));
        itemsList.add(customList);

        customList = new Items("Chapter 2", 0, getSubItems("Chapter 2"));
        itemsList.add(customList);

        customList = new Items("Video 3_0", R.drawable.video, null);
        itemsList.add(customList);

        customList = new Items("Document 4_0", R.drawable.documents, null);
        itemsList.add(customList);

        mAdapter.notifyDataSetChanged();
    }

    //preparing sub list data
    private List<ItemSub> getSubItems(String chapterName) {
        itemSubList = new ArrayList<>();
        ItemSub itemSub;
        switch (chapterName) {
            case "Chapter 1":
                itemSub = new ItemSub("Video 1_1", "", R.drawable.video);
                itemSubList.add(itemSub);

                itemSub = new ItemSub("Document 1_1", "Document caption", R.drawable.documents);
                itemSubList.add(itemSub);

                itemSub = new ItemSub("Video 1_2", "", R.drawable.video);
                itemSubList.add(itemSub);
                break;
            case "Chapter 2":
                itemSub = new ItemSub("Document 2_1", "Document caption", R.drawable.documents);
                itemSubList.add(itemSub);

                itemSub = new ItemSub("Video 2_1", "", R.drawable.video);
                itemSubList.add(itemSub);

                itemSub = new ItemSub("Video 2_2", "", R.drawable.video);
                itemSubList.add(itemSub);

                itemSub = new ItemSub("Audio 2_1", "", R.drawable.audio);
                itemSubList.add(itemSub);
                break;
        }
        return itemSubList;
    }
}