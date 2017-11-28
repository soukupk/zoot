package cz.consumer.interview;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cz.consumer.interview.board.Board;
import cz.consumer.interview.data.InputData;
import cz.consumer.interview.data.InputDataReader;

public class GameOfLife {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		if(args.length != 1) {
			System.out.println("No input file specified.");
		}
		
		InputDataReader inputDataReader = inputDataReader();
		
		InputData inputData = inputDataReader.read(new File(args[0]));
		
		Board board = board(inputData);
		board.iterate();
		
		// TODO save to yaml
	}
	
	public static InputDataReader inputDataReader() {
		return new InputDataReader();
	}
	
	public static Board board(InputData inputData) {
		return new Board(inputData.getOrganisms(), inputData.getWorld().getCells(), inputData.getWorld().getIterations());
	}
	
}
