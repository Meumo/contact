package contactbackend.mo.izi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import contactbackend.mo.izi.dao.ContactRepository;
import contactbackend.mo.izi.entities.Contact;
import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class ContactBackendApplication implements CommandLineRunner {
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	RepositoryRestConfiguration configuration;

	public static void main(String[] args) {
		SpringApplication.run(ContactBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(Contact.class);
		for (int i = 0; i < 10; i++) {
			contactRepository.save(new Contact(null, RandomString.make(15), RandomString.make(17),
					RandomString.make(17), RandomString.make(17), "unknown.png"));
		}

	}

}
