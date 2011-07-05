package sample.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

	@Id
	int id;

	String name;

	Date joined;
	
	String name1;
	String name2;
	String name3;
	String name4;
	String name5;
	String name6;
	String name7;
	String name8;
	String name9;
	  
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the joined
	 */
	public Date getJoined() {
		return joined;
	}

	/**
	 * @param joined the joined to set
	 */
	public void setJoined(Date joined) {
		this.joined = joined;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public String getName5() {
		return name5;
	}

	public void setName5(String name5) {
		this.name5 = name5;
	}

	public String getName6() {
		return name6;
	}

	public void setName6(String name6) {
		this.name6 = name6;
	}

	public String getName7() {
		return name7;
	}

	public void setName7(String name7) {
		this.name7 = name7;
	}

	public String getName8() {
		return name8;
	}

	public void setName8(String name8) {
		this.name8 = name8;
	}

	public String getName9() {
		return name9;
	}

	public void setName9(String name9) {
		this.name9 = name9;
	}
	
}
