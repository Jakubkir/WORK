package com.example.restserver.mapper;

import com.campaign.model.Campaign;
import com.campaign.model.Status;
import com.campaign.model.Town;
import com.example.restserver.repository.CampaignEntity;
import com.example.restserver.repository.TownEntity;
import org.springframework.cglib.core.internal.Function;

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
