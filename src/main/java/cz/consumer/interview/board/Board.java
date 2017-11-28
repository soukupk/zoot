package cz.consumer.interview.board;

import java.util.List;
import java.util.stream.Collectors;

import cz.consumer.interview.data.Organism;

public class Board {
	
	private Element[][] elements;
	
	private int cells;
	
	private int iterations;
	
	public Board(List<Organism> organismList, int cells, int iterations) {
		this.cells = cells;
		this.iterations = iterations;
		initializeWithEmptyElements();				
		initializeOrganisms(organismList);		
	}
	
	public Element[][] getElements() {
		return elements;
	}
	
	public void iterate() {
		for(int i = 0; i < iterations; i++) {
			prepareNextGeneration();
			applyNextGeneration();
		}
	}

	private void prepareNextGeneration() {
		for(int x = 0; x < cells; x++) {
			for(int y = 0; y < cells; y++) {
				elements[x][y].prepareNextGeneration(getNeighbours(x,y));				
			}
		}
	}
	
	private List<Element> getNeighbours(int x, int y) {
		return BoardPosition.create(x, y, cells).getNeighbours()
			.stream().map(boardPosition -> {
				return elements[boardPosition.getX()][boardPosition.getY()];
			}).collect(Collectors.toList());
	}

	private void applyNextGeneration() {
		for(int x = 0; x < cells; x++) {
			for(int y = 0; y < cells; y++) {
				elements[x][y] = elements[x][y].getNextGeneration();		
			}
		}
	}

	private void initializeOrganisms(List<Organism> organismList) {
		organismList.stream().forEach(organism -> {
			int x = organism.getX();
			int y = organism.getY();
			elements[x][y] = Element.createOrganismElement(x,y,organism.getSpecies());
		});
	}

	private void initializeWithEmptyElements() {
		elements = new Element[cells][cells];
		
		for(int x = 0; x < cells; x++) {
			for(int y = 0; y < cells; y++) {
				elements[x][y] = Element.createEmptyElement(x,y);
			}
		}
	}
	
}
