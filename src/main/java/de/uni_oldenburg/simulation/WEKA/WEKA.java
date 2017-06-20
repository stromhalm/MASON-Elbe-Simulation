package de.uni_oldenburg.simulation.WEKA;

import de.uni_oldenburg.simulation.WEKA.Plot.Plot;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

import java.io.File;
import java.io.IOException;

/**
 * {@link weka.Run} wrapper.
 *
 * @see CollisionWEKA
 * @see WaterLevelWEKA
 */
public abstract class WEKA {

	Instances instances;

	String path;
	String wekaName;

	ArffSaver arffSaver;
	Plot plot;

	int fileNumberCounter;

	public WEKA(String path, String WEKAname) {
		arffSaver = new ArffSaver();
		prepareWEKAEntry();
		arffSaver.setInstances(instances);
		this.path = path;
		this.wekaName = WEKAname;
		fileNumberCounter = 0;
	}

	public void writeWEKAEntries() {
		File file;
		String pathCopy = path + wekaName + String.valueOf(fileNumberCounter) + ".arff";
		while ((file = new File(pathCopy)).isFile()) { // prevent overriding
			pathCopy = path + wekaName + String.valueOf(++fileNumberCounter) + ".arff";
		}

		try {
			arffSaver.setFile(file);
			arffSaver.writeBatch();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract boolean addWEKAEntry(Object[] wekaEntry);

	abstract void prepareWEKAEntry();

	public abstract void plotWEKAEntries();

}
