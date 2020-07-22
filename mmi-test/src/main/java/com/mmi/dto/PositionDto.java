package com.mmi.dto;

import lombok.Data;

@Data
public class PositionDto {
	private int id;

	private String code;
	private String name;
	private Integer isDelete;
}
