package com.xec.single.src.Com.xec.OS;

public class OSFactory {
    public static void main(String[] args) {
        OS myOS = getInstance("new");
        System.out.println(myOS.getSpecs());
    }

    public static OS getInstance(String type) {
        switch (type) {
            case "FREE":
                return new Android();
            case "KIDNEY":
                return new IOS();
            case "OUTDATED":
                return new Windows();
            default:
                return ProjectOSFactory.getInstance(type);
        }
    }
}


class ProjectOSFactory {
  /*  public static void main(String[] args) {
        OS myOS = getInstance("ios");
        myOS.getSpecs();
    }*/

    public static OS getInstance(String type) {
        if(type.equals("new")) {
            return new Go();
        }else{
            System.out.println("NO OS booted");
        }
        return null;
        }
    }


class Android implements OS {
    @Override
    public String getSpecs() {
        return "OPEN User favourite Com.xec.OS.OS";
    }
}


class IOS implements OS {

    @Override
    public String getSpecs() {
        return "Most costly Com.xec.OS.OS";
    }
}


class Windows implements OS {

    @Override
    public String getSpecs() {
        return "Outdated Com.xec.OS.OS";
    }
}

class Go implements OS {

    @Override
    public String getSpecs() {
        return "new Operating system Com.xec.OS.OS";
    }
}
