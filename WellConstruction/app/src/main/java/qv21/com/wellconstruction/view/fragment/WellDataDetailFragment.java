/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import qv21.com.wellconstruction.R;
import qv21.com.wellconstruction.controller.WellDataDetailContoller;
import qv21.com.wellconstruction.controller.impl.WellDataDetailControllerImpl;
import qv21.com.wellconstruction.domain.Owner;
import qv21.com.wellconstruction.domain.Tank;
import qv21.com.wellconstruction.domain.Well;
import qv21.com.wellconstruction.view.WellDataDetailView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WellDataDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WellDataDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WellDataDetailFragment extends Fragment implements WellDataDetailView {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_POSITION = "POSITION";
    private static final String ARG_OWNER = "OWNER";

    // TODO: Rename and change types of parameters
    private int mPosition;
    private Owner mOwner;

    private OnFragmentInteractionListener mListener;

    private WellDataDetailContoller mWellDataDetailContoller;

    // TODO: Inject View
    @BindView(R.id.edtOwnerName)
    EditText mEdtOwnerName;

    @BindView(R.id.edtWellName)
    EditText mEdtWellName;
    @BindView(R.id.edtApiNumber)
    EditText mEdtApiNumber;
    @BindView(R.id.edtLongitude)
    EditText mEdtLongitude;
    @BindView(R.id.edtLatitude)
    EditText mEdtLatitude;
    @BindView(R.id.edtPropertyNumber)
    EditText mEdtPropertyNumber;
    @BindView(R.id.edtSec)
    EditText mEdtSec;
    @BindView(R.id.edtTwp)
    EditText mEdtTwp;
    @BindView(R.id.edtRng)
    EditText mEdtRng;
    @BindView(R.id.edtCounty)
    EditText mEdtCounty;

    @BindView(R.id.edtTankName)
    EditText mEdtTankName;
    @BindView(R.id.edtTankMid)
    EditText mEdtTankMid;
    @BindView(R.id.edtTankNumber)
    EditText mEdtTankNumber;
    @BindView(R.id.edtTankSize)
    EditText mEdtTankSize;
    @BindView(R.id.edtBblsPerInch)
    EditText mEdtBblsPerInch;

    @BindView(R.id.btnSave)
    Button mBtnSave;

    public WellDataDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param position is the index of item in the list
     * @param owner Owner object
     * @return A new instance of fragment WellDataDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WellDataDetailFragment newInstance(int position, Owner owner) {
        WellDataDetailFragment fragment = new WellDataDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        args.putSerializable(ARG_OWNER, owner);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_POSITION);
            mOwner = (Owner) getArguments().getSerializable(ARG_OWNER);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_well_data_detail, container, false);
        ButterKnife.bind(this, view);

        // Initialize Controller
        mWellDataDetailContoller = new WellDataDetailControllerImpl(this, mPosition, mOwner);

        // Add Click listener to button
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWellDataDetailContoller.updateOwner(
                        mEdtOwnerName,
                        mEdtWellName,
                        mEdtApiNumber,
                        mEdtLongitude,
                        mEdtLatitude,
                        mEdtPropertyNumber,
                        mEdtSec,
                        mEdtTwp,
                        mEdtRng,
                        mEdtCounty,
                        mEdtTankName,
                        mEdtTankMid,
                        mEdtTankNumber,
                        mEdtTankSize,
                        mEdtBblsPerInch
                );
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showToast(String message, int duration) {

    }

    @Override
    public void showDialogMessage(String message, int dialogType) {

    }

    /**
     * When user click on button clicked, it will send position and object contains updated information
     * back to Activity.
     * @param position : position of the item in the list
     * @param owner : Object Owner or item of the list.
     */
    @Override
    public void onButtonSavedClicked(int position, Owner owner) {
        if (mListener != null) {
            mListener.onButtonSaveClicked(position, owner);
        }
        getActivity().onBackPressed();
    }

    /**
     * Load attributes in Owner into all EditText in the view.
     * @param owner
     */
    @Override
    public void onLoadDataIntoView(Owner owner) {
        // Owner Info
        mEdtOwnerName.setText(owner.getOwnerName());
        // Well Info
        Well well = owner.getWell();
        mEdtWellName.setText(well.getLeaseWellName());
        mEdtApiNumber.setText(well.getApiNumber() + "");
        mEdtLongitude.setText(well.getLong()+ "");
        mEdtLatitude.setText(well.getLat() + "");
        mEdtPropertyNumber.setText(well.getPropertyNumber() + "");
        mEdtSec.setText(well.getSec() + "");
        mEdtTwp.setText(well.getTwp());
        mEdtRng.setText(well.getRng());
        mEdtCounty.setText(well.getCounty());
        // Tank Info
        Tank tank = well.getTank();
        mEdtTankName.setText(tank.getTankName());
        mEdtTankMid.setText(tank.getTankMID() + "");
        mEdtTankNumber.setText(tank.getTankNumber() + "");
        mEdtTankSize.setText(tank.getTankSize() + "");
        mEdtBblsPerInch.setText(tank.getBBLSPerInch() + "");
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onButtonSaveClicked(int position, Owner owner);
    }
}
