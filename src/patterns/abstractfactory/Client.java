package patterns.abstractfactory;

import patterns.abstractfactory.factory.AbstractFactoryElectronics;
import patterns.abstractfactory.model.Brand;

public class Client {
    //Could be France/India
    //France->buildHouse()/buildStreet() ArchitectureFactory
    public static void main(String[] args) {
        AbstractFactoryElectronics onidaFactoryElectronics = new AbstractFactoryElectronics(Brand.ONIDA);
        System.out.println(onidaFactoryElectronics.createTelevision().getModel());
        System.out.println(onidaFactoryElectronics.createMusicSystem().getModel());
        AbstractFactoryElectronics samsungFactoryElectronics = new AbstractFactoryElectronics(Brand.SAMSUNG);
        System.out.println(samsungFactoryElectronics.createTelevision().getModel());
        System.out.println(samsungFactoryElectronics.createMusicSystem().getModel());
    }
}
