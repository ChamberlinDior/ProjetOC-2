package com.missionTrois.implementation;

import com.missionTrois.interfaces.ISymptomWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SymptomsWriterToFile implements ISymptomWriter {

    private final String outputFilepath;

    public SymptomsWriterToFile(String outputFilepath) {
        this.outputFilepath = outputFilepath;
    }

    public void write(Map<String, Integer> map) throws IOException {
        FileWriter writer = new FileWriter(outputFilepath);// ouvrir le fichier afin de pourvoir y écrire les symptoms

        map.forEach((key, value) -> {
            try {
                String v = key + " : " +  value; //
                System.out.println(v);
                writer.write( v + "\n"); // cela permet dans le fichier
            } catch (IOException e) {
                throw new RuntimeException(e);//utilisation de l'exception
            }
        });

        System.out.println();
        writer.close(); // fermer le fichier
    }
}

