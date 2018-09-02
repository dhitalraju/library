package com.raju.library.staticfactorymethod;

/**
 *
 * @author raju
 */
public class Service {

    private Service() {
    }

    public static Service getNewInstance() {
        return new Service();
    }

    public void display() {
        System.out.println("Example Of Static Factory Method");
    }
}
