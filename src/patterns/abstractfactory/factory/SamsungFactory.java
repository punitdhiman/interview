package patterns.abstractfactory.factory;

import patterns.abstractfactory.model.MusicSystem;
import patterns.abstractfactory.model.SamsungMusicSystem;
import patterns.abstractfactory.model.SamsungTelevision;
import patterns.abstractfactory.model.Television;

public class SamsungFactory implements ElectronicFactory{

    @Override
    public Television createTelevision() {
        return new SamsungTelevision();
    }

    @Override
    public MusicSystem createMusicSystem() {
        return new SamsungMusicSystem();
    }
}
