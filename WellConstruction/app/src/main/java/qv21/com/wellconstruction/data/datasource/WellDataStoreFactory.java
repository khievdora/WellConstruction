package qv21.com.wellconstruction.data.datasource;

import android.content.Context;

/**
 * Created by Dora on 7/26/2017.
 */

public class WellDataStoreFactory {

    public static final int CSV_DATA_STORE = 0;
    public static final int DISK_DATA_STORE = 1;

    private final Context mContext;

    public WellDataStoreFactory(Context context) {
        mContext = context;
    }

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

    public WellDataStore createCSVDataStore() {
        WellDataStore wellDataStore = new CSVWellDataStore(mContext);
        return wellDataStore;
    }
}
