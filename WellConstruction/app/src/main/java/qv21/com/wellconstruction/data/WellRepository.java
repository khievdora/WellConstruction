/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.data;

import java.util.List;

import qv21.com.wellconstruction.domain.Owner;

/**
 * Created by Dora on 7/26/2017.
 */

/**
 * Interface to define abstract layer for Repository
 */
public interface WellRepository {

    public List<Owner> wellDataModels();

}
