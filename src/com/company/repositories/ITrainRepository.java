package com.company.repositories;

import com.company.entities.Train;

import java.util.List;

public interface ITrainRepository {
    boolean createTrain(Train train);
    Train getTrain(int id);
    List<Train> getAllTrains();
}
