package cz.consumer.interview.board;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import cz.consumer.interview.board.Board;
import cz.consumer.interview.board.Element;
import cz.consumer.interview.data.Organism;

public class BoardInitializationTest {

	@Test
	public void shouldInitalizeWithEmptyElements_WhenNoInputOrganisms() {
		int size = 2;
		int iterations = 1;
		
		Board board = new Board(Arrays.asList(), size, iterations);
		
		Element[][] expectedElements = new Element[size][size];
		
		expectedElements[0][0] = Element.createEmptyElement(0,0);
		expectedElements[1][0] = Element.createEmptyElement(1,0);
		expectedElements[0][1] = Element.createEmptyElement(0,1);
		expectedElements[1][1] = Element.createEmptyElement(1,1);

		Assert.assertArrayEquals(expectedElements, board.getElements());
	}
	
	@Test
	public void shouldInitalizeWithEmptyElementsAndOneOrganism_WhenOneInputOrganisms() {
		int size = 2;
		int iterations = 1;
		
		Board board = new Board(Arrays.asList(Organism.create(0, 1, 101)), size, iterations);
		
		Element[][] expectedElements = new Element[size][size];
		
		expectedElements[0][0] = Element.createEmptyElement(0,0);
		expectedElements[1][0] = Element.createEmptyElement(1,0);
		expectedElements[0][1] = Element.createOrganismElement(0,1,101);
		expectedElements[1][1] = Element.createEmptyElement(1,1);

		Assert.assertArrayEquals(expectedElements, board.getElements());
	}
	
}
