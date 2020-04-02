package com.SalesDateProcess;

import com.SalesDateProcess.monitorEntryData.MonitoryEntryData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SalesDateProcessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesDateProcessApplication.class, args);
        try {
            MonitoryEntryData.startMonitoryEntryData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
