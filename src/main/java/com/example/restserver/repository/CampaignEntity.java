package com.example.restserver.repository;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.REFRESH;

@Entity
@Table(name = "campaigns")
public class CampaignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAMPAIGN_GEN")
    @SequenceGenerator(sequenceName = "CAMPAIGN_SEQ", name = "CAMPAIGN_GEN", initialValue = 10)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String campaignFund;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bid_amount_ID", nullable = false)
    @Min(100)
    private Min bidAmount;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "radius", nullable = false)
    private Double radius;

    @OneToOne(cascade = {REFRESH})
    @JoinColumn(name = "town_id")
    private TownEntity town;

    @ElementCollection
    @Column(name = "KEY_WORD", nullable = false)
    @CollectionTable(
            name = "KEY_WORDS",
            joinColumns = @JoinColumn(name = "campaignId")
    )
    private List<String> keyWorlds = new ArrayList<>();

    public void setBidAmount(Min bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Min getBidAmount() {
        return bidAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCampaignFund() {
        return campaignFund;
    }

    public void setCampaignFund(String campaignFund) {
        this.campaignFund = campaignFund;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public TownEntity getTown() {
        return town;
    }

    public void setTown(TownEntity town) {
        this.town = town;
    }

    public List<String> getKeyWorlds() {
        return keyWorlds;
    }

    public void setKeyWorlds(List<String> keyWorlds) {
        this.keyWorlds = keyWorlds;
    }
}
