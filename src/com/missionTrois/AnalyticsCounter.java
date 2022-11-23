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

    public static String filepath = "symptom.txt";
    public static String outputFilepath = "result.out";

    public static void main(String args[]) throws Exception {

        System.out.println("Load symptom file");
        ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
        List<String> symptomList = reader.getSymptoms();

        System.out.println("Compute symptom");
        ISymptomsCompute compute = new SymptomsCompute();
        Map<String, Integer> symptomMap = compute.getMapFromList(symptomList);

        System.out.println("Write symptoms");
        ISymptomWriter writer = new SymptomsWriterToFile(outputFilepath);
        writer.write(symptomMap);

    }
}
