package models;

import java.util.Objects;

public class Distance {
	
	//---fields
	private int idStation1;
	private int idStation2;
	private int distance;
	
	//---constructors
	public Distance(int idStation1, int idStation2, int distance) {
		this.idStation1 = idStation1;
		this.idStation2 = idStation2;
		this.distance = distance;
	}
	public Distance() {}
	
	//---getters and setters
	public int getIdStation1() {
		return idStation1;
	}
	public void setIdStation1(int idStation1) {
		this.idStation1 = idStation1;
	}
	public int getIdStation2() {
		return idStation2;
	}
	public void setIdStation2(int idStation2) {
		this.idStation2 = idStation2;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	//---toString and hashCode
	@Override
	public String toString() {
		return "Distance [idStation1=" + idStation1 + ", idStation2=" + idStation2 + ", distance=" + distance + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(distance, idStation1, idStation2);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distance other = (Distance) obj;
		return distance == other.distance && idStation1 == other.idStation1 && idStation2 == other.idStation2;
	}
	
	
}
