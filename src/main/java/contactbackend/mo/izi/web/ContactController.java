package contactbackend.mo.izi.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import contactbackend.mo.izi.dao.ContactRepository;
import contactbackend.mo.izi.entities.Contact;

@CrossOrigin("*")
@RestController
public class ContactController {
	@Autowired
	ContactRepository contactRepository;

	@CrossOrigin("*")
	@GetMapping(path = "/photoContact/{id}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
		Contact contact = contactRepository.findById(id).get();

		return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/ecom/products/" + contact.getPhoto()));
	}

	@CrossOrigin("*")
	@PostMapping(path = "/uploadPhoto/{id}")
	public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception {
		Contact c = contactRepository.findById(id).get();
		c.setPhoto(c.getId() + ".png");
		Files.write(Paths.get(System.getProperty("user.home") + "/ecom/products/" + c.getPhoto()), file.getBytes());
		contactRepository.save(c);
	}
}
