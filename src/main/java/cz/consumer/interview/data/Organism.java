package cz.consumer.interview.data;

public class Organism {

	private int x;
	
	private int y;
	
	private int species;
	
	public static Organism create(int x, int y, int species) {
		Organism organism = new Organism();
		organism.setX(x);
		organism.setY(y);
		organism.setSpecies(species);
		return organism;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpecies() {
		return species;
	}

	public void setSpecies(int species) {
		this.species = species;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + species;
		result = prime * result + x;
		result = prime * result + y;
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
		Organism other = (Organism) obj;
		if (species != other.species)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
