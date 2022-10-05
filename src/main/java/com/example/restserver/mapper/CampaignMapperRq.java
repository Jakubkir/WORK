package com.example.restserver.mapper;

import com.campaign.model.Campaign;
import com.campaign.model.Status;
import com.example.restserver.repository.CampaignEntity;
import com.example.restserver.repository.TownEntity;

import javax.transaction.Transactional;
import java.util.function.BiFunction;

public class CampaignMapperRq implements BiFunction<Campaign, TownEntity, CampaignEntity> {

    private static CampaignMapperRq instance = new CampaignMapperRq();

    public static BiFunction<Campaign, TownEntity, CampaignEntity> getInstance() {
        return instance;
    }

    @Transactional
    @Override
    public CampaignEntity apply(Campaign campaign, TownEntity townEntity) {
        // TODO add fluent builder in the future
        CampaignEntity campaignEntity = new CampaignEntity();

        campaignEntity.setId(campaign.getId());
        campaignEntity.setKeyWorlds(campaign.getKeyWords());
        campaignEntity.setCampaignFund(campaign.getCampaignFund());
        campaignEntity.setStatus(campaign.getStatus() == Status.ON);
        campaignEntity.setBidAmount(campaign.getBidAmount());
        campaignEntity.setName(campaign.getName());
        campaignEntity.setRadius(campaign.getRadius());

        campaignEntity.setTown(townEntity);

        return campaignEntity;
    }
}
