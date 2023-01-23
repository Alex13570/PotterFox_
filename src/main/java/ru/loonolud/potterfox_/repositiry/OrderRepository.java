package ru.loonolud.potterfox_.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox_.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
