package com.xec.single.src.Com.xec.azure;


import com.xec.single.src.Com.xec.OS.OS;

public class AzureVm {
    private OS os;

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    void bootOS(){
        System.out.println("Operating System rebooted succeffuly with : " +os.getSpecs());
    }
}

