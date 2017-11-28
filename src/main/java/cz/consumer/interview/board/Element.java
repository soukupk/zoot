package cz.consumer.interview.board;

import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Element {

	private static final long NUMBER_OF_SPECIES_NEEDED_TO_FULFILL_GIVE_BIRTH_CONDITION = 3l;

	protected final int x;
	
	protected final int y;
	
	protected Integer species;
	
	protected Element nextGeneration;
	
	protected Random randomGenerator = new Random();

	private Element(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Element createEmptyElement(int x, int y) {
		return new Element(x, y);
	}
	
	public static Element createOrganismElement(int x, int y, int species) {
		Element element = new Element(x, y);
		element.setSpecies(species);
		return element;
	}
	
	public void prepareNextGeneration(List<Element> neighbours) {
		if(isEmptyElement()) {
			prepareNextGenerationForEmptyElement(neighbours);
		} else {
			prepareNextGenerationForOrganismElement(neighbours);
		}			
	}

	private void prepareNextGenerationForOrganismElement(List<Element> neighbours) {
		long numberOfNeighboursWithSameSpecies = getNumberOfNeighboursWithSameSpecies(neighbours);
		if(numberOfNeighboursWithSameSpecies == 2 || numberOfNeighboursWithSameSpecies == 3) {
			nextGeneration = this;
		} else {
			nextGeneration = Element.createEmptyElement(x, y);
		}
	}

	private void prepareNextGenerationForEmptyElement(List<Element> neighbours) {
		List<Integer> speciesFulfillingGiveBirthCondition = getSpeciesFulfillingGiveBirtCondition(neighbours);
		
		if(speciesFulfillingGiveBirthCondition.size() > 0) {
			int randomSpecies = randomGenerator.nextInt(speciesFulfillingGiveBirthCondition.size());
			
			int newSpecies = speciesFulfillingGiveBirthCondition.get(randomSpecies);
			
			nextGeneration = Element.createOrganismElement(x, y, newSpecies);
		} else {
			nextGeneration = Element.createEmptyElement(x, y);
		}
	}

	private List<Integer> getSpeciesFulfillingGiveBirtCondition(List<Element> neighbours) {
		Set<Entry<Integer,Long>> speciesWithCount = neighbours.stream()
				.filter(element -> ! isEmptyElement(element))
				.collect(Collectors.groupingBy(element -> element.getSpecies(),Collectors.counting()))
				.entrySet();
				
		List<Integer> speciesSatisfyGiveBirthCondition = speciesWithCount.stream()
				.filter(x -> x.getValue().equals(NUMBER_OF_SPECIES_NEEDED_TO_FULFILL_GIVE_BIRTH_CONDITION))
				.map(entry -> entry.getKey())
				.collect(Collectors.toList());
		return speciesSatisfyGiveBirthCondition;
	}

	private long getNumberOfNeighboursWithSameSpecies(List<Element> neighbours) {
		return neighbours.stream()
			.filter(element -> species.equals(element.getSpecies()))
			.count();
	}
	
	private boolean isEmptyElement(Element element) {
		return element.getSpecies() == null;
	}

	private boolean isEmptyElement() {
		return species == null;
	}
	
	public Element getNextGeneration() {
		return nextGeneration;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Integer getSpecies() {
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
		Element other = (Element) obj;
		if (species != other.species)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Element [x=" + x + ", y=" + y + ", species=" + species + "]";
	}	
	
}
