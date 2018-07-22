package com.vivek.informationmodule.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table
@AllArgsConstructor
public class information implements Serializable {
	
	
	public information() {
		
	}
	
	@Id
	@Column
	private String id;

	@Column
	private String type;
	
	@Column
	private String source;
	
	
	public information(String id, String type, String source) {
		this.id = id;
		this.type = type;
		this.source = source;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id; 
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	/*public static class builder{
		public information build(){
			information i = new information();
			i.set
			return i;
			
		}
	}*/
	
	
}
