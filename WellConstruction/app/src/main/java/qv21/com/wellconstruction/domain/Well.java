package qv21.com.wellconstruction.domain;

/**
 * Created by Dora on 7/26/2017.
 */

public class Well {

    private String mApiNumber;
    private double mLong;
    private double mLat;
    private int mPropertyNumber;
    private String mCounty;
    private String mLeaseWellName;
    private int mSec;
    private String mTwp;
    private String mRng;
    private Tank mTank;

    public Well(String apiNumber, double aLong, double lat, int propertyNumber, String county,
                String leaseWellName, int sec, String twp, String rng, Tank tank) {
        mApiNumber = apiNumber;
        mLong = aLong;
        mLat = lat;
        mPropertyNumber = propertyNumber;
        mLeaseWellName = leaseWellName;
        mSec = sec;
        mTwp = twp;
        mRng = rng;
        mCounty = county;
        mTank = tank;
    }

    public String getApiNumber() {
        return mApiNumber;
    }

    public double getLong() {
        return mLong;
    }

    public double getLat() {
        return mLat;
    }

    public int getPropertyNumber() {
        return mPropertyNumber;
    }

    public String getLeaseWellName() {
        return mLeaseWellName;
    }

    public int getSec() {
        return mSec;
    }

    public String getTwp() {
        return mTwp;
    }

    public String getRng() {
        return mRng;
    }

    public String getCounty() {
        return mCounty;
    }

    public Tank getTank() {
        return mTank;
    }
}
