/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.controller.impl;

import android.content.Context;
import android.util.Log;

import java.util.List;

import qv21.com.wellconstruction.controller.WellDataListController;
import qv21.com.wellconstruction.data.WellDataRepository;
import qv21.com.wellconstruction.data.WellRepository;
import qv21.com.wellconstruction.data.datasource.WellDataStoreFactory;
import qv21.com.wellconstruction.domain.Owner;
import qv21.com.wellconstruction.view.WellDataListView;

/**
 * Created by Dora on 7/26/2017.
 */

/**
 * This class is an implementation from WellDataListController.
 */
public class WellDataListControllerImpl implements WellDataListController {

    private WellDataListView mWellDataListView;
    private Context mContext;
    private List<Owner> mOwnerList;

    public WellDataListControllerImpl(Context context, WellDataListView wellDataListView) {
        mContext = context;
        mWellDataListView = wellDataListView;

        // Load data from CSV file
        loadWellDataList();
    }

    /**
     * It will perform load data from CSV file and send it to View by mWellDataListView.
     */
    @Override
    public void loadWellDataList() {
        WellRepository wellRepository = new WellDataRepository(new WellDataStoreFactory(mContext));
        mOwnerList = wellRepository.wellDataModels();
        mWellDataListView.onLoadWellDataList(mOwnerList);
    }

    /**
     * Update item of the list, and refresh GridView
     * @param position
     * @param owner
     */
    @Override
    public void updateItem(int position, Owner owner) {
        mOwnerList.set(position, owner);
        Log.d("Update", " Owner name is " + owner.getOwnerName());
        mWellDataListView.refreshList();
    }

    /**
     * Clear all object when it's stop using.
     */
    @Override
    public void dispose() {
        mContext = null;
        mOwnerList = null;
        mWellDataListView = null;
    }
}
