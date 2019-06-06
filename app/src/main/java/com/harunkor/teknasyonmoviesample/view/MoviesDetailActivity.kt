package com.harunkor.teknasyonmoviesample.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.harunkor.teknasyonmoviesample.R
import com.harunkor.teknasyonmoviesample.viewmodel.MoviesDetailViewModel
import com.harunkor.teknasyonmoviesample.viewmodel.MoviesViewModel
import com.google.gson.Gson

import com.harunkor.teknasyonmoviesample.model.MoviesModel


class MoviesDetailActivity : AppCompatActivity() {

    lateinit var moviesDetailViewModel: MoviesDetailViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val gson = Gson()
        val movieDataObjectAsAString = intent.getStringExtra("moviedetail")
        val movieDataObject = gson.fromJson<Any>(movieDataObjectAsAString, MoviesModel::class.java)

        moviesDetailViewModel= MoviesDetailViewModel(this, movieDataObject as MoviesModel?);





    }



}
