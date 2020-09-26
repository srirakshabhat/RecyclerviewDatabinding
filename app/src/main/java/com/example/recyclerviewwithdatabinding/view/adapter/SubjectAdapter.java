package com.example.recyclerviewwithdatabinding.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerviewwithdatabinding.R;
import com.example.recyclerviewwithdatabinding.databinding.ItemSubjectBinding;
import com.example.recyclerviewwithdatabinding.model.SubjectModel;
import com.example.recyclerviewwithdatabinding.view.interfaces.Subject;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {
    private List<SubjectModel> subjectModelList;
    private Context context;

    public SubjectAdapter(List<SubjectModel> subjectModelList, Context context) {
        this.subjectModelList = subjectModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSubjectBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_subject,parent,false);
        return new SubjectViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        SubjectModel subjectModel = subjectModelList.get(position);
        holder.binding.setSubjectModel(subjectModel);
    }

    @Override
    public int getItemCount() {
        return subjectModelList.size();
    }

    public static class SubjectViewHolder extends RecyclerView.ViewHolder implements Subject {
        ItemSubjectBinding binding;
        public SubjectViewHolder(@NonNull ItemSubjectBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            binding.setSubjectHandler(this);
        }

        @Override
        public void onContentClickListener(View view) {
            Toast.makeText(view.getContext() , "Hurray! You Clicked On Content "+ getAdapterPosition() , Toast.LENGTH_SHORT).show();
        }
    }
}
