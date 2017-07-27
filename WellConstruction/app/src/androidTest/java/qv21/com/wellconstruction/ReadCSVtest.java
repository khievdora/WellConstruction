package qv21.com.wellconstruction;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import qv21.com.wellconstruction.data.WellDataRepository;
import qv21.com.wellconstruction.data.WellRepository;
import qv21.com.wellconstruction.data.datasource.WellDataStoreFactory;
import qv21.com.wellconstruction.domain.Owner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Created by Dora on 7/26/2017.
 */

@RunWith(AndroidJUnit4.class)
public class ReadCSVtest {

    private WellRepository mWellRepository;

    /**
     * Testing read data from CSV file.
     */
    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getContext();
        mWellRepository = new WellDataRepository(new WellDataStoreFactory(context));
    }

    /**
     * This method will will check that the process of query data from CSV file works or not.
     */
    @Test
    public void testListData() {
        List<Owner> ownerList = mWellRepository.wellDataModels();
        List<Owner> expectedOwners = null;
        assertFalse("Actual List is not the same as expected list", ownerList == expectedOwners);
    }


}
