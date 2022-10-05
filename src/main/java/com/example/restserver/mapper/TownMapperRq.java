package com.example.restserver.mapper;

import com.campaign.model.Town;
import com.example.restserver.repository.TownEntity;
import org.springframework.cglib.core.internal.Function;

public class TownMapperRq implements Function<Town, TownEntity> {

    private static TownMapperRq instance = new TownMapperRq();

    public static Function<Town, TownEntity> getInstance() {
        return instance;
    }

    @Override
    public TownEntity apply(Town town) {
        TownEntity townEntity = new TownEntity();
        town.id(town.getId());
        town.name(town.getName());
        return townEntity;
    }
}
