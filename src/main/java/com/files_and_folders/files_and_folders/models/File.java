package com.files_and_folders.files_and_folders.models;

import javax.persistence.*;

@Entity
@Table(name="files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="file_id")
    private Long fileId;
    @Column(name="file_name")
    private String fileName;
    @Column(name="file_type")
    private FileType fileType;
    @Column(name="file_size")
    private int fileSize;
    @ManyToOne
    @JoinColumn(name="folder_id", nullable = false)
    private Folder folder;

    public File(String fileName, FileType fileType, int fileSize, Folder folder) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.folder = folder;
    }

    public File() {
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
