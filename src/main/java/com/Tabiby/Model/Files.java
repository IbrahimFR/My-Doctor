package com.Tabiby.Model;

import javax.persistence.*;

/**
 * Created by ibrahimfouad on 8/11/2016.
 */
@Entity
@Table(name = "Files")
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String fileName;
    
    @Column( name = "file" )
    private byte[] file;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userHistory")
//    private UserHistory userHistory;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

//    public UserHistory getUserHistory() {
//        return userHistory;
//    }
//
//    public void setUserHistory(UserHistory userHistory) {
//        this.userHistory = userHistory;
//    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    
}
