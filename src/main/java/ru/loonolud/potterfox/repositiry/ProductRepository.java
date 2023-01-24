package ru.loonolud.potterfox.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox.model.ProductEntity;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
