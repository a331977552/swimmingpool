package uk.co.jsmondswimmingpool.service;

import uk.co.jsmondswimmingpool.entity.Tutor;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;

public interface ITutorService {

	CommonEntity addTutor(Tutor tutor);

	CommonEntity deleteTutor(Long id);

	CommonEntity updateTutor(Tutor tutor);

	CommonEntity getTutor(Long id);

	CommonEntity getAllTutor(TutorVo vo);

	CommonEntity login(Tutor tutor);

}
