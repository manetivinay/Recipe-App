package com.vinaymaneti.samllslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by vinaymaneti on 9/5/16.
 */
public abstract class CheckBoxesFragment extends Fragment {
    private static final String KEY_CHECKBOX_STATE = "key_check_boxes";
    private CheckBox[] mCheckBoxes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_checkboxes, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.checkboxesLayout);
        String[] contents = getContents(index);

        mCheckBoxes = new CheckBox[contents.length];
        boolean[] checkedBox = new boolean[mCheckBoxes.length];
        if (savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKBOX_STATE) != null) {
            checkedBox = savedInstanceState.getBooleanArray(KEY_CHECKBOX_STATE);
        }
        setUpCheckBoxes(contents, linearLayout, checkedBox);
        return view;
    }

    public abstract String[] getContents(int index);


    public void setUpCheckBoxes(String[] contents, ViewGroup container, boolean[] checkedBox) {
        int i = 0;
        for (String content : contents) {
            mCheckBoxes[i] = new CheckBox(getActivity());
            mCheckBoxes[i].setPadding(8, 16, 8, 16);
            mCheckBoxes[i].setText(content);
            mCheckBoxes[i].setTextSize(20f);
            container.addView(mCheckBoxes[i]);
            if (checkedBox[i]) {
                mCheckBoxes[i].toggle();
            }
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateOfCheckBoxes = new boolean[mCheckBoxes.length];
        int i = 0;
        for (CheckBox checkBox : mCheckBoxes) {
            stateOfCheckBoxes[i] = checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECKBOX_STATE, stateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }
}
