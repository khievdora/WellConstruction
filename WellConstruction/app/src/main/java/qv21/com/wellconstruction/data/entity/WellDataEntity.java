/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.data.entity;

/**
 * Created by Dora on 7/26/2017.
 */

/**
 * Class that represent Well Data from CSV file.
 */
public class WellDataEntity {

    private String mOwner;
    private String mApiNumber;
    private double mLong;
    private double mLat;
    private int mPropertyNumber;
    private String mLeaseWellName;
    private int mTankMID;
    private String mTankName;
    private int mTankNumber;
    private double mTankSize;
    private double mBBLSPerInch;
    private int mSec;
    private String mTwp;
    private String mRng;
    private String mCounty;

    public WellDataEntity(String owner, String apiNumber, double aLong, double lat,
                          int propertyNumber, String leaseWellName, int tankMID, String tankName,
                          int tankNumber, double tankSize, double BBLSPerInch, int sec, String twp,
                          String rng, String county) {
        mOwner = owner;
        mApiNumber = apiNumber;
        mLong = aLong;
        mLat = lat;
        mPropertyNumber = propertyNumber;
        mLeaseWellName = leaseWellName;
        mTankMID = tankMID;
        mTankName = tankName;
        mTankNumber = tankNumber;
        mTankSize = tankSize;
        mBBLSPerInch = BBLSPerInch;
        mSec = sec;
        mTwp = twp;
        mRng = rng;
        mCounty = county;
    }

    public String getOwner() {
        return mOwner;
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

    public int getTankMID() {
        return mTankMID;
    }

    public String getTankName() {
        return mTankName;
    }

    public int getTankNumber() {
        return mTankNumber;
    }

    public double getTankSize() {
        return mTankSize;
    }

    public double getBBLSPerInch() {
        return mBBLSPerInch;
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
}
