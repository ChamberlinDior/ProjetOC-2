package com.missionTrois.implementation;

import com.missionTrois.interfaces.ISymptomReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
    /**
     * this variable give the way of the file
     */
    private String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filepath) throws IllegalAccessException {
        if (filepath == null || filepath.isBlank()) {
            throw new IllegalAccessException("Filepath cannot be null or blank");
        }

        this.filepath = filepath;//attribute the name filepath
    }

    @Override
    public List<String> getSymptoms() {
        List<String> result = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
             //Utilisation de la boucle while pour lire le fichier
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();// utilisation de l'exception
        }
        return result;
    }



}
