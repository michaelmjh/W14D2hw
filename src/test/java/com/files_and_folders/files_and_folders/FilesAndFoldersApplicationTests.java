package com.files_and_folders.files_and_folders;

import com.files_and_folders.files_and_folders.models.File;
import com.files_and_folders.files_and_folders.models.FileType;
import com.files_and_folders.files_and_folders.models.Folder;
import com.files_and_folders.files_and_folders.models.Person;
import com.files_and_folders.files_and_folders.repositories.FileRepository;
import com.files_and_folders.files_and_folders.repositories.FolderRepository;
import com.files_and_folders.files_and_folders.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilesAndFoldersApplicationTests {

	@Autowired
	FileRepository fileRepository;
	@Autowired
	FolderRepository folderRepository;
	@Autowired
	PersonRepository personRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createFileFolderPerson(){

		Person person = new Person("bob");
		personRepository.save(person);

		Folder folder = new Folder("bobs folder", person);
		folderRepository.save(folder);

		File file = new File("bobs file", FileType.ppt, 100, folder);
		fileRepository.save(file);
	}

}
