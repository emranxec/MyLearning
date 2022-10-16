package com.xec.myProject.OS;

/**
 * creational
 * Factory design pattern
 */
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
        return "User favourite operating system";
    }
}


class IOS implements OS {

    @Override
    public String getSpecs() {
        return "Most costly operating system";
    }
}


class Windows implements OS {

    @Override
    public String getSpecs() {
        return "Outdated operating system";
    }
}

class Go implements OS {

    @Override
    public String getSpecs() {
        return "new Operating system";
    }
}
