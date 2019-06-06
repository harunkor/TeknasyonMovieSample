package com.harunkor.teknasyonmoviesample.view


import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.harunkor.teknasyonmoviesample.R
import com.harunkor.teknasyonmoviesample.adapter.RecyclerViewAdapter
import com.harunkor.teknasyonmoviesample.databinding.ActivityMoviesBinding
import com.harunkor.teknasyonmoviesample.viewmodel.MoviesViewModel
import com.harunkor.teknasyonmoviesample.paging.ItemViewModel
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.support.v7.widget.LinearLayoutManager
import com.harunkor.teknasyonmoviesample.model.MoviesModel
import android.content.Intent
import com.google.gson.Gson








class MoviesActivity : AppCompatActivity(),  RecyclerViewAdapter.ClickListener   {


     lateinit var moviesBinding: ActivityMoviesBinding

    lateinit var moviesViewModel: MoviesViewModel;


    lateinit var recyclerViewAdapter:RecyclerViewAdapter;

    lateinit var itemViewModel:ItemViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel::class.java)



                moviesBinding = DataBindingUtil.setContentView(this, R.layout.activity_movies)

               moviesBinding.myrecyclerview.setLayoutManager( LinearLayoutManager(this));

                moviesBinding.myrecyclerview.setHasFixedSize(true);





                recyclerViewAdapter = RecyclerViewAdapter(applicationContext,this)



                    itemViewModel.itemPagedList.observe(this,
                        Observer<PagedList<MoviesModel>> {
                                items -> recyclerViewAdapter.submitList(items)
                        })




                moviesBinding.setMyAdapter(recyclerViewAdapter);














    }



     override fun launchIntent( moviesModel: MoviesModel) {

         val gson = Gson()
         val MoviesDataObjectAsAString = gson.toJson(moviesModel)

         startActivity(Intent(this, MoviesDetailActivity::class.java).putExtra("moviedetail", MoviesDataObjectAsAString))

         Toast.makeText(applicationContext, "click item! - "+ moviesModel.name, Toast.LENGTH_SHORT).show()


     }







}
