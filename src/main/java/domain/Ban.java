package domain;

import javax.persistence.Entity;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Ban extends DomainEntity{

	private boolean banned;

	
	@NotNull
	public boolean getBanned() {
		return banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}
	
	//RelationShips -----------------------------------------------
	
	
	
	
	
}
