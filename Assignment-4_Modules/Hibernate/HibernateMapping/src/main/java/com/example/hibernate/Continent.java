package com.example.hibernate;
import jakarta.persistence.*;
import java.util.*;
@Entity
@Table(name = "continent")
public class Continent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cname;
    @ElementCollection
    @CollectionTable(name = "countries", joinColumns = @JoinColumn(name = "continent_id"))
    @MapKeyColumn(name = "country")
    @Column(name = "capital")
    private Map<String, String> countries = new HashMap<>();
    public Continent() {}
    public Continent(String cname) { this.cname = cname; }
    public void addCountry(String country, String capital) {
        countries.put(country, capital);
    }
}