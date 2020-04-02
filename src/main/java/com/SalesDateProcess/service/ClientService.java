package com.SalesDateProcess.service;

import com.SalesDateProcess.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    List<Client> clientList;

    public ClientService(List<Client> clientList) {
        this.clientList = clientList;
    }

    public void addClient( String[] valueClient){
        if(valueClientIsValid(valueClient)){
            clientList.add(Client.builder().cnpj(valueClient[1]).name(valueClient[2]).businessArea(valueClient[3]).build());
        }
    }

    private Boolean valueClientIsValid(String[] valueClient) {
        if(valueClient.length == 4){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Integer getQuantityClient() {
        return clientList.size();
    }

}
