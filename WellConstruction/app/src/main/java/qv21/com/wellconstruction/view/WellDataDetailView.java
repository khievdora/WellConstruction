/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.view;

import qv21.com.wellconstruction.domain.Owner;

/**
 * Created by Dora on 7/27/2017.
 */

/**
 * Interface represent view in Well Data Detail screen.
 */
public interface WellDataDetailView extends BaseView {

    /**
     * This method will be called when user click on button Save.
     * @param position : position of the item in the list
     * @param owner : Object Owner or item of the list.
     */
    public void onButtonSavedClicked(int position, Owner owner);

    /**
     * Load owner object into all edit text in WellDataDetail screen.
     * @param owner
     */
    public void onLoadDataIntoView(Owner owner);
}
