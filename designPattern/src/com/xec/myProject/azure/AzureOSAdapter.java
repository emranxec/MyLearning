package com.xec.myProject.azure;


import com.xec.myProject.OS.OS;
import com.xec.myProject.OS.WindowsOSBooter;

/**
 * Structural
 * Adapter design pattern
 */
//iphone charger by using android charger =adapter
interface AzureOSAdapter extends OS {

    WindowsOSBooter windowsOSBooter=new WindowsOSBooter(); //interface for windows

    static OS bootIt(String type){
        OS os= windowsOSBooter.bootIt(type);
        System.out.println("azure OS adapted :" + os.getSpecs());
        return os;
    }

}
