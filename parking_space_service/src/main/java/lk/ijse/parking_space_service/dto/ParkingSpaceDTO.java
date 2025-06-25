package lk.ijse.parking_space_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingSpaceDTO {
    private Long id;
    private String location;
    private boolean isAvailable;
    private String slotNumber;
    private String type;
}


