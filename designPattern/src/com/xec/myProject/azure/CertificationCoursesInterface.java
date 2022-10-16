package com.xec.myProject.azure;

import java.util.Map;

public interface CertificationCoursesInterface {
    Map<String, Certification> getMyCertifications();

    void subscribe(Obeserver obeserver);

    void unSubscribe(Obeserver obeserver);

    void notifySubscriber(String cloudName, int price);

    void setMyCertifications(Map<String, Certification> myCertifications);

    String getCloudName();

    void setCloudName(String cloudName);

    Course addNewCourse(String courseName, int price);

    Certification addNewCertifications(String certificationName);

    void buildCourses();

    void displayCourses(String certification);

    Certification createCertifications();

    void updateCertificationsCourses(Certification certification, String courseName);
}
