package cn.com.school.eat.code.entity;

import java.util.Set;

public class Resturant_Tag {

	private String tag_mark;
	private String tag_name;

	private Set<Tag_Owner> tag_Owners;

	public Resturant_Tag() {

	}

	public String getTag_mark() {
		return tag_mark;
	}

	public void setTag_mark(String tag_mark) {
		this.tag_mark = tag_mark;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

	public Set<Tag_Owner> getTag_Owners() {
		return tag_Owners;
	}

	public void setTag_Owners(Set<Tag_Owner> tag_Owners) {
		this.tag_Owners = tag_Owners;
	}

}
