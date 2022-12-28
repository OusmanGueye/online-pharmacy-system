package com.saraya.epharmacy.repository.stock_repo;

import com.saraya.epharmacy.modele.stock_modele.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock, Integer> {
}
