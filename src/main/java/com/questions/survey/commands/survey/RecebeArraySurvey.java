package com.questions.survey.commands.survey;

import java.io.Serializable;
import java.util.List;

import com.questions.survey.dto.SurveyDTO;

import lombok.Data;

@Data
public class RecebeArraySurvey implements Serializable{

	private static final long serialVersionUID = 1L;

    private long idOrg;

    private long idUser;

    private List<SurveyDTO> questions;
}
