package com.ams.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ams.dao.AlumniDAO;
import com.ams.daoimpl.AlumniDaoImpl;
import com.ams.dto.AlumniDTO;
import com.ams.entity.Alumni;
import com.ams.exception.GlobalException;
import com.ams.service.AlumniService;
import com.ams.util.Converter;

public class AlumniServiceImpl implements AlumniService {
	
	//declaring globally so each method can have access of these objects
	Converter converter = new Converter();
	AlumniDAO alumniDao = new AlumniDaoImpl();					// instantiating Polymorphic Dao
	private static Logger logger = LogManager.getLogger(AlumniServiceImpl.class);
	
	@Override
	public void addAlumni(Alumni alumni) {
		alumniDao.addAlumni(alumni);
		logger.info("new alumni A/c created " + alumni + " and creation time is " + new java.util.Date());
	}

	@Override
	public List<AlumniDTO> fetchAlumni(long alroll, String alpassword) throws GlobalException {
		List<Alumni> alumni = alumniDao.fetchAlumni(alroll, alpassword);
		logger.info("alumni data fetched " + alumni + " and time is " + new java.util.Date());
		
		//converting list of Alumni into list of AlumniDTO
		List<AlumniDTO> alumniDTO = alumni.stream().map(x->converter.EntitytoDTO_Alumni(x)).collect(Collectors.toList());
		
		// null validation and returning
		return Optional.of(alumniDTO).orElseThrow(() -> new GlobalException("Alumni does not exists"));
	}

	@Override
	public AlumniDTO changePassword(long alroll, String alpassword, Alumni alumni) throws GlobalException {
		Alumni updatedAlumni =alumniDao.changePassword(alroll, alpassword, alumni);
		logger.info("admin password updated " + alumni + " and time is " + new java.util.Date());
		
		//convetring to DTO
		AlumniDTO alumniDTO = converter.EntitytoDTO_Alumni(updatedAlumni);
		
		return Optional.of(alumniDTO).orElseThrow(() -> new GlobalException("Alumni does not exists"));

	}

}