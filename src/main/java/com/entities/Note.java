package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "notetable")
public class Note {
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noteId;
	private String noteTitle;
	private String noteDescription;
	@Temporal(TemporalType.DATE)
	private Date writtenOn;
	
	//constructors
	public Note() {
		//zero-parameter constructors
	}
	
	//initialize all fields
	public Note(String noteTitle, String noteDescription, Date writtenOn) {
		super();
		this.noteId = new Random().nextInt(10000);
		this.noteTitle = noteTitle;
		this.noteDescription = noteDescription;
		this.writtenOn = writtenOn;
	}

	//getters and setters
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public void setNoteDescription(String noteDescription) {
		this.noteDescription = noteDescription;
	}

	public void setWrittenOn(Date writtenOn) {
		this.writtenOn = writtenOn;
	}
	
	public int getNoteId() {
		return noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public String getNoteDescription() {
		return noteDescription;
	}

	public Date getNoteWritten() {
		return writtenOn;
	}
	
	
	
}
