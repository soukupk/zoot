package cz.consumer.interview.board;

import java.util.Arrays;
import java.util.List;

public class BoardPosition {

	private final int x;
	private final int y;
	private final int boardSize;
	
	private BoardPosition(int x, int y, int boardSize) {
		this.x = x;
		this.y = y;
		this.boardSize = boardSize;
	}
	
	public static BoardPosition create(int x, int y, int boardSize) {
		return new BoardPosition(x, y, boardSize);
	}
 
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public List<BoardPosition> getNeighbours() {
		if(boardSize <= 1) {
			return Arrays.asList(); 
		} else if(isLeftTopCorner()) {
			return getLeftTopCornerPositions();
		} else if(isRightTopCorner()) {
			return getRightTopCornerPositions();
		} else if(isRightBottomCorner()) {
			return getRightBottomCornerPositions();
		} else if(isLeftBottomCorner()) {
			return getLeftBottomCornerPositions();
		} else if(isRightBorder()) {
			return getRightBorderPositions();
		} else if(isBottomBorder()) {
			return getBottomBorderPositions();
		} else if(isTopBorder()) {
			return getTopBorderPositions();
		} else if(isLeftBorder()) {
			return getLeftBorderPositions();
		}			
		return getNoBorderPositions(); 
	}

	private List<BoardPosition> getNoBorderPositions() {
		return Arrays.asList(				
				BoardPosition.create(x - 1, y - 1, boardSize),
				BoardPosition.create(x, y - 1, boardSize),
				BoardPosition.create(x + 1, y - 1, boardSize),
				BoardPosition.create(x + 1, y, boardSize),
				BoardPosition.create(x + 1, y + 1, boardSize),
				BoardPosition.create(x, y + 1, boardSize),
				BoardPosition.create(x - 1, y + 1, boardSize),
				BoardPosition.create(x - 1, y, boardSize)
		);
	}

	private List<BoardPosition> getLeftBorderPositions() {
		return Arrays.asList(
			BoardPosition.create(x, y - 1, boardSize),
			BoardPosition.create(x + 1, y - 1, boardSize),
			BoardPosition.create(x + 1, y, boardSize),
			BoardPosition.create(x + 1, y + 1, boardSize),
			BoardPosition.create(x, y + 1, boardSize)
			);
	}

	private List<BoardPosition> getTopBorderPositions() {
		return Arrays.asList(
			BoardPosition.create(x - 1, 0, boardSize),
			BoardPosition.create(x + 1, 0, boardSize),
			BoardPosition.create(x - 1, 1, boardSize),
			BoardPosition.create(x, 1, boardSize),
			BoardPosition.create(x + 1, 1, boardSize)
			);
	}

	private List<BoardPosition> getBottomBorderPositions() {
		return Arrays.asList(
				BoardPosition.create(x - 1, y, boardSize),
				BoardPosition.create(x + 1, y, boardSize),
				BoardPosition.create(x - 1, y - 1, boardSize),
				BoardPosition.create(x, y - 1, boardSize),
				BoardPosition.create(x + 1, y - 1, boardSize)
			);
	}

	private List<BoardPosition> getRightBorderPositions() {
		return Arrays.asList(
				BoardPosition.create(x, y - 1, boardSize),
				BoardPosition.create(x, y + 1, boardSize),
				BoardPosition.create(x - 1, y - 1, boardSize),
				BoardPosition.create(x - 1, y, boardSize),
				BoardPosition.create(x - 1, y + 1, boardSize)
			);
	}

	private List<BoardPosition> getLeftBottomCornerPositions() {
		return Arrays.asList(
				BoardPosition.create(x, y - 1, boardSize),
				BoardPosition.create(x + 1, y - 1, boardSize),
				BoardPosition.create(x + 1, y, boardSize)
			);
	}

	private List<BoardPosition> getRightBottomCornerPositions() {
		return Arrays.asList(
				BoardPosition.create(x, y - 1, boardSize),
				BoardPosition.create(x - 1, y, boardSize),
				BoardPosition.create(x - 1, y - 1, boardSize)
			);
	}

	private List<BoardPosition> getRightTopCornerPositions() {
		return Arrays.asList(
			BoardPosition.create(x - 1, 0, boardSize),
			BoardPosition.create(x - 1, 1, boardSize),
			BoardPosition.create(x, 1, boardSize)
			);
	}

	private List<BoardPosition> getLeftTopCornerPositions() {
		return Arrays.asList(
			BoardPosition.create(0, 1, boardSize),
			BoardPosition.create(1, 0, boardSize),
			BoardPosition.create(1, 1, boardSize)
			);
	}

	private boolean isLeftBottomCorner() {
		return isBottomBorder() && isLeftBorder();
	}

	private boolean isRightBottomCorner() {
		return isBottomBorder() && isRightBorder();
	}

	private boolean isRightTopCorner() {
		return isTopBorder() && isRightBorder();
	}

	private boolean isLeftTopCorner() {
		return isTopBorder() && isLeftBorder();
	}

	private boolean isLeftBorder() {
		return x == 0;
	}

	private boolean isTopBorder() {
		return y == 0;
	}

	private boolean isBottomBorder() {
		return y == boardSize - 1;
	}

	private boolean isRightBorder() {
		return x == boardSize - 1;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardSize;
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
		BoardPosition other = (BoardPosition) obj;
		if (boardSize != other.boardSize)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", boardSize=" + boardSize + "]";
	}
	
}
