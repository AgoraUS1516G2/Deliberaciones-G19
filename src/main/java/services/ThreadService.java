package services;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ThreadRepository;
import domain.Thread;

@Service
@Transactional
public class ThreadService {

	// Managed repository --------------------
	@Autowired
	private ThreadRepository threadRepository;

	// Simple CRUD methods ----------
	public Thread save(Thread thread){
		return threadRepository.save(thread);
	}
	
	public Collection<Thread>  findAll(){
		return threadRepository.findAll();
	}
	
	public Thread findOne(int threadId) {
		return threadRepository.findOne(threadId);
	}
	
	//Other business methods -------------------
	public Thread findThreadByComment(int commentId) {
		return threadRepository.findThreadByComment(commentId);
	}
}