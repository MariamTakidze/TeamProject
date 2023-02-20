package models;

import java.util.Objects;

public class Station  {
	
	//---fields
	private int idStation;
	private String name;
	private int idCity;
	
	//---constructors
	public Station(int idStation, String name, int idCity) {
		this.idStation = idStation;
		this.name = name;
		this.idCity = idCity;
	}
	public Station() {}
	
	//---getters and setters
	public int getIdStation() {
		return idStation;
	}
	public void setIdStation(int idStation) {
		this.idStation = idStation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdCity() {
		return idCity;
	}
	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}
	
	
	
	//-- toString and hashCode
	@Override
	public String toString() {
		return "Station [idStation=" + idStation + ", name=" + name + ", idCity=" + idCity + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCity, idStation, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		return idCity == other.idCity && idStation == other.idStation && Objects.equals(name, other.name);
	}
	
}
