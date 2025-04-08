package com.parkingSlots.parkingslots.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parking_slot_entity")
public class ParkingSlotEntity extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String vechicleNumber;
	private String floor;
	private int slotNumber;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

}
