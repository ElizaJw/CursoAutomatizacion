package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constantes.ConstantesPruebas;

public class DataPropertiesManagement {

	public Properties getProperties() throws IOException {
		FileReader file = new FileReader(ConstantesPruebas.RUTA_PROPERTIES);
		
		Properties properties = new Properties();
		properties.load(file);
		
		return properties;
		

		
	}
}
