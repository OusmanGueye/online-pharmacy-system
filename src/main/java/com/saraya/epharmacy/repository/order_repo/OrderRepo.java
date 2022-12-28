package com.saraya.epharmacy.repository.order_repo;

import com.saraya.epharmacy.modele.order_modele.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
