package com.itgate.demo.dao;

import com.itgate.demo.models.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjetRepository extends JpaRepository<Projet,Long> {
}
