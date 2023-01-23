package ru.loonolud.potterfox_.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox_.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
