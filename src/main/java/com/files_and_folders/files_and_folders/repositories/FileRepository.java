package com.files_and_folders.files_and_folders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.files_and_folders.files_and_folders.models.File;

public interface FileRepository extends JpaRepository<File, Long> {
}
