package Task.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

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
	private static final int WEEK_1 = 7;
	private static final int WEEK_2 = 9;
	private static final int WEEK_3 = 11;
	private static final int WEEK_4 = 13;
	private static final int WEEK_5 = 15;
	private static final int WEEK_6 = 17;
	private static final int WEEK_7 = 19;
	private static final int WEEK_8 = 21;
	private static final int WEEK_9 = 23;
	private static final int WEEK_10 = 25;
	private static final String FINAL_ITEM = "yury_maroz@epam.com";
	private static final String FILE = "final.xlsx";
	private static TreeMap<String,String> modules= new TreeMap<String,String>();

	private static ScheduleItem scheduleItem;

	public static void main(String[] args) {
		Schedule schedule = new Schedule();
		String mentor = "";
		String mentee = "";
		String manager = "";
		String groupName = "";
		String city = "";
		String office = "";
		String week_1 = "";
		String week_2 = "";
		String week_3 = "";
		String week_4 = "";
		String week_5 = "";
		String week_6 = "";
		String week_7 = "";
		String week_8 = "";
		String week_9 = "";
		String week_10 = "";
		String nameWeek1 = "";
		String nameWeek2 = "";
		String nameWeek3 = "";
		String nameWeek4 = "";
		String nameWeek5 = "";
		String nameWeek6 = "";
		String nameWeek7 = "";
		String nameWeek8 = "";
		String nameWeek9 = "";
		String nameWeek10 = "";
		
		int count = 0;
		boolean finishRead = false;
		int d = 0;

		try {

			FileInputStream file = new FileInputStream(new File(FILE));

			// Get the workbook instance for XLS file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			
			
			int weekssssss = getWeekCount();
		
			 rowIterator = sheet.iterator();
			 
			 
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
							
						case WEEK_1:
							week_1 = cell.getStringCellValue();
							break;
						case WEEK_2:
							week_2 = cell.getStringCellValue();
							break;
						case WEEK_3:
							week_3 = cell.getStringCellValue();
							break;
						case WEEK_4:
							week_4 = cell.getStringCellValue();
							break;
						case WEEK_5:
							week_5 = cell.getStringCellValue();
							break;
						case WEEK_6:
							week_6 = cell.getStringCellValue();
							break;
						case WEEK_7:
							week_7 = cell.getStringCellValue();
							break;
						case WEEK_8:
							week_8 = cell.getStringCellValue();
							break;
						case WEEK_9:
							week_9 = cell.getStringCellValue();
							break;
						case WEEK_10:
							week_10 = cell.getStringCellValue();
							break;						
						}
					}
					if(count == 1){
						nameWeek1 = splitWeek(week_1);
						nameWeek2 = splitWeek(week_2);
						nameWeek3 = splitWeek(week_3);
						nameWeek4 = splitWeek(week_4);
						nameWeek5 = splitWeek(week_5);
						nameWeek6 = splitWeek(week_6);
						nameWeek7 = splitWeek(week_7);
						nameWeek8 = splitWeek(week_8);
						nameWeek9 = splitWeek(week_9);
						nameWeek10 = splitWeek(week_10);
					}
					if (count > 1) {
						modules.put(nameWeek1,week_1);
						modules.put(nameWeek2,week_2);
						modules.put(nameWeek3,week_3);
						modules.put(nameWeek4,week_4);
						modules.put(nameWeek5,week_5);
						modules.put(nameWeek6,week_6);
						modules.put(nameWeek7,week_7);
						modules.put(nameWeek8,week_8);
						modules.put(nameWeek9,week_9);
						modules.put(nameWeek10,week_10);
						scheduleItem = new ScheduleItem(mentor, mentee,
								groupName, manager, city, office,modules);
						schedule.addMentee(mentee);
						schedule.add(scheduleItem);
					}
				} else
					break;
			}
			schedule.printMentee();
			schedule.printSchedule(schedule.getSheduleList());
			System.out.println(d);	System.out.println("______________"+ weekssssss);

			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static int getWeekCount() throws IOException {

		int weekCount = 0;
		
		FileInputStream file = new FileInputStream(new File(FILE));

		// Get the workbook instance for XLS file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Iterate through each rows from first sheet
		Iterator<Row> rowIterator = sheet.iterator();
		
		Row rowf = rowIterator.next();
		Iterator<Cell> cellIterator = rowf.cellIterator();

		while(cellIterator.hasNext()){
			if(cellIterator.next().getStringCellValue().contains("week"))			
				weekCount++;
		}
		
		return weekCount;
	}
	
	public static String splitWeek(String week){
		String[] weekSplit = week.split("week");
		return weekSplit[1];
	}

}
