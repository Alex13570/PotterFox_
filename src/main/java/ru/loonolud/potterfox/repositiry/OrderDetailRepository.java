package ru.loonolud.potterfox.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox.model.OrderDetailEntity;

import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, UUID> {
}
