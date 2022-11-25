package com.missionTrois.interfaces;

import java.io.IOException;
import java.util.Map;

public interface ISymptomWriter {
 // method write utilisant l'exception
    void write(Map<String, Integer> map) throws IOException;


}
