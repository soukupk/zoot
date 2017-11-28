package cz.consumer.interview.data;

public class World {

	private Integer cells;
	
	private Integer species;
	
	private Integer iterations;

	public Integer getCells() {
		return cells;
	}

	public void setCells(Integer cells) {
		this.cells = cells;
	}

	public Integer getSpecies() {
		return species;
	}

	public void setSpecies(Integer species) {
		this.species = species;
	}

	public Integer getIterations() {
		return iterations;
	}

	public void setIterations(Integer iterations) {
		this.iterations = iterations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cells == null) ? 0 : cells.hashCode());
		result = prime * result + ((iterations == null) ? 0 : iterations.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
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
		World other = (World) obj;
		if (cells == null) {
			if (other.cells != null)
				return false;
		} else if (!cells.equals(other.cells))
			return false;
		if (iterations == null) {
			if (other.iterations != null)
				return false;
		} else if (!iterations.equals(other.iterations))
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		return true;
	}
	
}
