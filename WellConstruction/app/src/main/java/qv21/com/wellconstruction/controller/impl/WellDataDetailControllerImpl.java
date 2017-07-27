package qv21.com.wellconstruction.controller.impl;

import android.widget.EditText;

import qv21.com.wellconstruction.R;
import qv21.com.wellconstruction.controller.WellDataDetailContoller;
import qv21.com.wellconstruction.domain.Owner;
import qv21.com.wellconstruction.domain.Tank;
import qv21.com.wellconstruction.domain.Well;
import qv21.com.wellconstruction.view.WellDataDetailView;

/**
 * Created by Dora on 7/26/2017.
 */

/**
 * This class is an implementation of WellDataDetailController.
 */
public class WellDataDetailControllerImpl implements WellDataDetailContoller {

    private WellDataDetailView mWellDataDetailView;
    private int mPosition;
    private Owner mOwner;

    public WellDataDetailControllerImpl(WellDataDetailView wellDataDetailView, int position,
                                        Owner owner ) {
        mWellDataDetailView = wellDataDetailView;
        mPosition = position;
        mOwner = owner;

        loadDataIntoView(mOwner);
    }

    /**
     * Load Owner's attribute into all EditText in the Screen.
     * @param owner
     */
    @Override
    public void loadDataIntoView(Owner owner) {
        mWellDataDetailView.onLoadDataIntoView(owner);
    }

    /**
     * Perform validating and update Owner information.
     * @param edtOwnerName
     * @param edtWellName
     * @param edtApiNumber
     * @param edtLongitude
     * @param edtLatitude
     * @param edtPropertyNumber
     * @param edtSec
     * @param edtTwp
     * @param edtRng
     * @param edtCounty
     * @param edtTankName
     * @param edtTankMid
     * @param edtTankNumber
     * @param edtTankSize
     * @param edtBblsPerInch
     */
    @Override
    public void updateOwner(EditText edtOwnerName, EditText edtWellName, EditText edtApiNumber,
                            EditText edtLongitude, EditText edtLatitude, EditText edtPropertyNumber,
                            EditText edtSec, EditText edtTwp, EditText edtRng, EditText edtCounty,
                            EditText edtTankName, EditText edtTankMid, EditText edtTankNumber,
                            EditText edtTankSize, EditText edtBblsPerInch) {

        // Block of code for validation
        EditText[] editTexts = new EditText[]{ edtOwnerName,  edtWellName,  edtApiNumber,
                 edtLongitude,  edtLatitude,  edtPropertyNumber, edtSec,  edtTwp,  edtRng,  edtCounty,
                 edtTankName,  edtTankMid,  edtTankNumber, edtTankSize,  edtBblsPerInch};
        boolean invalide = false;
        for (EditText item : editTexts) {
            if (item.getText().toString().isEmpty()) {
                item.setError(item.getResources().getString(R.string.require_field));
                invalide = true;
            }
        }
        if (invalide) {
            return;
        }

        // Assign value into variable
        String ownerName = edtOwnerName.getText().toString();
        String wellName = edtWellName.getText().toString();
        String apiNumber = edtApiNumber.getText().toString();
        double longitude = Double.parseDouble(edtLongitude.getText().toString());
        double latitude = Double.parseDouble(edtLatitude.getText().toString());
        int propertyNumber = Integer.parseInt(edtPropertyNumber.getText().toString());
        int sec = Integer.parseInt(edtSec.getText().toString());
        String twp = edtTwp.getText().toString();
        String rng = edtRng.getText().toString();
        String county = edtCounty.getText().toString();
        String tankName = edtTankName.getText().toString();
        int tankMid = Integer.parseInt(edtTankMid.getText().toString());
        int tankNumber = Integer.parseInt(edtTankNumber.getText().toString());
        double tankSize = Double.parseDouble(edtTankSize.getText().toString());
        double bblsPerInch = Double.parseDouble(edtBblsPerInch.getText().toString());


        // Assign value from control into model
        Tank tank = new Tank(tankName, tankMid, tankNumber, tankSize, bblsPerInch);
        Well well = new Well(apiNumber, longitude, latitude, propertyNumber, county, wellName, sec, twp, rng, tank);
        mOwner.setOwnerName(ownerName);
        mOwner.setWell(well);

        mWellDataDetailView.onButtonSavedClicked(mPosition, mOwner);
    }

    /**
     * Clear all objects
     */
    @Override
    public void dispose() {
        mWellDataDetailView = null;
    }
}
