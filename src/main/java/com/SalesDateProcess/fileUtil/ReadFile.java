package com.SalesDateProcess.fileUtil;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFile {

    public static Path readPath(String path){
        return Paths.get(path);
    }

    public static List<String> readData(Path path) throws IOException {
        return Files.lines(path).collect(Collectors.toList());
    }
}
