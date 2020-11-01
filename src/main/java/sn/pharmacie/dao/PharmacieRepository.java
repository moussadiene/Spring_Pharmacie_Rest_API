package sn.pharmacie.dao;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sn.pharmacie.entities.Pharmacie;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {

	@Query("SELECT p FROM Pharmacie p WHERE p.nom like:var")
	public List<Pharmacie> getPharmacieByNom(@Param("var")String nom);
}
