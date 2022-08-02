package com.files_and_folders.files_and_folders.components;

import com.files_and_folders.files_and_folders.models.File;
import com.files_and_folders.files_and_folders.models.FileType;
import com.files_and_folders.files_and_folders.models.Folder;
import com.files_and_folders.files_and_folders.models.Person;
import com.files_and_folders.files_and_folders.repositories.FileRepository;
import com.files_and_folders.files_and_folders.repositories.FolderRepository;
import com.files_and_folders.files_and_folders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    PersonRepository personRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Person person1 = new Person("bob");
        personRepository.save(person1);
        Person person2 = new Person("lou");
        personRepository.save(person2);

        Folder folder1 = new Folder("bobs folder", person1);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("lous folder", person2);
        folderRepository.save(folder2);

        File file1 = new File("bobs file", FileType.ppt, 100, folder1);
        fileRepository.save(file1);
        File file2 = new File("louss file", FileType.ppt, 100, folder2);
        fileRepository.save(file2);
    }
}

