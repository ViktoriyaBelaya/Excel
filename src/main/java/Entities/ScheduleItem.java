package Entities;

import java.util.ArrayList;
import java.util.List;

public class ScheduleItem {
	private String mentor;
	private String mentee;
	private String manager;
	private String groupName;
	private String city;
	private String office;
	
	private List<String> menteeList = new ArrayList<String>();
	

	public ScheduleItem() {

	}

	public ScheduleItem(String mentor, String mentee, String groupName,
			String manager, String city, String office) {
		this.mentor = mentor;
		this.mentee = mentee;
		this.manager = manager;
		this.groupName = groupName;
		this.city = city;
		this.office = office;
	}

	public void addMentee(String mentee1) {
		mentee = mentee1.replace("@epam.com","");
		menteeList.add(mentee.replace('_', ' '));
	}

	public List<String> getMenteeList() {
		return menteeList;
	}

	public void printMentee(){
		for(String er: menteeList)
			System.out.println(er);
	}
	public void setMenteeList(List<String> menteeList) {
		this.menteeList = menteeList;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public String getMentee() {
		return mentee;
	}

	public void setMentee(String mentee) {
		this.mentee = mentee;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "[mentor=" + mentor + ", mentee=" + mentee + ", manager="
				+ manager + ", groupName=" + groupName + ", city=" + city
				+ ", office=" + office + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((mentee == null) ? 0 : mentee.hashCode());
		result = prime * result + ((mentor == null) ? 0 : mentor.hashCode());
		result = prime * result + ((office == null) ? 0 : office.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduleItem other = (ScheduleItem) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (mentee == null) {
			if (other.mentee != null)
				return false;
		} else if (!mentee.equals(other.mentee))
			return false;
		if (mentor == null) {
			if (other.mentor != null)
				return false;
		} else if (!mentor.equals(other.mentor))
			return false;
		if (office == null) {
			if (other.office != null)
				return false;
		} else if (!office.equals(other.office))
			return false;
		return true;
	}

}
