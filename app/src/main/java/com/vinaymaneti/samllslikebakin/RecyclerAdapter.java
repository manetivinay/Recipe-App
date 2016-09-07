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
public abstract class RecyclerAdapter extends RecyclerView.Adapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        return new RecipesViewHolder(view);
    }

    protected abstract int getLayoutId();

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecipesViewHolder) holder).onBindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }


    private class RecipesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;
        private ImageView mImageView;
        private int mIndex;

        public RecipesViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.itemText);
            mImageView = (ImageView) itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRecipeSelected(mIndex);
        }

        public void onBindView(int position) {
            mTextView.setText(Recipes.names[position]);
            mImageView.setImageResource(Recipes.resourceIds[position]);
            mIndex = position;
        }

    }

    protected abstract void onRecipeSelected(int index);
}
