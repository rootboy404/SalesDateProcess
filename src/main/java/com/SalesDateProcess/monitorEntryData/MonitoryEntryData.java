package com.SalesDateProcess.monitorEntryData;

import com.SalesDateProcess.fileUtil.ReadFile;
import com.SalesDateProcess.service.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;


@Component
public class MonitoryEntryData {

    public static final String PATH_DATA_IN = "/data/in";
    public static final String USER_HOME = "user.home";


    public static void startMonitoryEntryData() throws IOException {
        Path path = ReadFile.readPath(System.getProperty(USER_HOME).concat(PATH_DATA_IN));

        WatchKey register = path.register(getWatchService(), StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_MODIFY);

        readExistingDataInTheDirectory(path);
        monitoryDataInTheDirectory(path, register);
    }

    private static void monitoryDataInTheDirectory(Path path, WatchKey register) throws IOException {
        while (true) {

            for (WatchEvent<?> event : register.pollEvents()) {
                Path dataPath = path.resolve((Path) event.context());
               readDataInDirectory(dataPath);
            }
        }
    }

    private static void readExistingDataInTheDirectory(Path path) throws IOException {
        Files.walk(path).filter(Files::isRegularFile).forEach(dataPath -> {readDataInDirectory(dataPath);});
    }

    private static void  readDataInDirectory(Path data){
        if (data.getFileName().toString().endsWith(".dat")){
            try {
                ProcessDataService processDataService = new ProcessDataService(new SalesmanService(new ArrayList<>()),new ClientService(new ArrayList<>()),new SaleService(new ArrayList<>(),new ItemService()));
                processDataService.processData(ReadFile.readData(data),data.getFileName().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static WatchService getWatchService() throws IOException {
        return FileSystems.getDefault().newWatchService();
    }
}
