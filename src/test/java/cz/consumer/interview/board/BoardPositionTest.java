package cz.consumer.interview.board;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cz.consumer.interview.board.BoardPosition;

public class BoardPositionTest {

	@Test
	public void getNeighbours_shouldReturnNoNeighboursPositions_whenPositionIsLeftTopCornerAndBoardSizeIsOne() {
		int boardSize = 1;
		BoardPosition position = BoardPosition.create(0, 0, boardSize);
		
		List<BoardPosition> neighbours = position.getNeighbours();
		
		List<BoardPosition> expectedNeighbours = Arrays.asList();
		
		Assert.assertEquals(expectedNeighbours, neighbours);
	}
	
	@Test
	public void getNeighbours_shouldReturnNeighboursPositions_whenPositionIsLeftTopCorner() {
		int boardSize = 5;
		BoardPosition position = BoardPosition.create(0, 0, boardSize);
		
		List<BoardPosition> neighbours = position.getNeighbours();
		
		List<BoardPosition> expectedNeighbours = Arrays.asList(
				BoardPosition.create(0, 1, boardSize),
				BoardPosition.create(1, 0, boardSize),
				BoardPosition.create(1, 1, boardSize)
				);
		
		Assert.assertEquals(expectedNeighbours, neighbours);
	}
	
	@Test
	public void getNeighbours_shouldReturnNeighboursPositions_whenPositionIsTopBorder() {
		int boardSize = 5;
		BoardPosition position = BoardPosition.create(2, 0, boardSize);
		
		List<BoardPosition> neighbours = position.getNeighbours();
		
		List<BoardPosition> expectedNeighbours = Arrays.asList(
				BoardPosition.create(1, 0, boardSize),
				BoardPosition.create(3, 0, boardSize),
				BoardPosition.create(1, 1, boardSize),
				BoardPosition.create(2, 1, boardSize),
				BoardPosition.create(3, 1, boardSize)
				);
		
		Assert.assertEquals(expectedNeighbours, neighbours);
	}
	
	@Test
	public void getNeighbours_shouldReturnNeighboursPositions_whenPositionIsRightCorner() {
		int boardSize = 5;
		BoardPosition position = BoardPosition.create(4, 0, boardSize);
		
		List<BoardPosition> neighbours = position.getNeighbours();
		
		List<BoardPosition> expectedNeighbours = Arrays.asList(
				BoardPosition.create(3, 0, boardSize),
				BoardPosition.create(3, 1, boardSize),
				BoardPosition.create(4, 1, boardSize)
				);
		
		Assert.assertEquals(expectedNeighbours, neighbours);
	}
	
	@Test
	public void getNeighbours_shouldReturnNeighboursPositions_whenPositionIsRightBorder() {
		int boardSize = 5;
		BoardPosition position = BoardPosition.create(4, 2, boardSize);
		
		List<BoardPosition> neighbours = position.getNeighbours();
		
		List<BoardPosition> expectedNeighbours = Arrays.asList(
				BoardPosition.create(4, 1, boardSize),
				BoardPosition.create(4, 3, boardSize),
				BoardPosition.create(3, 1, boardSize),
				BoardPosition.create(3, 2, boardSize),
				BoardPosition.create(3, 3, boardSize)
				);
		
		Assert.assertEquals(expectedNeighbours, neighbours);
	}
	
	@Test
	public void getNeighbours_shouldReturnNeighboursPositions_whenPositionIsRightBottomCorner() {
		int boardSize = 5;
		BoardPosition position = BoardPosition.create(4, 4, boardSize);
		
		List<BoardPosition> neighbours = position.getNeighbours();
		
		List<BoardPosition> expectedNeighbours = Arrays.asList(
				BoardPosition.create(4, 3, boardSize),
				BoardPosition.create(3, 4, boardSize),
				BoardPosition.create(3, 3, boardSize)
				);
		
		Assert.assertEquals(expectedNeighbours, neighbours);
	}
	
	@Test
	public void getNeighbours_shouldReturnNeighboursPositions_whenPositionIsBottomBorder() {
		int boardSize = 5;
		BoardPosition position = BoardPosition.create(2, 4, boardSize);
		
		List<BoardPosition> neighbours = position.getNeighbours();
		
		List<BoardPosition> expectedNeighbours = Arrays.asList(
				BoardPosition.create(1, 4, boardSize),
				BoardPosition.create(3, 4, boardSize),
				BoardPosition.create(1, 3, boardSize),
				BoardPosition.create(2, 3, boardSize),
				BoardPosition.create(3, 3, boardSize)
				);
		
		Assert.assertEquals(expectedNeighbours, neighbours);
	}
	
	@Test
	public void getNeighbours_shouldReturnNeighboursPositions_whenPositionIsLeftBottomCorner() {
		int boardSize = 5;
		BoardPosition position = BoardPosition.create(0, 4, boardSize);
		
		List<BoardPosition> neighbours = position.getNeighbours();
		
		List<BoardPosition> expectedNeighbours = Arrays.asList(
				BoardPosition.create(0, 3, boardSize),
				BoardPosition.create(1, 3, boardSize),
				BoardPosition.create(1, 4, boardSize)
				);
		
		Assert.assertEquals(expectedNeighbours, neighbours);
	}
	
	@Test
	public void getNeighbours_shouldReturnNeighboursPositions_whenPositionIsLeftBorder() {
		int boardSize = 5;
		BoardPosition position = BoardPosition.create(0, 2, boardSize);
		
		List<BoardPosition> neighbours = position.getNeighbours();
		
		List<BoardPosition> expectedNeighbours = Arrays.asList(
				BoardPosition.create(0, 1, boardSize),
				BoardPosition.create(1, 1, boardSize),
				BoardPosition.create(1, 2, boardSize),
				BoardPosition.create(1, 3, boardSize),
				BoardPosition.create(0, 3, boardSize)
				);
		
		Assert.assertEquals(expectedNeighbours, neighbours);
	}
	
	@Test
	public void getNeighbours_shouldReturnNeighboursPositions_whenPositionIsNotInContactWithBorder() {
		int boardSize = 5;
		BoardPosition position = BoardPosition.create(2, 2, boardSize);
		
		List<BoardPosition> neighbours = position.getNeighbours();
		
		List<BoardPosition> expectedNeighbours = Arrays.asList(
				BoardPosition.create(1, 1, boardSize),
				BoardPosition.create(2, 1, boardSize),
				BoardPosition.create(3, 1, boardSize),
				BoardPosition.create(3, 2, boardSize),
				BoardPosition.create(3, 3, boardSize),
				BoardPosition.create(2, 3, boardSize),
				BoardPosition.create(1, 3, boardSize),
				BoardPosition.create(1, 2, boardSize)
				);
		
		Assert.assertEquals(expectedNeighbours, neighbours);
	}
	
}
