package com.xec.myProject.azure;


import com.xec.myProject.OS.OS;
import com.xec.myProject.OS.WindowsOSBooter;

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
