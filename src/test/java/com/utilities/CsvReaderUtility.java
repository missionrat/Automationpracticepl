package com.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CsvReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
		File csvFile = new File(System.getProperty("user.dir") + "\\testData\\" + fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;

		List<User> userList = null;
		User userData;
		try {

			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();// reading the col names---Row 1 skip the col names

			userList = new ArrayList<User>();

			while ((line = csvReader.readNext()) != null) {
				userData = new User(line[0], line[1]);

				userList.add(userData);
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
