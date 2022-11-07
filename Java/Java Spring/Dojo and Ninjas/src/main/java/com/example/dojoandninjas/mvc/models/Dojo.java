package com.example.dojoandninjas.mvc.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
    @Table(name="dojos")
    public class Dojo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        @Column(updatable=false)
        private Date createdAt;
        private Date updatedAt;
        @OneToMany(mappedBy="dojo", fetch=FetchType.LAZY) // معناها اسم الجدول يلي رح احط الاي دي تاعه بالتاني
        private List<Ninja> ninjas;

    public Dojo(String name, Date createdAt, Date updatedAt, List<Ninja> ninjas, Ninja ninja) {
            this.setNinjas(ninjas);
            this.setName(name);
            this.setCreatedAt(createdAt);
            this.setUpdatedAt(updatedAt);
            this.setNinja(ninjas);
        }

    public Dojo() {

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    public List<Ninja> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }

    public void setNinja(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }

    public List<Ninja> getNinja(List<Ninja> ninja) {
        return ninja;
    }
    // ...
        // getters and setters removed for brevity
        // ...
    }

