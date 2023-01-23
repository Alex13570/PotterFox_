package ru.loonolud.potterfox_.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loonolud.potterfox_.model.UserDetailsEntity;

public interface UserRepository extends JpaRepository<UserDetailsEntity, Long> {
}
