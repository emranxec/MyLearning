package com.xec.myProject.azure;


import com.xec.myProject.OS.OS;

public class AzureVm {
    private OS os;

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    void bootOS(){
        System.out.println("Operating System rebooted succeffuly with : " +getOs().getSpecs());
    }
}

