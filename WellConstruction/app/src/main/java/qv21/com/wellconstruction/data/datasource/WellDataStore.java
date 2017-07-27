/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.data.datasource;

import java.util.List;

import qv21.com.wellconstruction.data.entity.WellDataEntity;

/**
 * Created by Dora on 7/26/2017.
 */

/**
 * Interface define necessary method for WellDataStore
 */
public interface WellDataStore {

    /**
     * Get list of WellDataEntity
     * @return
     */
    public List<WellDataEntity> wellDataEntities();

}
