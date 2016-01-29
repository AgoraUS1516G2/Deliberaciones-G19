package domain;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;

@Entity
@Access(AccessType.PROPERTY)
public class User extends Actor{
	
	
	//Atributtes
	private boolean banned;
	private int numberOfMessages;
	private String url;
	
	//Constructor
	public User(){
		super();
	}
	
	//RelationShips
	Collection<Comment> comments;
	Collection<Hilo> threads;

	//Getters and Setters
	@NotNull
	public boolean isBanned() {
		return banned;
	}
	
	public void setBanned(boolean banned) {
		this.banned = banned;
	}
	
	public int getNumberOfMessages() {
		return numberOfMessages;
	}
	
	public void setNumberOfMessages(int numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
	}
	
	@SafeHtml
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@NotNull
	@OneToMany(mappedBy="user")
	public Collection<Comment> getComments() {
		return comments;
	}
	
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
	
	@NotNull
	@OneToMany(mappedBy="user")
	public Collection<Thread> getThreads() {
		return threads;
	}
	
	public void setThreads(Collection<Hilo> threads) {
		this.threads = threads;
	}
}