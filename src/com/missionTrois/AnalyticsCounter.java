package com.missionTrois;

import com.missionTrois.implementation.ReadSymptomDataFromFile;
import com.missionTrois.implementation.SymptomsCompute;
import com.missionTrois.implementation.SymptomsWriterToFile;
import com.missionTrois.interfaces.ISymptomReader;
import com.missionTrois.interfaces.ISymptomWriter;
import com.missionTrois.interfaces.ISymptomsCompute;

import java.util.List;
import java.util.Map;
public class AnalyticsCounter {
        // champs contenant les données
    public static String filepath = "symptoms.txt";
    public static String outputFilepath = "result.out";

    public static void main(String args[]) throws Exception {
              //objet ayant pour objectif de lire le fichier  placer dans une liste
        System.out.println("Load symptom file");
        ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
        List<String> symptomList = reader.getSymptoms();
         //objet servant à comptr
        System.out.println("Compute symptom");
        ISymptomsCompute compute = new SymptomsCompute();
        Map<String, Integer> symptomMap = compute.getMapFromList(symptomList);

        System.out.println("Write symptoms");
        ISymptomWriter writer = new SymptomsWriterToFile(outputFilepath);
        writer.write(symptomMap);

    }
}
