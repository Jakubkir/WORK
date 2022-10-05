package com.example.restserver.logic;

import com.campaign.model.Campaign;
import com.campaign.model.Town;
import com.example.restserver.mapper.CampaignMapperRq;
import com.example.restserver.mapper.CampaignMapperRs;
import com.example.restserver.mapper.TownMapperRs;
import com.example.restserver.repository.CampaignEntity;
import com.example.restserver.repository.CampaignRepository;
import com.example.restserver.repository.TownEntity;
import com.example.restserver.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
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
