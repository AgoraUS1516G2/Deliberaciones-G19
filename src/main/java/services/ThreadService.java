package services;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ThreadRepository;
import domain.Hilo;

@Service
@Transactional
public class ThreadService {

	// Managed repository --------------------
	@Autowired
	private ThreadRepository threadRepository;

	// Simple CRUD methods ----------
	public Hilo save(Hilo thread){
		return threadRepository.save(thread);
	}
	
	public Collection<Hilo>  findAll(){
		return threadRepository.findAll();
	}
	
	public Hilo findOne(int threadId) {
		return threadRepository.findOne(threadId);
	}
	
	//Other business methods -------------------
	public Hilo findThreadByComment(int commentId) {
		return threadRepository.findThreadByComment(commentId);
	}
}