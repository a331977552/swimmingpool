package uk.co.jsmondswimmingpool.service;

import uk.co.jsmondswimmingpool.entity.Tutor;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;

public interface IManagerService {


	CommonEntity login(Tutor tutor);

}
