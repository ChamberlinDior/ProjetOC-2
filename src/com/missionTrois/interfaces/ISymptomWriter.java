package com.missionTrois.interfaces;

import java.io.IOException;
import java.util.Map;

public interface ISymptomWriter {
 // methode abstract write utilisant l'exception
    void write(Map<String, Integer> map) throws IOException;


}
