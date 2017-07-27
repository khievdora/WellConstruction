/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.data.datasource;

import android.content.Context;

/**
 * Created by Dora on 7/26/2017.
 */

/**
 * It is used to construct WellDataStore, we can select difference Data Store in the future such as
 * Database, Disk, Network. Currently, There is only one Data Store right now is from CSV file.
 *
 * This class use Factory Method pattern. It is good for future enhancement.
 */
public class WellDataStoreFactory {

    public static final int CSV_DATA_STORE = 0;
    public static final int DISK_DATA_STORE = 1;

    private final Context mContext;

    public WellDataStoreFactory(Context context) {
        mContext = context;
    }

    /**
     * This method will decide which DataStore you want to get from.
     * @param typeDataStore : Type of Data Store.
     * @return
     */
    public WellDataStore create(int typeDataStore) {
        WellDataStore wellDataStore = null;

        switch (typeDataStore) {
            case CSV_DATA_STORE:
                wellDataStore = createCSVDataStore();
                break;
            case DISK_DATA_STORE:
            default:
                wellDataStore = createCSVDataStore();
        }
        return wellDataStore;
    }

    /**
     * Construct WellDataStore from CSV file
     * @return
     */
    public WellDataStore createCSVDataStore() {
        WellDataStore wellDataStore = new CSVWellDataStore(mContext);
        return wellDataStore;
    }
}
