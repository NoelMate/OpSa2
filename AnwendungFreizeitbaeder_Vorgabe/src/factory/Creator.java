package factory;

import java.io.*;

public abstract class Creator {
	public abstract Product factoryMethod(String typ) throws IOException;
}
