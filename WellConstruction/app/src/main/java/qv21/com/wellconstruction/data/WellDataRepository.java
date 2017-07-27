/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

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
 * {@link WellRepository} for retrieving well_data. It follows Repository Pattern in this case.
 */
public class WellDataRepository implements WellRepository {

    private WellDataStoreFactory mWellDataStoreFactory;

    public WellDataRepository(WellDataStoreFactory wellDataStoreFactory) {
        mWellDataStoreFactory = wellDataStoreFactory;
    }

    /**
     * Load List of Owner from CSV file. It also perform mapping between WellDataEntity and Owner.
     * Because in the future, if we gonna have multiple format from multiple data store. Therefore,
     * it is a good idea to have a mapper for each model and entity.
     * @return
     */
    @Override
    public List<Owner> wellDataModels() {
        List<WellDataEntity> wellDataEntities =
                mWellDataStoreFactory.create(WellDataStoreFactory.CSV_DATA_STORE).wellDataEntities();
        return new WellDataEntityMapper().transform(wellDataEntities);
    }
}
