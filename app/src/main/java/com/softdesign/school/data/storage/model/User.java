package com.softdesign.school.data.storage.model;


import android.graphics.drawable.Drawable;

public class User {
    private String mFirstName;
    private String mLastName;
    private String mPhone;
    private String mEmail;
    private int mRate;
    private Drawable mImage;
    private String mVKLink;
    private String mGitLink;
    private int mHomeTask;


    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmEmail() {
        return mEmail;
    }

    public int getmRate() {
        return mRate;
    }

    public Drawable getmImage() {
        return mImage;
    }

    public String getmVKLink() {
        return mVKLink;
    }

    public String getmGitLink() {
        return mGitLink;
    }

    public int getmHomeTask() {
        return mHomeTask;
    }

    //    public User(Drawable mImage,String mFirstName,String mLastName,int mRate,String mVKLink,String mGitLink,int mHomeTask) {
    public User(Drawable mImage,String mFirstName,String mLastName) {
        this.mFirstName=mFirstName;
        this.mLastName=mLastName;
        this.mImage=mImage;
/*      this.mRate=mRate;
        this.mVKLink=mVKLink;
        this.mGitLink=mGitLink;
        this.mHomeTask=mHomeTask;*/

    }

}