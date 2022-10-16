package com.xec.myProject.azure;


import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

/**
 * composite design pattern
 * Observer design pattern
 */

public class azure {
    public static void main(String[] args) throws CloneNotSupportedException {

        //AzureCertificationCourses
        //learnign (interface) certifications(many courses)
        //learnings (interface) courses

        AzureCertificationCoursesInterface azureCertificationCourses=new AzureCertificationCoursesInterface();
        azureCertificationCourses.setCloudName("Azure");

        //todo building new object
        azureCertificationCourses.createCertifications();

        //todo creating observers
        courseObersevers(azureCertificationCourses);

        System.out.println("----------adding new course ---------------------");
        azureCertificationCourses.addNewCourse("DBA",455);

        System.out.println("----------adding new course ---------------------");
        azureCertificationCourses.addNewCourse("DesignPatternCourse",555);
        System.out.println();
        System.out.println();




        //todo cloning to get object copy
        // Prototype design pattern
        CertificationCoursesInterface clonedCertification=  azureCertificationCourses.clone();
        clonedCertification.setCloudName("AWS");

        //todo updating the original object

        Course course=azureCertificationCourses.myLearnings.get("Fundamental 101");
        course.setPrice(0);
        azureCertificationCourses.myLearnings.put("Fundamental 101",course);

        //todo printing original copy
       // azureCertificationCourses.displayCourses("MS Azure");

        //todo printing cloned
        System.out.println("----------second started---------------------");
        //clonedCertification.displayCourses("MS Azure");


    }

    private static void courseObersevers(AzureCertificationCoursesInterface azureCertificationCourses) {
        Obeserver imran= new Student("Imran", "gold");
        Obeserver Kopal= new Student("Kopal","gold" );
        Obeserver Rahul= new Student("Rahul", "gold");
        Obeserver sridharan= new Student("sridharan", "silver");
        Obeserver aneesh= new Student("aneesh","silver" );
        Obeserver rintu= new Student("rintu","browns" );
        Obeserver basu= new Student("basu","default" );

        azureCertificationCourses.subscribe(imran);
        azureCertificationCourses.subscribe(Kopal);
        azureCertificationCourses.subscribe(Rahul);
        azureCertificationCourses.subscribe(sridharan);
        azureCertificationCourses.subscribe(aneesh);
        azureCertificationCourses.subscribe(rintu);
        azureCertificationCourses.subscribe(basu);

        aneesh.subscribeChannel(azureCertificationCourses);
        sridharan.subscribeChannel(azureCertificationCourses);
        Rahul.subscribeChannel(azureCertificationCourses);
        Kopal.subscribeChannel(azureCertificationCourses);
        imran.subscribeChannel(azureCertificationCourses);

        azureCertificationCourses.unSubscribe(aneesh);
    }
}
class AzureCertificationCoursesInterface implements Cloneable, CertificationCoursesInterface {

    String cloudName;
    Map<String,Course> myLearnings=new HashMap<>();
    Map<String,Certification> myCertifications=new HashMap<>();
    private List<Obeserver> obeservers =new ArrayList();

    @Override
    public Map<String, Certification> getMyCertifications() {
        return myCertifications;
    }

    @Override
    public void subscribe(Obeserver obeserver){
            obeservers.add(obeserver);
    }

    @Override
    public void unSubscribe(Obeserver obeserver){
        obeservers.remove(obeserver);
    }

    @Override
    public void notifySubscriber(String courseName, int price){

       // List<Obeserver> obeserverList=obeservers.stream().collect(filtering((Obeserver obeserver)->obeserver.getMembership().equals("gold"),toList()));
        //List<Obeserver> obeserverList=obeservers.stream().filter(obeserver -> obeserver.getMembership().equals("gold")).collect(toList());
        List<Obeserver> obeserverList=obeservers.stream().filter(obeserver -> obeserver.getMembership().equals("gold")).collect(Collectors.toUnmodifiableList());
        List<String> obeserverMembership=obeservers.stream().map(Obeserver::getMembership).collect(toList());
        Map<String,String> obeserverMap=obeservers.stream().filter(obeserver -> obeserver.getMembership().equals("gold")).collect(toMap(Obeserver::getName,Obeserver::getMembership));

        System.out.println(obeservers.stream().collect(partitioningBy(obeserver -> obeserver.getMembership().equals("gold"))));
        System.out.println(obeservers.stream().collect(groupingBy(obeserver -> obeserver.getMembership())));
        Map<String, List<Obeserver>> obeserverMap1=obeservers.stream().collect(groupingBy(obeserver -> obeserver.getMembership()));

        //gold,name
        System.out.println(obeservers.stream().collect(groupingBy(Obeserver::getMembership,mapping(Obeserver::getName,toList()))));
        System.out.println(obeservers.stream().collect(groupingBy(Obeserver::getName,mapping(Obeserver::getMembership,toSet()))));
        System.out.println(obeservers.stream().collect(groupingBy(Obeserver::getMembership,counting())));//long
        System.out.println(obeservers.stream().collect(groupingBy(Obeserver::getMembership,collectingAndThen(counting(),Long::intValue))));//int
        System.out.println(obeservers.stream().collect(maxBy(Comparator.comparing(Obeserver::getMembership))));//int
        System.out.println(obeservers.stream().collect(minBy(Comparator.comparing(Obeserver::getMembership))));//int
        String result = obeservers.stream().collect(collectingAndThen(minBy(Comparator.comparing(Obeserver::getMembership)), ob->ob.map(Obeserver::getName).orElse("")));//int
        System.out.println(result);



    /*    System.out.println(obeservers.stream().filter(obeserver -> obeserver.getMembership().equals("gold"))
                .map(obeserver -> obeserver.getName().toUpperCase())
                .collect(joining(",")));*/

      /*  System.out.println(obeservers.stream().filter(obeserver -> obeserver.getMembership().equals("gold"))
                .map(Obeserver::getName)
                .map(String::toUpperCase)
                .collect(joining(",")));*/




        /*for (Obeserver obeserver : obeserverList){
            obeserver.update(courseName, 100);
        }*/
       // obeservers.stream().filter(obeserver -> obeserverList.contains(obeserver)).forEach(obeserver -> obeserver.update(courseName,price));
        /*for (Obeserver obeserver : obeservers.stream().filter(obeserver -> !obeserverList.contains(obeserver)).collect(toList())){
            obeserver.update(courseName, price);
        }*/

    }

    @Override
    public void setMyCertifications(Map<String, Certification> myCertifications) {
        this.myCertifications = myCertifications;
    }

    @Override
    public String getCloudName() {
        return cloudName;
    }

    @Override
    public void setCloudName(String cloudName) {
        this.cloudName = cloudName;
    }

    @Override
    protected CertificationCoursesInterface clone() throws CloneNotSupportedException {
        CertificationCoursesInterface certificationCoursesInterface =new AzureCertificationCoursesInterface();
        for(Map.Entry<String,Certification> certificationEntry: this.myCertifications.entrySet()){
            Certification certification=certificationEntry.getValue();
            certificationCoursesInterface.getMyCertifications().put(certificationEntry.getKey(),(Certification) certification.clone());
        }
        return certificationCoursesInterface;
    }

    @Override
    public Course addNewCourse(String courseName, int price){
        System.out.println("new course added with name: " + courseName + " & price  :" + price);
        if(!obeservers.isEmpty()) {
            notifySubscriber(courseName, price);
        }
        return new Course(courseName,price);
    }

    @Override
    public Certification addNewCertifications(String certificationName){
        return new Certification(certificationName);
    }

    @Override
    public void buildCourses(){
        //DB,external
        Course fun101 = addNewCourse("Fundamental 101",399);
        Course dev101 = addNewCourse("Dev 101",499);
        Course dev103 = addNewCourse("Dev 103",599);
        Course devOp109 = addNewCourse("DevOps 109",699);
        Course devPlus = addNewCourse("Dev Advance",799);
        Course arc101 = addNewCourse("Architect 101",899);
        Course arcPlus = addNewCourse("Architect Advance",999);
        myLearnings.put(fun101.getName(),fun101);
        myLearnings.put(dev101.getName(),dev101);
        myLearnings.put(dev103.getName(),dev103);
        myLearnings.put(devOp109.getName(),devOp109);
        myLearnings.put(devPlus.getName(),devPlus);
        myLearnings.put(arc101.getName(),arc101);
        myLearnings.put(arcPlus.getName(),arcPlus);
    }


    @Override
    public void displayCourses(String certification) {
        System.out.println("cloud is :" + cloudName);
        Learnings learnings = myCertifications.get(certification);
        if (learnings == null) {
            learnings = myLearnings.get(certification);
            if (learnings == null) {
                System.out.println("Learning not found");
            } else {
                learnings.showPrice();
            }
        } else {
            learnings.showPrice();
        }
    }

    @Override
    public Certification createCertifications(){
        buildCourses();
        Certification fundamental= addNewCertifications("MS fundamental");
        Certification developer= addNewCertifications("MS Developer");
        Certification devOps= addNewCertifications("MS DevOps");
        Certification arc= addNewCertifications("MS Arc");
        Certification beginer= addNewCertifications("Beginer");
        Certification advance= addNewCertifications("Advance");
        Certification azure= addNewCertifications("MS Azure");

        updateCertificationsCourses(fundamental,"Fundamental 101");
        updateCertificationsCourses(developer,"Dev 101");
        updateCertificationsCourses(developer,"Dev 103");
        updateCertificationsCourses(devOps,"DevOps 109");
        updateCertificationsCourses(devOps,"Dev Advance");
        updateCertificationsCourses(arc,"Architect 101");
        updateCertificationsCourses(arc,"Architect Advance");

        updateCertificationsCourses(beginer,fundamental.getName());
        updateCertificationsCourses(beginer,developer.getName());
        updateCertificationsCourses(advance,devOps.getName());
        updateCertificationsCourses(advance,arc.getName());

        updateCertificationsCourses(azure,beginer.getName());
        updateCertificationsCourses(azure,advance.getName());

        return azure;

    }

    @Override
    public void updateCertificationsCourses(Certification certification, String courseName) {
        if (courseName != null) {
            if (myLearnings.get(courseName) != null) {
                certification.addCourses(myLearnings.get(courseName));
            } else {
                certification.addCourses(myCertifications.get(courseName));
            }
            myCertifications.put(certification.getName(), certification);
        }
    }
}

interface Learnings extends Cloneable {
    void showPrice();
    Object clone() throws CloneNotSupportedException;
}

class Course implements Learnings{

    private String name;
    private int price;

    public Course(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    @Override
    public void showPrice() {
        System.out.println("course Name : " + name + " & the price is :" + price);
    }
}

class Certification implements Learnings {
    String name;
    List<Learnings> courseList=new ArrayList<Learnings>();

    public Certification(String name) {
        this.name = name;
    }

    public List<Learnings> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Learnings> courseList) {
        this.courseList = courseList;
    }

    public String getName() {
        return name;
    }

    void addCourses(Learnings course){
        courseList.add(course);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
         Certification certification= (Certification) super.clone();
         List<Learnings> courses=new ArrayList<>();
         for(Learnings course:certification.getCourseList()){
             courses.add((Learnings) course.clone());
            // (Learnings) ((Course)course).clone()
         }
        certification.setCourseList(courses);
        return certification;
    }

    @Override
    public void showPrice() {
        System.out.println(name);
        for(Learnings learnings :courseList){
            learnings.showPrice();
        }
    }
}
