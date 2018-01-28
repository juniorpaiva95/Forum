package modelo;

import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
public class Model {
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at = new Date();
}
