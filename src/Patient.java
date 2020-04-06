public class Patient {
    private String name;
    private String lastname;
    private int age;
    private String ageGroup;
    private Consultation consultation;
    private boolean cons;

    public Patient()
    {
        this.name="";
        this.lastname="";
        this.age=0;
        this.ageGroup="";
        this.consultation=new Consultation();
        this.cons=false;
    }

    public Patient(String name, String lastname, int age, String ageGroup, Consultation consultation, boolean c)
    {
        this.name=name;
        this.lastname=lastname;
        this.age=age;
        this.ageGroup=ageGroup;
        this.consultation=new Consultation();
        this.consultation=consultation;
        this.cons=c;
    }

    public void setName(String name) { this.name = name; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setAge(int age) { this.age = age; }
    public void setAgeGroup(String ageGroup) { this.ageGroup = ageGroup; }
    public void setConsultation(Consultation consultation){this.consultation=new Consultation(); this.consultation=consultation;}
    public void setIfConsulted(boolean c){this.cons=c;}


    public String getName() { return name; }
    public String getLastname() { return lastname; }
    public int getAge() { return age; }
    public String getAgeGroup() { return ageGroup; }
    public String getReason(){return consultation.getName();}
    public int getTime(){return consultation.getTime();}
    public int getFee(){return consultation.getFee();}
    public boolean getIfConsulted(){return cons;}

    @Override
    public String toString(){
        String s="";
        s+=name+" "+lastname+" "+age+" "+ageGroup+" "+ consultation.getName();
        return s;
    }
}
