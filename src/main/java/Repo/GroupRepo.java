package Repo;

import models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepo extends JpaRepository<Group, Long>{

    @Override
    Optional<Group> findById(Long aLong);
}
