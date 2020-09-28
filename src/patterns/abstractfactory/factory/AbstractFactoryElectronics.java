package patterns.abstractfactory.factory;

import patterns.abstractfactory.model.Brand;
import patterns.abstractfactory.model.MusicSystem;
import patterns.abstractfactory.model.Television;

public class AbstractFactoryElectronics {
    ElectronicFactory electronicFactory;
    public AbstractFactoryElectronics(Brand brand){
        if(Brand.SAMSUNG==brand) {
            this.electronicFactory = new SamsungFactory();
        }else{
            this.electronicFactory = new OnidaFactory();
        }
    }
    public Television createTelevision(){
        return electronicFactory.createTelevision();
    }
    public MusicSystem createMusicSystem(){
        return electronicFactory.createMusicSystem();
    }
}
