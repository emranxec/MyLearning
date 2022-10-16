package com.xec.myProject.azure;

/**
 * Observer Design pattern
 */
public interface Obeserver {
    void update(String courseName, int price);

    void subscribeChannel(AzureCertificationCoursesInterface azureCertificationCourses);

    String getMembership();

    String getName();


}
