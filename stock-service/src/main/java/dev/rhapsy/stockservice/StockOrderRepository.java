package dev.rhapsy.stockservice;

import dev.rhapsy.stockservice.entity.StockOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockOrderRepository extends JpaRepository<StockOrder, Long> {
}
