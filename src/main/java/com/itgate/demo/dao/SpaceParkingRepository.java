package com.itgate.demo.dao;

import com.itgate.demo.models.SpaceParking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpaceParkingRepository extends JpaRepository<SpaceParking,Long> {



}
