package com.slokam.da.hc.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.da.hc.dao.VisitingDAO;
import com.slokam.da.hc.entity.Visiting;
import com.slokam.da.hc.exception.PatientException;
import com.slokam.da.hc.service.IVisitingService;

@Service
public class VisitingServiceImpl implements IVisitingService{

	private static Logger LOOGER = LoggerFactory.getLogger(VisitingServiceImpl.class);
	@Autowired
	private VisitingDAO visitingDao;
	
	@Override
	public void visit(Visiting visiting) throws PatientException {
		LOOGER.debug("Entered into visit method.");
		try {
			if(visiting!=null){
				LOOGER.debug("visiting details::"+visiting);
				visiting.setTime(new Date());
			  visitingDao.save(visiting);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PatientException("DB error", e);
		}
		LOOGER.debug("Exit from visit method.");
	}
	
}
