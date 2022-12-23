package com.missionTrois.implementation;

import com.missionTrois.interfaces.ISymptomsCompute;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SymptomsCompute implements ISymptomsCompute {
     // COMPTER les symptoms et filtrer les doublons
    public Map<String, Integer> getMapFromList(List<String> symptomList) {// prend une liste en entré et en ressort une Map
        Map<String, Integer> symptomMap = new TreeMap<>();//permet d'ordonner alphabetiquement
        for (String symptom : symptomList) {
            Integer currentValue = symptomMap.containsKey(symptom)// permet de compter les symptoms
                    ? symptomMap.get(symptom) + 1
                    : 1;

            symptomMap.put(symptom, currentValue);
        }

         return symptomMap;
    }
}