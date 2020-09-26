package com.example.recyclerviewwithdatabinding.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import com.example.recyclerviewwithdatabinding.R;
import com.example.recyclerviewwithdatabinding.databinding.ActivityMainBinding;
import com.example.recyclerviewwithdatabinding.model.SubjectModel;
import com.example.recyclerviewwithdatabinding.view.adapter.SubjectAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private List<SubjectModel> subjectModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setUpRecyclerView();
    }

    private void setUpRecyclerView(){
        for(int i = 0 ; i < 10; i++){
            subjectModelList.add(new SubjectModel("Subject "+i, "Content "+i));
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        SubjectAdapter subjectAdapter = new SubjectAdapter(subjectModelList,getApplicationContext());
        binding.recyclerviewDatabnding.setLayoutManager(layoutManager);
        binding.recyclerviewDatabnding.setAdapter(subjectAdapter);
    }

}