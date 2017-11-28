package cz.consumer.interview.data;

import java.io.File;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import cz.consumer.interview.data.InputData;
import cz.consumer.interview.data.InputDataReader;
import cz.consumer.interview.data.Organism;
import cz.consumer.interview.data.World;


public class InputDataReaderTest {

	@Test
	public void testLoadData() throws Exception {
		InputDataReader inputDataReader = new InputDataReader();
		InputData inputData = inputDataReader.read(new File("./src/test/resources/input.yml"));
        
        InputData expectedInputData = new InputData();
        expectedInputData.setWorld(createWorld(40, 3, 4000000));                
        expectedInputData.setOrganisms(new ArrayList<>());
        expectedInputData.getOrganisms().add(createOrganism(1, 10, 10));
        expectedInputData.getOrganisms().add(createOrganism(1, 10, 11));
        
        Assert.assertEquals(expectedInputData, inputData);
	}

	private World createWorld(int cells, int species, int iterations) {
		World world = new World();
		world.setCells(cells);
		world.setSpecies(species);
		world.setIterations(iterations);
		return world;
	}

	private Organism createOrganism(int species, int x, int y) {
		Organism organismTwo = new Organism();
        organismTwo.setSpecies(species);
        organismTwo.setX(x);
        organismTwo.setY(y);
		return organismTwo;
	}
	
}
