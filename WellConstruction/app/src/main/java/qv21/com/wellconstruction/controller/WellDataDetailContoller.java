package qv21.com.wellconstruction.controller;

import android.widget.EditText;

import qv21.com.wellconstruction.domain.Owner;

/**
 * Created by Dora on 7/27/2017.
 */

public interface WellDataDetailContoller extends Controller {

    public void loadDataIntoView(Owner owner);
    public void updateOwner(EditText edtOwnerName,
                            EditText edtWellName,
                            EditText edtApiNumber,
                            EditText edtLongitude,
                            EditText edtLatitude,
                            EditText edtPropertyNumber,
                            EditText edtSec,
                            EditText edtTwp,
                            EditText edtRng,
                            EditText edtCounty,
                            EditText edtTankName,
                            EditText edtTankMid,
                            EditText edtTankNumber,
                            EditText edtTankSize,
                            EditText edtBblsPerInch);

}
