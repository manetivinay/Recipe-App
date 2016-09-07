package com.vinaymaneti.samllslikebakin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.nio.BufferUnderflowException;

public class MainActivity extends AppCompatActivity implements ListFragments.OnRecipeSelectedInterface, GridFragment.OnRecipeSelectedInterface {

    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEW_PAGER_FRAGMENT = "view_pager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        if (!isTablet) {
            Fragment savedFragment = getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);

            if (savedFragment == null) {
                ListFragments listFragment = new ListFragments();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, listFragment, LIST_FRAGMENT);
                fragmentTransaction.commit();
            }
        } else {
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);

            if (savedFragment == null) {
                GridFragment gridFragment = new GridFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, gridFragment, LIST_FRAGMENT);
                fragmentTransaction.commit();
            }
        }


    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        viewPagerFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, viewPagerFragment, VIEW_PAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onGridRecipeSelected(int index) {
        DualPaneFragment dualPaneFragment = new DualPaneFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        dualPaneFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, dualPaneFragment, VIEW_PAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
