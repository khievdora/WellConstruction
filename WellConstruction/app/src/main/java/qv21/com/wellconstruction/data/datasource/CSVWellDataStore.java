/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.data.datasource;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import qv21.com.wellconstruction.R;
import qv21.com.wellconstruction.data.entity.WellDataEntity;

/**
 * Created by Dora on 7/26/2017.
 */

/**
 * Class responsible for reading data from CSV file
 */
public class CSVWellDataStore implements  WellDataStore {

    private Context mContext;

    public CSVWellDataStore(Context context) {
        mContext = context;
    }

    /**
     * This method will read all data from CSV file and return back as List of WellDataEntity.
     * @return
     */
    @Override
    public List<WellDataEntity> wellDataEntities() {

        List<WellDataEntity> WellDataEntitys = new ArrayList<>();

        InputStream inputStream = mContext.getResources().openRawResource(R.raw.well_data);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String csvLine;
            String headerLine = bufferedReader.readLine();
            while ((csvLine = bufferedReader.readLine()) != null) {
                String[] datas = csvLine.split(",");
                WellDataEntitys.add(new WellDataEntity(
                        datas[0] + ", " + datas[1] , // Owner
                        datas[2], // Api Number
                        Double.parseDouble(datas[3]),// Longitude
                        Double.parseDouble(datas[4]),// Latitude
                        Integer.parseInt(datas[5]), // Property Number
                        datas[6], // Lease / Well Name
                        Integer.parseInt(datas[7]), // Tank MID
                        datas[8], // Tank Name
                        Integer.parseInt(datas[9]), // Tank Number
                        Double.parseDouble(datas[10]), // Tank Size
                        Double.parseDouble(datas[11]), // BBLS Per Inch
                        Integer.parseInt(datas[12]), // SEC
                        datas[13], // TWP
                        datas[14], // RNG
                        datas[15])); // County
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
                try {
                    inputStream.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return WellDataEntitys;
    }
}
