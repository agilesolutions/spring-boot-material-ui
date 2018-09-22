package com.example.about.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final String name;

    @OneToOne
    private final Address address;
    
    private final String website;

    @OneToMany
    private final List<Position> positions;

    public Company(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.website = builder.website;
        this.positions = builder.positions;
    }

    // Spring Boot JPA needs the default constructor so stub out with null values.
    public Company() {
        this.name = null;
        this.address = null;
        this.website = null;
        this.positions = null;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    public List<Position> getPositions() {
        if (positions == null) {
            return new ArrayList<>();
        }
        return positions;
    }

    public static class Builder {

        private String name;

        private Address address;

        private String website;

        private List<Position> positions;

        public Company build(CompanyRepository repository) {
            Company company = new Company(this);

            if (repository != null) {
                repository.save(company);
            }

            return company;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder website(String website) {
            this.website = website;
            return this;
        }

        public Builder positions(List<Position> positions) {
            this.positions = positions;
            return this;
        }
    }
}
