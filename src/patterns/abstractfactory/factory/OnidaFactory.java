package patterns.abstractfactory.factory;

import patterns.abstractfactory.model.*;

public class OnidaFactory implements ElectronicFactory{

    @Override
    public Television createTelevision() {
        return new OnidaTelevision();
    }

    @Override
    public MusicSystem createMusicSystem() {
        return new OnidaMusicSystem();
    }
}
