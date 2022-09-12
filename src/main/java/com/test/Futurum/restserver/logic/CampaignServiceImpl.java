package com.test.Futurum.restserver.logic;


import com.test.Futurum.restserver.mapper.CampaignMapperRq;
import com.test.Futurum.restserver.mapper.CampaignMapperRs;
import com.test.Futurum.restserver.mapper.TownMapperRs;
import com.test.Futurum.restserver.repository.CampaignEntity;
import com.test.Futurum.restserver.repository.CampaignRepository;
import com.test.Futurum.restserver.repository.TownEntity;
import com.test.Futurum.restserver.repository.TownRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.stream.StreamSupport;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final Function<CampaignEntity, Campaign> mapperRs = CampaignMapperRs.getInstance();
    private final BiFunction<Campaign, TownEntity, CampaignEntity> mapperRq = CampaignMapperRq.getInstance();
    private final Function<TownEntity, Town> townMapper = TownMapperRs.getInstance();
    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private TownRepository townRepository;


    @Override
    public Optional<Campaign> find(Long id) {
        return campaignRepository.findById(id)
                .map(mapperRs::apply);
    }

    @Override
    public void delete(Long id) {
        campaignRepository.deleteById(id);
    }

    @Override
    public List<Campaign> list() {
        // TODO add pagination, all results are collected at once it may cause issues with bigger data sets
        return StreamSupport.stream(campaignRepository.findAll().spliterator(), false)
                .map(mapperRs::apply)
                .toList();
    }

    @Override
    @Transactional
    public void save(Campaign campaign) {
        var townEntity = townRepository.findById(campaign.getTown().getId()).orElseThrow();
        campaignRepository.save(mapperRq.apply(campaign, townEntity));
    }

    @Transactional
    @Override
    public void update(Campaign campaign) {
        var townEntity = townRepository.findById(campaign.getTown().getId()).orElseThrow();

        campaignRepository.save(mapperRq.apply(campaign, townEntity));
    }
}
