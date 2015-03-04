package org.lztvn.elearning.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name ="question")
public class Question implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long qestId;
	private String questContent;
 	private String collect1;
	private String collect2;
	private String collect3;
	private String collect4;
	private int answer;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Test1 test;
	
	
	public Test1 getTest() {
		return test;
	}
	public void setTest(Test1 test) {
		this.test = test;
	}
	public Question(String questContent, String collect1, String collect2,
			String collect3, String collect4, int answer) {
		super();
		this.questContent = questContent;
		this.collect1 = collect1;
		this.collect2 = collect2;
		this.collect3 = collect3;
		this.collect4 = collect4;
		this.answer = answer;
		
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getQestId() {
		return qestId;
	}
	public void setQestId(long qestId) {
		this.qestId = qestId;
	}
	public String getQuestContent() {
		return questContent;
	}
	public void setQuestContent(String questContent) {
		this.questContent = questContent;
	}
	public String getCollect1() {
		return collect1;
	}
	public void setCollect1(String collect1) {
		this.collect1 = collect1;
	}
	public String getCollect2() {
		return collect2;
	}
	public void setCollect2(String collect2) {
		this.collect2 = collect2;
	}
	public String getCollect3() {
		return collect3;
	}
	public void setCollect3(String collect3) {
		this.collect3 = collect3;
	}
	public String getCollect4() {
		return collect4;
	}
	public void setCollect4(String collect4) {
		this.collect4 = collect4;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
}
