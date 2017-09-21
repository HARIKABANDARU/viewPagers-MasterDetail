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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_DetailView.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_DetailView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_DetailView extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
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

    private OnFragmentInteractionListener mListener;

    public Fragment_DetailView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_DetailView.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        movie = ((HashMap<String,?>)getArguments().getSerializable(ARG_MOVIE));

        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StringBuffer voteAverage = new StringBuffer(String.valueOf(movie.get("voteAverage")));

       View rootView = inflater.inflate(R.layout.fragment_fragment__detail_view, container, false);
        movieTitle = (TextView)rootView.findViewById(R.id.movieTitle);
        movieReleaseDate = (TextView)rootView.findViewById(R.id.movieReleaseDate);
        movieRating = (TextView) rootView.findViewById(R.id.movieRating);
        movieSynopsis = (TextView) rootView.findViewById(R.id.movieSynopsis);
        moviePosterImage = (SimpleDraweeView)rootView.findViewById(R.id.movieImage);
        movieTitle.setText((CharSequence) movie.get("title"));
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
