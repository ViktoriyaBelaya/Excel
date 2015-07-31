package Entities;

import java.util.ArrayList;
import java.util.List;

public class Schedule extends ScheduleItem{
	private List<ScheduleItem> sheduleList = new ArrayList<ScheduleItem>();
	
	public void add(ScheduleItem scheduleItem) {
		sheduleList.add(scheduleItem);
	}

	public List<ScheduleItem> getSheduleList() {
		return sheduleList;
	}

	public void setSheduleList(List<ScheduleItem> sheduleList) {
		this.sheduleList = sheduleList;
	}
	
	public void printSchedule(List<ScheduleItem> list){
		for(ScheduleItem item:list){
			System.out.println(item);
		}
	}
	

}
