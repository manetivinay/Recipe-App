package com.vinaymaneti.samllslikebakin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by vinaymaneti on 9/4/16.
 */
public class ListAdapter extends RecyclerAdapter {
    private ListFragments.OnRecipeSelectedInterface mListener;

    public ListAdapter(ListFragments.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }


    @Override
    protected void onRecipeSelected(int index) {
        mListener.onListRecipeSelected(index);
    }
}
