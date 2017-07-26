package qv21.com.wellconstruction.domain;

/**
 * Created by Dora on 7/26/2017.
 */

public class Owner {

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
}
