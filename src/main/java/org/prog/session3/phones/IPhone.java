package org.prog.session3.phones;

public class IPhone extends Phone implements ICamera {
    @Override
    public void call(String subscriber){
        System.out.println("Iphone calling " + subscriber);
    }

    public void takePhotos() {
        System.out.println("IPhone take two photos :)");
    }
}