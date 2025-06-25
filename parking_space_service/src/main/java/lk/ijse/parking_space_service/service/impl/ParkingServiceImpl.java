package lk.ijse.parking_space_service.service.impl;

import lk.ijse.parking_space_service.dto.ParkingSpaceDTO;
import lk.ijse.parking_space_service.entity.ParkingSpace;
import lk.ijse.parking_space_service.repo.ParkingRepository;
import lk.ijse.parking_space_service.service.ParkingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createParkingSpace(ParkingSpaceDTO parkingSpaceDTO) {
        ParkingSpace space = modelMapper.map(parkingSpaceDTO, ParkingSpace.class);
        parkingRepository.save(space);
    }

    @Override
    public List<ParkingSpaceDTO> getAllSpaces() {
        List<ParkingSpace> spaces = parkingRepository.findAll();
        return spaces.stream().map(space -> modelMapper.map(space, ParkingSpaceDTO.class)).toList();
    }

    @Override
    public void updateParkingSpace(Long id, ParkingSpaceDTO parkingSpaceDTO) {
        ParkingSpace space = modelMapper.map(parkingSpaceDTO, ParkingSpace.class);
        space.setId(id);
        parkingRepository.save(space);
    }

    @Override
    public void deleteParkingSpace(Long id) {
        if (parkingRepository.existsById(id)) {
            parkingRepository.deleteById(id);
        }else {
            throw new RuntimeException("Parking space not found");
        }
    }
}
