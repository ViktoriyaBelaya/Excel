package Task.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Entities.Schedule;
import Entities.ScheduleItem;

public class ExcelParser {
	//private static final String SHEET_NAME = "schedule";
	private static final int COLUMN_MENTOR = 0;
	private static final int COLUMN_MENTEE = 1;
	private static final int COLUMN_GROUP_NAME = 2;
	private static final int COLUMN_MANAGER = 3;
	private static final int COLUMN_CITY = 4;
	private static final int COLUMN_OFFICE = 5;
	private static final String FINAL_ITEM = "yury_maroz@epam.com";
	private static final String FILE = "final.xlsx";

	private static ScheduleItem scheduleItem;

	public static void main(String[] args) {
		Schedule schedule = new Schedule();
		String mentor = "";
		String mentee = "";
		String manager = "";
		String groupName = "";
		String city = "";
		String office = "";
		int count = 0;
		boolean finishRead = false;

		try {

			FileInputStream file = new FileInputStream(new File(FILE));

			// Get the workbook instance for XLS file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				if (finishRead == false) {

					Row row = rowIterator.next();

					// For each row, iterate through each columns
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {

						Cell cell = cellIterator.next();

						switch (cell.getColumnIndex()) {

						case COLUMN_MENTOR:
							mentor = cell.getStringCellValue();
							if (mentor.equals(FINAL_ITEM)) {
								finishRead = true;
							}
							count++;
							break;
						case COLUMN_MENTEE:
							mentee = cell.getStringCellValue();
							break;
						case COLUMN_GROUP_NAME:
							groupName = cell.getStringCellValue();
							break;
						case COLUMN_MANAGER:
							manager = cell.getStringCellValue();
							break;
						case COLUMN_CITY:
							city = cell.getStringCellValue();
							break;
						case COLUMN_OFFICE:
							office = cell.getStringCellValue();
							break;
						}

					}
					if (count > 1) {
						scheduleItem = new ScheduleItem(mentor, mentee,
								groupName, manager, city, office);
						schedule.addMentee(mentee);
						schedule.add(scheduleItem);
					}
				} else
					break;
			}
			schedule.printMentee();
			schedule.printSchedule(schedule.getSheduleList());

			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
