package com.test.Futurum.restserver.repository;



@Entity
@Table(name = "towns")
public class TownEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOWN_GEN")
    @SequenceGenerator(sequenceName = "TOWN_SEQ", name = "TOWN_GEN", initialValue = 10)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

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
}
