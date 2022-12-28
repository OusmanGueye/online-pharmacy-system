package com.saraya.epharmacy.repository.delivery_repo;

import com.saraya.epharmacy.modele.delivery_modele.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Integer> {

}
