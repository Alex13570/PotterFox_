package ru.loonolud.potterfox_.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox_.model.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {
}
