package com.xec.myProject.azure;


import com.xec.myProject.OS.OS;
import com.xec.myProject.OS.OSFactory;
import com.xec.myProject.OS.WindowsOSBooter;

public class OSAdapterTest {


    //AzureOSAdapter azureOsAdapter =new AzureOSAdapter(); //interface for windows
/*

    @Mock
    WindowsOSBooter windowsOSService=Mockito.mock(WindowsOSBooter.class); //interface for windows

    @After
    public void tearDown() throws Exception {
        System.out.println("exception");
    }

    @Before
    public void createIt() {
        osAdapter =new OSAdapter();
    }

    @Test
    public void bootIt() {
        OS os= null;
        when(windowsOSService.bootIt("KIDNEY")).thenReturn(OSFactory.getInstance("KIDNEY"));
        assertEquals(null, osAdapter.bootIt("KIDNEY"));
        verify(windowsOSService.bootIt("KIDNEY"));
    }*/
}