package com.vinaymaneti.samllslikebakin;

/**
 * Created by vinaymaneti on 9/6/16.
 */
public class IngredientsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
