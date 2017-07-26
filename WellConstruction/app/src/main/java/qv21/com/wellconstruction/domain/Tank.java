package qv21.com.wellconstruction.domain;

/**
 * Created by Dora on 7/26/2017.
 */

public class Tank {

    private String mTankName;
    private int mTankMID;
    private int mTankNumber;
    private double mTankSize;
    private double mBBLSPerInch;

    public Tank(String tankName, int tankMID, int tankNumber, double tankSize, double BBLSPerInch) {
        mTankName = tankName;
        mTankMID = tankMID;
        mTankNumber = tankNumber;
        mTankSize = tankSize;
        mBBLSPerInch = BBLSPerInch;
    }

    public String getTankName() {
        return mTankName;
    }

    public int getTankMID() {
        return mTankMID;
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
}
