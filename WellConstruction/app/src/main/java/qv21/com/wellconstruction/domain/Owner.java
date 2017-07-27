package qv21.com.wellconstruction.domain;

import java.io.Serializable;

/**
 * Created by Dora on 7/26/2017.
 */

/**
 * Owner Model
 */
public class Owner implements Serializable {

    private String mOwnerName;
    private Well mWell;

    public Owner(String ownerName, Well well) {
        mOwnerName = ownerName;
        mWell = well;
    }

    public String getOwnerName() {
        return mOwnerName;
    }

    public Well getWell() {
        return mWell;
    }

    public void setOwnerName(String ownerName) {
        mOwnerName = ownerName;
    }

    public void setWell(Well well) {
        mWell = well;
    }
}
