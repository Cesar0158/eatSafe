package pe.edu.upc.eatSafe.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.edu.upc.eatSafe.business.crud.OpinionService;
import pe.edu.upc.eatSafe.model.entity.Opinion;

public class OpinionView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Opinion> opinions;
	private Opinion opinionSelected;
	private List<Opinion> opinionsSelected;
	private Opinion opinionSearch;
	
	@Inject
	private OpinionService opinionService;
	
	@PostConstruct
	public void init() {
		opinionsSelected = new ArrayList<>();
		opinionSearch = new Opinion();
	/*	getAllOpinion();*/
	}
	
	
}
