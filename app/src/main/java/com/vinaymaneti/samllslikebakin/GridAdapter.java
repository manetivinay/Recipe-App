package com.vinaymaneti.samllslikebakin;

/**
 * Created by vinaymaneti on 9/6/16.
 */
public class GridAdapter extends RecyclerAdapter {

    private GridFragment.OnRecipeSelectedInterface mListener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onGridRecipeSelected(index);
    }
}
