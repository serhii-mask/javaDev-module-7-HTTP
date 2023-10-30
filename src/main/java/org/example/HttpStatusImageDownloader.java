package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws IOException {
        String imageUrl = new HttpStatusChecker().getStatusImage(code);

        try(InputStream in = new URL(imageUrl).openStream()) {
            String path = "cats/" + code + ".jpg";
            if (!new File(path).exists()) {
                Files.copy(in, Paths.get(path));
            } else {
                System.out.println("File with code " + code + " already exist!");
            }
        } catch(Exception e) {
            throw new FileNotFoundException("File with code " + code + " already exist!");
        }
    }
}
