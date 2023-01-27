package pl.robertprogramista.dockerexperiments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class ExampleController {
    @GetMapping("/example1")
    public String getExample1() {
        String sourcePath = "/opt/app/src/source1.txt";
        try {
            Path path = Paths.get(sourcePath);
            byte[] bytes = Files.readAllBytes(path);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            return "Datasource not found or contains an error!" + "" + ex + ex.getMessage();
        }
    }
}
