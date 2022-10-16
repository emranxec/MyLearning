package com.xec.myProject.azure;


import com.xec.myProject.OS.OS;

class hostAzure{
    public static void main(String[] args) {
        OS buildedOS=AzureOSAdapter.bootIt("FREE");
        // OS buildedOS=Com.xec.OS.OSFactory.getInstance("FREE");
        AzureVm azureVm=new AzureVm();
        azureVm.setOs(buildedOS);
        azureVm.bootOS();
    }
}
