package com.xec.single.src.Com.xec.azure;

import com.xec.single.src.Com.xec.OS.OS;
import com.xec.single.src.Com.xec.OS.WindowsOSBooter;


//iphone charger by using android charger =adapter
class OSAdapter implements OS {

    WindowsOSBooter windowsOSBooter=new WindowsOSBooter(); //interface for windows

    public OS bootIt(String type){
        return windowsOSBooter.bootIt(type);
    }

    @Override
    public String getSpecs() {
        return null;
    }

    @Override
    public void setSpecs(String specsUpdate) {
    }

}
