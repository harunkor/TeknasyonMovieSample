package com.harunkor.teknasyonmoviesample.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.harunkor.teknasyonmoviesample.R;
import com.squareup.picasso.Picasso;

public class MoviesModel {

    @SerializedName("original_name")
    @Expose
    private String original_name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("popularity")
    @Expose
    private String popularity;
    @SerializedName("vote_count")
    @Expose
    private String vote_count;
    @SerializedName("vote_average")
    @Expose
    private String vote_average;
    @SerializedName("first_air_date")
    @Expose
    private String first_air_date;
    @SerializedName("poster_path")
    @Expose
    private String poster_path;
    @SerializedName("original_language")
    @Expose
    private String original_language;
    @SerializedName("backdrop_path")
    @Expose
    private String backdrop_path;
    @SerializedName("overview")
    @Expose
    private String overview;

    String imageUrl;
    String rating;


    @BindingAdapter("imgurl")
    public static void loadImage(ImageView view, String imageUrl) {
        String url="http://image.tmdb.org/t/p/w185/";
        Picasso.get().load(url+imageUrl).error(R.drawable.none_poster).into(view);
    }


    @BindingAdapter("ratingValue")
    public static void setRating(com.fuzzproductions.ratingbar.RatingBar view, String rating) {

        if (view!=null)
        {

            float rate= Float.parseFloat(rating);
            view.setRating(rate);

        }
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopularity() {
        return popularity;
    }


    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }


    public String getVote_count() {
        return vote_count;
    }


    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }


    public String getVote_average() {
        return vote_average;
    }


    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }


    public String getFirst_air_date() {
        return first_air_date;
    }


    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }


    public String getPoster_path() {
        return poster_path;
    }


    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }


    public String getOriginal_language() {
        return original_language;
    }


    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }


    public String getBackdrop_path() {
        return backdrop_path;
    }


    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
