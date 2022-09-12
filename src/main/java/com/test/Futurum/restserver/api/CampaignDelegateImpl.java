package com.test.Futurum.restserver.api;


import com.test.Futurum.restserver.logic.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CampaignDelegateImpl implements CampaignsApiDelegate {

    @Autowired
    private CampaignService campaignService;

    @Override
    public ResponseEntity<Campaign> getCampaignById(Long campaignId) {
        return ResponseEntity.of(campaignService.find(campaignId));
    }

    @Override
    public ResponseEntity<Void> addCampaign(Campaign campaign) {
        campaignService.save(campaign);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteCampaign(Long campaignId) {
        campaignService.delete(campaignId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Campaign>> listCampaigns() {
        return ResponseEntity.ok(campaignService.list());
    }

    @Override
    public ResponseEntity<Void> updateCampaign(Campaign campaign) {
        campaignService.update(campaign);
        return ResponseEntity.ok().build();
    }
}
