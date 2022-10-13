package com.xec.single.src.Com.xec.azure;


import com.xec.single.src.Com.xec.OS.OS;

class hostAzure{
    public static void main(String[] args) {
        OS buildedOS=new OSAdapter().bootIt("FREE");
        // OS buildedOS=Com.xec.OS.OSFactory.getInstance("FREE");
        AzureVm azureVm=new AzureVm();
        azureVm.setOs(buildedOS);
        azureVm.bootOS();
    }
}
