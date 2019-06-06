package com.harunkor.teknasyonmoviesample.paging;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;
import com.harunkor.teknasyonmoviesample.model.MoviesModel;

public class ItemViewModel extends ViewModel {

    public  LiveData<PagedList<MoviesModel>> itemPagedList;
  public   LiveData<PageKeyedDataSource<Integer, MoviesModel>> liveDataSource;

    public ItemViewModel() {

        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE)
                        .build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();

    }
}