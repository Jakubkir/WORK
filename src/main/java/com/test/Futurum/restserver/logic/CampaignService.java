package com.test.Futurum.restserver.logic;


public interface CampaignService {

    Optional<Campaign> find(Long id);

    void delete(Long id);

    List<Campaign> list();

    void save(Campaign campaign);

    void update(Campaign campaign);
}
