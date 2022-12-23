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

        this.filepath = filepath;
    }

    @Override
    public List<String> getSymptoms() {
        List<String> result = new ArrayList<>();// declaration d'une  liste

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));// permettant d'ouvrir un fichier
            String line = reader.readLine(); // methode permettant de recuperer  la premiere ligne du fichier
             //Utilisation de la boucle while pour recuperer les lignes du fichier
            while (line != null) { //tant qu'il y'a des ligne , on les recuperer
                result.add(line);
                line = reader.readLine();
            }

            reader.close(); //fermiture du fichier
        } catch (IOException e) {
            e.printStackTrace();// utilisation de l'exception
        }
        return result;
    }



}
