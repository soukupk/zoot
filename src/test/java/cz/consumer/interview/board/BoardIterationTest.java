package cz.consumer.interview.board;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import cz.consumer.interview.board.Board;
import cz.consumer.interview.board.Element;
import cz.consumer.interview.data.Organism;

public class BoardIterationTest {

	private int iterations = 1;
	
	@Test
	public void testIterate_shouldKillOrganismWithoutNeighbours() {
		int size = 2;
		int x = 1;
		int y = 1;
		int species = 1;
		Board board = new Board(Arrays.asList(Organism.create(x, y, species)), size, iterations);
		
		board.iterate();
		
		Assert.assertEquals(Element.createEmptyElement(1, 1), board.getElements()[x][y]);
	}
	
	@Test
	public void testIterate_shouldKillOrganismsWithOneNeighbourOfSameSpecies() {
		int size = 2;
		Board board = new Board(Arrays.asList(
			Organism.create(0, 0, 1),
			Organism.create(1, 1, 1)
		), size, iterations);
		
		board.iterate();
		
		Assert.assertEquals(Element.createEmptyElement(0, 0), board.getElements()[0][0]);
		Assert.assertEquals(Element.createEmptyElement(1, 1), board.getElements()[1][1]);
	}
	
	@Test
	public void testIterate_shouldLetAliveOrganismsWithTwoNeighboursOfSameSpecies() {
		int size = 2;
		Board board = new Board(Arrays.asList(
			Organism.create(0, 0, 1),
			Organism.create(0, 1, 1),
			Organism.create(1, 1, 1)
		), size, iterations);
		
		board.iterate();
		
		Assert.assertEquals(Element.createOrganismElement(0, 0, 1), board.getElements()[0][0]);
		Assert.assertEquals(Element.createOrganismElement(0, 1, 1), board.getElements()[0][1]);
		Assert.assertEquals(Element.createOrganismElement(1, 1, 1), board.getElements()[1][1]);
	}
	
	@Test
	public void testIterate_shouldLetAliveOrganismsWithThreeNeighboursOfSameSpecies() {
		int size = 2;
		Board board = new Board(Arrays.asList(
			Organism.create(0, 0, 1),
			Organism.create(0, 1, 1),
			Organism.create(1, 0, 1),
			Organism.create(1, 1, 1)
		), size, iterations);
		
		board.iterate();
		
		Assert.assertEquals(Element.createOrganismElement(0, 0, 1), board.getElements()[0][0]);
		Assert.assertEquals(Element.createOrganismElement(0, 1, 1), board.getElements()[0][1]);
		Assert.assertEquals(Element.createOrganismElement(1, 0, 1), board.getElements()[1][0]);
		Assert.assertEquals(Element.createOrganismElement(1, 1, 1), board.getElements()[1][1]);
	}
	
	@Test
	public void testIterate_shouldKillOrganismWithFourNeighboursOfSameSpecies() {
		int size = 4;
		Board board = new Board(Arrays.asList(
			Organism.create(2, 2, 1),
			Organism.create(1, 1, 1),
			Organism.create(3, 3, 1),
			Organism.create(1, 3, 1),
			Organism.create(3, 1, 1)
		), size, iterations);
		
		board.iterate();
		
		Assert.assertEquals(Element.createEmptyElement(2, 2), board.getElements()[2][2]);
	}
	
	@Test
	public void testIterate_shouldGiveBirthToEmptyElement_whenThreeNeighboursOfSameSpecies() {
		int size = 4;
		Board board = new Board(Arrays.asList(
			Organism.create(1, 1, 1),
			Organism.create(3, 3, 1),
			Organism.create(1, 3, 1)
		), size, iterations);
		
		board.iterate();
		
		Assert.assertEquals(Element.createOrganismElement(2, 2, 1), board.getElements()[2][2]);
	}
	
	@Test
	public void testIterate_shouldGiveBirthToEmptyElement_whenThreeNeighboursOfSpeciesOfTypeOneAndTwo() {
		int size = 4;
		int speciesOne = 1;
		int speciesTwo = 2;
		Board board = new Board(Arrays.asList(
			Organism.create(1, 1, speciesOne),
			Organism.create(3, 3, speciesOne),
			Organism.create(1, 3, speciesOne),
			Organism.create(1, 2, speciesTwo),
			Organism.create(2, 1, speciesTwo),
			Organism.create(3, 1, speciesTwo)
		), size, iterations);
		
		board.iterate();
		
		Assert.assertTrue(Arrays.asList(speciesOne,speciesTwo).contains(board.getElements()[2][2].getSpecies()));
	}
}
