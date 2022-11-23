package com.missionTrois.implementation;

import com.missionTrois.interfaces.ISymptomsCompute;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SymptomsCompute implements ISymptomsCompute {

    public Map<String, Integer> getMapFromList(List<String> symptomList) {
        Map<String, Integer> symptomMap = new TreeMap<>();
        for (String symptom : symptomList) {
            Integer currentValue = symptomMap.containsKey(symptom)
                    ? symptomMap.get(symptom) + 1
                    : 1;

            symptomMap.put(symptom, currentValue);
        }

         return symptomMap;
    }
}