package lk.ijse.vehicle_service.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.entity.Vehicle;
import lk.ijse.vehicle_service.repo.VehicleRepository;
import lk.ijse.vehicle_service.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        vehicleRepository.save(modelMapper.map(vehicleDTO, Vehicle.class));

    }

    @Override
    public void updateVehicle(Long id) {
        vehicleRepository.updateExitTime(id);

    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream().map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class)).toList();
    }

    @Override
    public void deleteVehicle(Long id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Vehicle not found");
        }
    }

}
