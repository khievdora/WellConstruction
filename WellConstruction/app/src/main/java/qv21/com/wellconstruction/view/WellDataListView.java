
/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.view;

import java.util.List;

import qv21.com.wellconstruction.domain.Owner;

/**
 * Created by Dora on 7/27/2017.
 */

/**
 * Interface representing a View that will be used to Data List Screen.
 */
public interface WellDataListView  extends  BaseView {

    /**
     * Load list of Owner into GridView or ListView
     * @param ownerList : List of owner object.
     */
    public void onLoadWellDataList(List<Owner> ownerList);

    /**
     * When item of WellDataGridView is clicked. It will paste data into activity
     * @param position : index of item that has been clicked.
     * @param owner : Object on that position of the List.
     */
    public void onWellDataItemClicked(int position, Owner owner);

    /**
     * This method will be invoke when the activity paste data back from WellDataDetail Screen. It will
     * be used to update info of item list.
     * @param position : index of item that been updated.
     * @param owner : New object that contains updated info
     */
    public void updateItem(int position, Owner owner);

    /**
     * This method will invoke after update item of the list. We need it refresh the contain of the
     * GridView.
     */
    public void refreshList();

    /**
     * Display loading dialog to user when retrieving data
     */
    public void showLoading();

    /**
     * Dismiss Loading dialog
     */
    public void dismissLoading();

}

