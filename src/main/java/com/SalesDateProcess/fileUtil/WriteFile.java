package com.SalesDateProcess.fileUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteFile {

    public  static void WriteFileInDirectory(String textTemplate,String fileName,String pathDirectory) throws IOException {
        Files.write(Paths.get(pathDirectory.concat(fileName.concat(".done.dat"))),textTemplate.getBytes("utf-8") ,StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }





}
