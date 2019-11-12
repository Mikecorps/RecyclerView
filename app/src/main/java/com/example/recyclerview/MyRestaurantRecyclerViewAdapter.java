package com.example.recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.recyclerview.RestaurantFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;


import java.util.List;


public class MyRestaurantRecyclerViewAdapter extends RecyclerView.Adapter<MyRestaurantRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurant> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyRestaurantRecyclerViewAdapter(List<Restaurant> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.nNombre.setText(holder.mItem.getNombre() );
        holder.nDireccion.setText(holder.mItem.getDireccion());
        holder.rate.setRating(holder.mItem.getRate());
        Picasso.get()
                .load(holder.mItem.getURLPhoto())
                .into(holder.nURL);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nNombre;
        public final TextView nDireccion;
        public final ImageView nURL;
        public final RatingBar rate;

        public Restaurant mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nNombre = view.findViewById(R.id.textViewName);
            nDireccion =  view.findViewById(R.id.textViewAdrees);
            nURL = view.findViewById(R.id.imageViewPhoto);
            rate = view.findViewById(R.id.ratingBarRateB);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nNombre.getText() + "'";
        }
    }
}
