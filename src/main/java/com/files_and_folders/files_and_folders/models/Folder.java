package com.files_and_folders.files_and_folders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="folder")
public class Folder {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="folder_id")
    private Long folderId;
    @Column(name="folder_title")
    private String folderTitle;
    @JsonIgnoreProperties({"folder"})
    @OneToMany(mappedBy = "folder")
    private List<File> files;
    @ManyToOne
    @JoinColumn(name="person_id", nullable = false)
    private Person person;

    public Folder(String folderTitle, Person person) {
        this.folderTitle = folderTitle;
        this.files = new ArrayList<File>();
        this.person = person;
    }

    public Folder() {
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    public String getFolderTitle() {
        return folderTitle;
    }

    public void setFolderTitle(String folderTitle) {
        this.folderTitle = folderTitle;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void addFile(File file){
        this.files.add(file);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
