package sn.pharmacie.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sn.pharmacie.dao.PharmacieRepository;
import sn.pharmacie.entities.Pharmacie;

@RestController
public class PharmacieRestService {

	@Autowired
	private PharmacieRepository pharmacieRepository;
	
	@GetMapping(value = "/pharmacies")
	public List<Pharmacie> getPharmacies() {
		
		return pharmacieRepository.findAll();
	}
	
	@GetMapping(value = "/pharmacies/{id}")
	public Pharmacie getPharmacie(@PathVariable Long id) {
		
		return pharmacieRepository.getOne(id);
	}
	
	
	@PostMapping(value = "/pharmacies")
	public Pharmacie addParmacie( @RequestBody Pharmacie ph) {
		
		return pharmacieRepository.save(ph);
	}
	
	@PutMapping(value = "/pharmacies/{id}")
	public Pharmacie updatePharmacies(@PathVariable Long id, @RequestBody Pharmacie ph) {
		Pharmacie phar = new Pharmacie();
		phar = ph;
		phar.setId(id);
		return pharmacieRepository.save(phar);
	}
	
	@DeleteMapping(value = "/pharmacies/{id}")
	public void deletePharmacie(@PathVariable Long id) {
		 pharmacieRepository.deleteById(id);;
	}
	
	@GetMapping(value = "/findPharmacie")
	public List<Pharmacie> getPharmacieByNom(
				@RequestParam(name = "nom",defaultValue = "") String nom) {
		
		return pharmacieRepository.getPharmacieByNom("%"+nom+"%");
	}
	
}
