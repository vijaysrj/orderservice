package com.example.orders;

import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Outbox {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String event;

	@Column(name = "event_id")
	private int eventId;

	
	@Convert(converter = JsonToMapConverter.class)
	private Map<String, Object> payload;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Map<String, Object> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Outbox [id=" + id + ", event=" + event + ", eventId=" + eventId + ", payload=" + payload
				+ ", createdAt=" + createdAt + "]";
	}
	
	

}
