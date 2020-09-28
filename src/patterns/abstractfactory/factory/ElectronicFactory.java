package patterns.abstractfactory.factory;

import patterns.abstractfactory.model.MusicSystem;
import patterns.abstractfactory.model.Television;

public interface ElectronicFactory {
    Television createTelevision();
    MusicSystem createMusicSystem();
}
