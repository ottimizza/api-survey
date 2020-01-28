package com.questions.survey.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.questions.survey.dto.SurveyDTO;
import com.questions.survey.models.Survey;


public class SurveyMapper {

/* private String respStr;
	
	private double respDoub;
	
	private long idQst;
	
	private long idUser;
	
	private long idOrg;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataResp; */
	public static Survey fromDto(SurveyDTO surveyDTO) {
		return Survey.builder()
				.id(surveyDTO.getId())
				.respStr(surveyDTO.getRespStr())
				.respDoub(surveyDTO.getRespDoub())
				.idQst(surveyDTO.getIdQst())
				.idOrg(surveyDTO.getIdOrg())
				.idUser(surveyDTO.getIdUser())
				.build();
	}
	
	public static SurveyDTO fromEntity(Survey survey) {
		return SurveyDTO.builder()
				.id(survey.getId())
				.respStr(survey.getRespStr())
				.respDoub(survey.getRespDoub())
				.idQst(survey.getIdQst())
				.idOrg(survey.getIdOrg())
				.idUser(survey.getIdUser())
				.build();
	}
	/*public static List<LancamentoDTO> fromEntities(List<Lancamento> lancamentos) {
        return lancamentos.stream().map(user -> fromEntity(user)).collect(Collectors.toList());
    } */
	
	public static List<SurveyDTO> fromEntities(List<Survey> surveys) {
		return surveys.stream().map(idQst -> fromEntity(idQst)).collect(Collectors.toList());
	}
	
}
