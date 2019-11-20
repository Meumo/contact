package contactbackend.mo.izi.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import contactbackend.mo.izi.entities.Contact;
@CrossOrigin("*")
@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long>{
	@RestResource(path = "contactByKeyword")
	public Page<Contact> findByNomContains(@Param("mc")String mc,Pageable pageable);

}
