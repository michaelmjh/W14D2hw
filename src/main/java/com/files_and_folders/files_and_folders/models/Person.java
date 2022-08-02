package com.files_and_folders.files_and_folders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_id")
    private Long personId;
    @Column(name="person_name")
    private String personName;
    @JsonIgnoreProperties({"person"})
    @OneToMany(mappedBy = "person")
    private List<Folder> folders;

    public Person(String personName) {
        this.personName = personName;
        this.folders = new ArrayList<Folder>();
    }

    public Person() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
}
