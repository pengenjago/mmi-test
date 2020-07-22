package com.mmi.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeeDto {
	private int id;

	private String name;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private Integer positionId;
	private String positionName;

	private Integer idNumber;
	private Integer gender;
	private Integer isDelete;
}
