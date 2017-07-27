package qv21.com.wellconstruction.controller;

import qv21.com.wellconstruction.domain.Owner;

/**
 * Created by Dora on 7/27/2017.
 */

/**
 * Interface represent WellDataListController.
 */
public interface WellDataListController extends Controller{

    /**
     * Load WellData List from CSV file, It will call WellRepository.
     */
    public void loadWellDataList();

    /**
     * Update Item when it receives updated object from WellDataDetailFragment which is pasted by
     * Activity.
     * @param position
     * @param owner
     */
    public void updateItem(int position, Owner owner);

}
