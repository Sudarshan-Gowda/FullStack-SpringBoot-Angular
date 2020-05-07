package com.star.sud.todo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TODO")
public class Todo implements Serializable {

	private static final long serialVersionUID = -3108409314112876903L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "TARGET_DATE")
	private Date targetDate;

	@Column(name = "IS_DONE")
	private Boolean isDone;

	/**
	 * Default Constructors
	 */
	public Todo() {
		super();
	}

	/**
	 * @param id
	 * @param username
	 * @param description
	 * @param targetDate
	 * @param isDone
	 */
	public Todo(Long id, String username, String description, Date targetDate, Boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", isDone=" + isDone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the targetDate
	 */
	public Date getTargetDate() {
		return targetDate;
	}

	/**
	 * @param targetDate the targetDate to set
	 */
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	/**
	 * @return the isDone
	 */
	public Boolean getIsDone() {
		return isDone;
	}

	/**
	 * @param isDone the isDone to set
	 */
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
