package com.test.Futurum.restserver.mapper;


import com.test.Futurum.restserver.repository.CampaignEntity;
import com.test.Futurum.restserver.repository.TownEntity;

public class CampaignMapperRs implements Function<CampaignEntity, Campaign> {

    private Function<TownEntity, Town> townMapper;
    private static CampaignMapperRs instance = new CampaignMapperRs(TownMapperRs.getInstance());

    public CampaignMapperRs(Function<TownEntity, Town> townMapper) {
        this.townMapper = townMapper;
    }

    public static Function<CampaignEntity, Campaign> getInstance() {
        return instance;
    }

    @Override
    public Campaign apply(CampaignEntity campaignEntity) {
        // TODO add fluent builder in the future
        Campaign campaign = new Campaign();

        campaign.id(campaignEntity.getId());
        campaign.keyWords(campaignEntity.getKeyWorlds().stream().toList());
        campaign.campaignFund(campaignEntity.getCampaignFund());
        campaign.setStatus(campaignEntity.getStatus() ? Status.ON : Status.OFF);
        campaign.bidAmount(campaignEntity.getBidAmount());
        campaign.name(campaignEntity.getName());
        campaign.radius(campaignEntity.getRadius());
        campaign.setTown(townMapper.apply(campaignEntity.getTown()));

        return campaign;
    }
}
