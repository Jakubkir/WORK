package com.example.restserver.logic;

import com.campaign.model.Campaign;

import java.util.List;
import java.util.Optional;

public interface CampaignService {

    Optional<Campaign> find(Long id);

    void delete(Long id);

    List<Campaign> list();

    void save(Campaign campaign);

    void update(Campaign campaign);
}
