package com.ecom.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDto {

	private Long id;

	private LocalDate createdOn;

	private LocalDateTime updatedOn;
}
