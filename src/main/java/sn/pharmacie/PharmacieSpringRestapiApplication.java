package sn.pharmacie;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import sn.pharmacie.dao.PharmacieRepository;
import sn.pharmacie.entities.Pharmacie;


@SpringBootApplication
public class PharmacieSpringRestapiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(PharmacieSpringRestapiApplication.class, args);
	
		PharmacieRepository pharmacieRepository = ctx.getBean(PharmacieRepository.class);
		
//		Pharmacie ph = new Pharmacie();
//		ph.setEtat(1);
//		ph.setNom("Dial DIOP");
//		ph.setQuartier("Cité pricipal");
//		ph.setVille("Dakar");
//		pharmacieRepository.save(ph);
	}

}
