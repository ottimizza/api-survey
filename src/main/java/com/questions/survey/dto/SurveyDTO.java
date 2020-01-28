package com.questions.survey.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long id;
	
	private String descQst;
	
	private String aliasQst;	
	
	private String respStr;
	
	private double respDoub;
	
	private long idQst;
	
	private long idUser;
	
	private long idOrg;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataResp;

}
