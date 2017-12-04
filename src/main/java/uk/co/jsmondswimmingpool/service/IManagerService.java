package uk.co.jsmondswimmingpool.service;

import uk.co.jsmondswimmingpool.entity.Tutor;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.ErrorBean;

public interface IManagerService {



	CommonEntity login(Tutor tutor);
	CommonEntity error(ErrorBean tutor);

}
