package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityModel {
	 private String activity;
	    private String type;
	    private String link;
	    private String key;
	    private Integer participants;
	    private Double price;
	    private Double accessibility;

}
