package lk.ijse.vehicle_service.service;

import lk.ijse.vehicle_service.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(Long id);

    List<VehicleDTO> getAllVehicles();

    void deleteVehicle(Long id);
}
