package lk.ijse.parking_space_service.service;

import lk.ijse.parking_space_service.dto.ParkingSpaceDTO;

import java.util.List;

public interface ParkingService {
    void createParkingSpace(ParkingSpaceDTO parkingSpaceDTO);

    List<ParkingSpaceDTO> getAllSpaces();

    void updateParkingSpace(Long id, ParkingSpaceDTO parkingSpaceDTO);

    void deleteParkingSpace(Long id);

}
