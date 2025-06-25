package lk.ijse.vehicle_service.controller;

import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.service.VehicleService;
import lk.ijse.vehicle_service.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.saveVehicle(vehicleDTO);
        return ResponseEntity.ok(new ResponseDTO("success", "Vehicle saved successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateVehicle(@PathVariable Long id) {
        vehicleService.updateVehicle(id);
        return ResponseEntity.ok(new ResponseDTO("success", "Vehicle exit time update successfully"));
    }

    @GetMapping("/allVehicles")
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok(new ResponseDTO("success", "Vehicle deleted successfully"));
    }
}
