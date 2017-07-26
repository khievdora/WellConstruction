package qv21.com.wellconstruction.data;

import java.util.List;

import qv21.com.wellconstruction.data.datasource.WellDataStoreFactory;
import qv21.com.wellconstruction.data.entity.WellDataEntity;
import qv21.com.wellconstruction.data.mapper.WellDataEntityMapper;
import qv21.com.wellconstruction.domain.Owner;

/**
 * Created by Dora on 7/26/2017.
 */

/**
 * {@link WellRepository} for retrieving well_data.
 */
public class WellDataRepository implements WellRepository {

    private WellDataStoreFactory mWellDataStoreFactory;

    public WellDataRepository(WellDataStoreFactory wellDataStoreFactory) {
        mWellDataStoreFactory = wellDataStoreFactory;
    }

    @Override
    public List<Owner> wellDataModels() {
        List<WellDataEntity> wellDataEntities =
                mWellDataStoreFactory.create(WellDataStoreFactory.CSV_DATA_STORE).wellDataEntities();
        return new WellDataEntityMapper().transform(wellDataEntities);
    }
}
