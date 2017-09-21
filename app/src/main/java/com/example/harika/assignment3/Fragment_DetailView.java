package com.example.harika.assignment3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.test.suitebuilder.TestMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;


public class Fragment_DetailView extends Fragment {
    private static final String ARG_MOVIE = "movie";
    private HashMap<String, ?>movie;
    TextView movieTitle;
    TextView movieRating;
    TextView movieReleaseDate;
    TextView movieSynopsis;
    SimpleDraweeView moviePosterImage;
    List<Map<String, ?>> moviesList;
    MovieBean movieBean;
    public static Fragment_DetailView newInstance(HashMap<String,?> movie)
    {
        Fragment_DetailView fragment = new Fragment_DetailView();
        Bundle args = new Bundle();
        args.putSerializable(ARG_MOVIE,movie);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_DetailView() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movie = ((HashMap<String,?>)getArguments().getSerializable(ARG_MOVIE));}
    }
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(movie == null)
        {
            movieBean = new MovieBean();
            moviesList = movieBean.getMoviesList();
        }

        View rootView = inflater.inflate(R.layout.fragment_fragment__detail_view, container, false);
        movieTitle = (TextView)rootView.findViewById(R.id.movieTitle);
        movieReleaseDate = (TextView)rootView.findViewById(R.id.movieReleaseDate);
        movieRating = (TextView) rootView.findViewById(R.id.movieRating);
        movieSynopsis = (TextView) rootView.findViewById(R.id.movieSynopsis);
        moviePosterImage = (SimpleDraweeView)rootView.findViewById(R.id.movieImage);
        movieTitle.setText((CharSequence) movie.get("title"));
        StringBuffer voteAverage = new StringBuffer(String.valueOf(movie.get("voteAverage")));
        movieRating.setText(voteAverage.append("/10"));
        movieReleaseDate.setText((CharSequence) movie.get("release"));
        movieSynopsis.setText((CharSequence) movie.get("overview"));
        Uri poster_uri = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(movie.get("image")))
                .build();

        Log.d("poster_uri",String.valueOf(poster_uri));
        moviePosterImage.setImageURI(poster_uri);



        return rootView;
    }


}
