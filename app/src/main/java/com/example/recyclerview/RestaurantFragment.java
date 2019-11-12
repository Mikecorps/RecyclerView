    package com.example.recyclerview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RestaurantFragment extends Fragment {
    RecyclerView recyclerView;
    MyRestaurantRecyclerViewAdapter  adapter_restaurant;
    List<Restaurant> restaurantsList ;

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestaurantFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
             recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            restaurantsList = new ArrayList<>();
            restaurantsList.add(new Restaurant("Dominos","https://www.shutterstock.com/es/image-photo/process-making-cooking-homemade-pasta-chef-1449913733",4,"Mexico"));
            restaurantsList.add(new Restaurant("PizzaHut","https://www.google.com/search?rlz=1C1GCEU_esMX824MX825&biw=1314&bih=705&tbm=isch&sxsrf=ACYBGNRaNYMb1WcmovhYzb6yWwX7rbc5sA%3A1569877835659&sa=1&ei=S2-SXezyJ8vq-gSi2aOABw&q=pizza+hut&oq=pizza&gs_l=img.3.0.0i67l10.23043.23801..24552...0.0..0.162.700.0j5......0....1..gws-wiz-img.......35i39j0.taQBBNHRT7U#imgrc=bK3k6IZdOtg1wM:",3,"Mexico"));
            restaurantsList.add(new Restaurant("KFC","https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwja0MmNvfnkAhXOHTQIHRF5DLAQjRx6BAgBEAQ&url=https%3A%2F%2Fwww.livekindly.co%2Fkfc-trial-vegetarian-option-healthier-sides-uk%2F&psig=AOvVaw24ZgsbuZBEezargpHqce2i&ust=1569964888125769",4,"Mexico"));




            adapter_restaurant = new MyRestaurantRecyclerViewAdapter( restaurantsList , mListener);
            recyclerView.setAdapter( adapter_restaurant);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Restaurant item);
    }
}
