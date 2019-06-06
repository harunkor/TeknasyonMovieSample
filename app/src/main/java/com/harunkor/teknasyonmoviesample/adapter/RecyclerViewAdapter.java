package com.harunkor.teknasyonmoviesample.adapter;

import android.annotation.SuppressLint;
import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.databinding.library.baseAdapters.BR;
import com.harunkor.teknasyonmoviesample.R;
import com.harunkor.teknasyonmoviesample.model.MoviesModel;

public class RecyclerViewAdapter  extends PagedListAdapter<MoviesModel, RecyclerViewAdapter.ViewHolder> {




    private Context context;
    private RecyclerViewAdapter.ClickListener clickListener;

    public RecyclerViewAdapter( Context ctx,ClickListener clickListener) {
        super(DIFF_CALLBACK);
        this.clickListener=clickListener;
        this.context = ctx;

    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.recycler_list_row, viewGroup, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int i) {

        viewHolder.bind(getItem(i));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.launchIntent(getItem(i));
            }
        });

    }





    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewDataBinding itemRowBinding;

        public ViewHolder(ViewDataBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.dataMovies, obj);
            itemRowBinding.executePendingBindings();
        }
    }


    public interface ClickListener {
        void launchIntent(MoviesModel moviesModel);
    }


    private static DiffUtil.ItemCallback<MoviesModel> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MoviesModel>() {

                @Override
                public boolean areItemsTheSame( MoviesModel oldItem,  MoviesModel newItem) {
                    return oldItem.getId()==newItem.getId();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(MoviesModel oldItem,  MoviesModel newItem) {
                    return oldItem.equals(newItem);
                }
            };




}
