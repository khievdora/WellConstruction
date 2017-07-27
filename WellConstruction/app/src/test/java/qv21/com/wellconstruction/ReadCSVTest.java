package qv21.com.wellconstruction;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import qv21.com.wellconstruction.data.WellDataRepository;
import qv21.com.wellconstruction.domain.Owner;

import static junit.framework.Assert.assertNull;

/**
 * Created by Dora on 7/26/2017.
 */
public class ReadCSVTest {

    WellDataRepository mWellDataRepository;
    List<Owner> mOwnerList;

    @Before
    public void setUp() {
        mWellDataRepository = Mockito.mock(WellDataRepository.class);
        mOwnerList = new ArrayList<>();
    }

    @Test
    public void testCSVFile() {
        Mockito.when(mWellDataRepository.wellDataModels()).thenReturn(new ArrayList<Owner>());
        assertNull("List is not null!!", mWellDataRepository.wellDataModels());
    }

}
