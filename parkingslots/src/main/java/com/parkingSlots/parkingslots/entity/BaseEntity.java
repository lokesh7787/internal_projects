package com.parkingSlots.parkingslots.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Setter
@Getter
@ToString
public class BaseEntity {

	
	private LocalDateTime updateAt;
	private String updateBy;
	private LocalDateTime insertedAt;
	private String insertedBy;
	
}
