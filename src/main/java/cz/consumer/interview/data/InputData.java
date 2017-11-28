package cz.consumer.interview.data;

import java.util.List;

public class InputData {

	private World world;
	
	private List<Organism> organisms;

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public List<Organism> getOrganisms() {
		return organisms;
	}

	public void setOrganisms(List<Organism> organisms) {
		this.organisms = organisms;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((organisms == null) ? 0 : organisms.hashCode());
		result = prime * result + ((world == null) ? 0 : world.hashCode());
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
		InputData other = (InputData) obj;
		if (organisms == null) {
			if (other.organisms != null)
				return false;
		} else if (!organisms.equals(other.organisms))
			return false;
		if (world == null) {
			if (other.world != null)
				return false;
		} else if (!world.equals(other.world))
			return false;
		return true;
	}
	
}