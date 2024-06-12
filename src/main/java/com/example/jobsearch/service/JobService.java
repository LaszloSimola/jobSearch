package com.example.jobsearch.service;

import com.example.jobsearch.model.Client;
import com.example.jobsearch.model.Position;

import java.util.List;

public interface JobService {
    public String register(Client client);
    public String createPosition(Position position);
    public List<Position> getPositions();
    public List<Position> searchPositions(String keyword, String location);
    public List<Client> getClients();

}
