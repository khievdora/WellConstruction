/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import qv21.com.wellconstruction.R;
import qv21.com.wellconstruction.domain.Owner;
import qv21.com.wellconstruction.view.fragment.WellDataDetailFragment;
import qv21.com.wellconstruction.view.fragment.WellDataListFragment;

/**
 * It is a Main Application Screen.
 */
public class WellDataActivity extends AppCompatActivity implements
        WellDataListFragment.OnFragmentInteractionListener,
        WellDataDetailFragment.OnFragmentInteractionListener {

    WellDataListFragment mWellDataListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well_data);

        // Navigate to WellDataList
        if (mWellDataListFragment == null) {
            mWellDataListFragment = new WellDataListFragment();
            navigateToFragment(mWellDataListFragment);
        }
    }

    /**
     * This method is invoked when user click on item of the GridView in WellDataListFragment.
     * @param position : index of item
     * @param owner : object at that index position.
     */
    @Override
    public void onWellDataItemClicked(int position, Owner owner) {
        // Enable Navigation ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Fragment wellDataDetailFragment = WellDataDetailFragment.newInstance(position, owner);
        navigateToFragment(wellDataDetailFragment);
    }

    /**
     * This method will be invoked when suer click on button save in WellDataDetailFragment. So it will
     * paste back the index position as well as Object that contains updated information.
     * @param position : index of item that bas been clicked before.
     * @param owner : Object contains updated information.
     */
    @Override
    public void onButtonSaveClicked(int position, Owner owner) {
        if (mWellDataListFragment != null) {
            mWellDataListFragment.updateItem(position, owner);
        }
    }

    /**
     * Since we use multiple fragments in single Activity. Therefore, I decided to show home button
     * in Actionbar when we navigate to WellDataDetail Screen. In this case, when user click on that
     * button home or back button in Actionbar. It will invoke this method.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // TODO: Hide navigation button in Actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        // TODO: Hide Hide soft keyboard
        // Source : https://stackoverflow.com/questions/1109022/close-hide-the-android-soft-keyboard
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    protected void onDestroy() {
        mWellDataListFragment = null;
        super.onDestroy();
    }

    /**
     * This method will perform task navigate screen to specific fragment
     * @param fragment is the fragment that need to displayed on the screen.
     */
    public void navigateToFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment)
        if (fragment instanceof WellDataListFragment) {
            fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        } else {
            fragmentTransaction.add(R.id.fragmentContainer, fragment);
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }
}
