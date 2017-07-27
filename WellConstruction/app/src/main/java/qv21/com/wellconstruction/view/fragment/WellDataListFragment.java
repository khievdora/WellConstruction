/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import qv21.com.wellconstruction.R;
import qv21.com.wellconstruction.controller.WellDataListController;
import qv21.com.wellconstruction.controller.impl.WellDataListControllerImpl;
import qv21.com.wellconstruction.domain.Owner;
import qv21.com.wellconstruction.view.WellDataListView;
import qv21.com.wellconstruction.view.adapter.WellDataGridItemAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WellDataListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class WellDataListFragment extends Fragment implements WellDataListView {

    private final String TAG = WellDataListFragment.class.getName();

    private OnFragmentInteractionListener mListener;

    private GridView mGrdWellData;
    private WellDataGridItemAdapter mWellDataGridItemAdapter;
    private WellDataListController mWellDataListController;

    public WellDataListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_well_data_list, container, false);

        // Initialize view
        mGrdWellData = (GridView) view.findViewById(R.id.grdWellData);

        // Initialize Controller
        mWellDataListController = new WellDataListControllerImpl(getContext(), this);

        return view;
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

    @Override
    public void showToast(String message, int duration) {

    }

    @Override
    public void showDialogMessage(String message, int dialogType) {

    }

    /**
     * Load list of Owner into GridView after Controller perform query data from CSV file.
     * @param ownerList : List of owner object.
     */
    @Override
    public void onLoadWellDataList(List<Owner> ownerList) {
        mWellDataGridItemAdapter = new WellDataGridItemAdapter(ownerList);
        mGrdWellData.setAdapter(mWellDataGridItemAdapter);
        mGrdWellData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onWellDataItemClicked(position, mWellDataGridItemAdapter.getItem(position));
            }
        });
    }

    /**
     * This method will invoke onWellDataItemClicked which will interact with Activity
     * @param position : index of item that has been clicked.
     * @param owner : Object on that position of the List.
     */
    @Override
    public void onWellDataItemClicked(int position, Owner owner) {
        if (mListener != null) {
            mListener.onWellDataItemClicked(position, owner);
        }
    }

    /**
     * After Object has been updated, Activity will call updateItem
     * @param position : index of item that been updated.
     * @param owner : New object that contains updated info
     */
    @Override
    public void updateItem(int position, Owner owner) {
        mWellDataListController.updateItem(position, owner);
    }

    /**
     * Refresh content of the GridView
     */
    @Override
    public void refreshList() {
        Log.d(TAG, "Owner 0 is " + mWellDataGridItemAdapter.getItem(0).getOwnerName());
        mWellDataGridItemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        mWellDataListController.dispose();
        super.onDestroy();
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
        void onWellDataItemClicked(int position, Owner owner);
    }
}

