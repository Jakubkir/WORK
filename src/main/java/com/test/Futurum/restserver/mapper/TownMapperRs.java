package com.test.Futurum.restserver.mapper;


import com.test.Futurum.restserver.repository.TownEntity;

public class TownMapperRs implements Function<TownEntity, Town> {

    private static TownMapperRs instance = new TownMapperRs();

    public static Function<TownEntity, Town> getInstance(){
        return instance;
    }

    @Override
    public Town apply(TownEntity townEntity) {
        // TODO add fluent builder in the future
        Town town = new Town();
        town.id(townEntity.getId());
        town.name(townEntity.getName());

        return town;
    }
}
