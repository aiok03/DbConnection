package com.company.repositories.interfaces;

import com.company.entities.Locomative;

import java.util.List;

public interface ILocomativeRepository {
    boolean createLocomative(Locomative locomative);
    Locomative getLocomative(int id);
    List<Locomative> getAllLocomatives();
}
