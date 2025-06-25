package lk.ijse.parking_space_service.controller;

import lk.ijse.parking_space_service.dto.ParkingSpaceDTO;
import lk.ijse.parking_space_service.dto.ResponseDTO;
import lk.ijse.parking_space_service.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
@CrossOrigin(origins = "*")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> addParking(@RequestBody ParkingSpaceDTO parkingSpaceDTO) {
        parkingService.createParkingSpace(parkingSpaceDTO);
        return ResponseEntity.ok(new ResponseDTO("success", "Parking space saved successfully"));
    }

    @GetMapping("/allSpaces")
    public ResponseEntity<List<ParkingSpaceDTO>> getAllSpaces() {
        return ResponseEntity.ok(parkingService.getAllSpaces());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateParking(@PathVariable Long id, @RequestBody ParkingSpaceDTO parkingSpaceDTO) {
        parkingService.updateParkingSpace(id, parkingSpaceDTO);
        return ResponseEntity.ok(new ResponseDTO("success", "Parking space updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteParking(@PathVariable Long id) {
        parkingService.deleteParkingSpace(id);
        return ResponseEntity.ok(new ResponseDTO("success", "Parking space deleted successfully"));
    }
}
