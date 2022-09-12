package com.test.Futurum.restserver.mapper;


import com.test.Futurum.restserver.repository.TownEntity;

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
