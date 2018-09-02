package com.raju.library.staticfactorymethod;

/**
 *
 * @author raju
 */
public class Test {

    public static void main(String[] args) {
        Service service = Service.getNewInstance();
        service.display();
    }
}
