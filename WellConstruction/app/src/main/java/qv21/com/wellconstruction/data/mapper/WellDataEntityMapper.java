package qv21.com.wellconstruction.data.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import qv21.com.wellconstruction.data.entity.WellDataEntity;
import qv21.com.wellconstruction.domain.Owner;
import qv21.com.wellconstruction.domain.Tank;
import qv21.com.wellconstruction.domain.Well;

/**
 * Created by Dora on 7/26/2017.
 */

public class WellDataEntityMapper {

    public WellDataEntityMapper() {
    }

    public List<Owner> transform(Collection<WellDataEntity> wellDataEntities) {
        List<Owner> owners = new ArrayList<>(1000);
        for (WellDataEntity item : wellDataEntities) {
            Owner owner = new Owner(
                    item.getOwner(),
                    new Well(
                            item.getApiNumber(),
                            item.getLong(),
                            item.getLat(),
                            item.getPropertyNumber(),
                            item.getCounty(),
                            item.getLeaseWellName(),
                            item.getSec(),
                            item.getTwp(),
                            item.getRng(),
                            new Tank(
                                    item.getTankName(),
                                    item.getTankMID(),
                                    item.getTankNumber(),
                                    item.getTankSize(),
                                    item.getBBLSPerInch()
                            )
                    )
                );
            owners.add(owner);
        }
        return owners;
    }

}
