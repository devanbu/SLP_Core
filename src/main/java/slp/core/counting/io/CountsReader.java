package slp.core.counting.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import slp.core.counting.Counter;

public class CountsReader {

	public static Counter readCounter(File file) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			Counter counter = (Counter) ois.readObject();
			ois.close();
			return counter;
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Error while writing counter to file " + file);
			e.printStackTrace();
			return null;
		}
	}
	
}
