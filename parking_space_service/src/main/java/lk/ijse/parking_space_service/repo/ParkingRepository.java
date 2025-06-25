package lk.ijse.parking_space_service.repo;

import lk.ijse.parking_space_service.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingSpace, Long> {
    Collection<Object> findByIsAvailable(boolean status);

    Collection<Object> findByLocationContainingIgnoreCase(String location);
}

