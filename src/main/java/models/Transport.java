package models;

import java.util.Objects;

public class Transport  {
	
	//---fields
	private int idTransport;
	private String type;
	private int speed;
	
	//---constructors
	public Transport(int idTransport, String type, int speed) {
		this.idTransport = idTransport;
		this.type = type;
		this.speed = speed;
	}
	public Transport() {}
	
	//---getters and setters
	public int getIdTransport() {
		return idTransport;
	}
	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	//---toString and hashCode
	@Override
	public String toString() {
		return "Transport [idTransport=" + idTransport + ", type=" + type + ", speed=" + speed + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idTransport, speed, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transport other = (Transport) obj;
		return idTransport == other.idTransport && speed == other.speed && Objects.equals(type, other.type);
	}
	
	
	
}
