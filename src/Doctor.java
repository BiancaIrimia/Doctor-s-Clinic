import java.util.Vector;

public class Doctor {
    private String name;
    private String lastname;
    private int age;
    private int id;
    private int time;
    Vector<Patient> p; //in acest vectori vor fi pacientii pe care ii va consulta doctorul respectiv

    public Doctor()
    {
        this.name="";
        this.lastname="";
        this.age=0;
        this.id=0;
        this.time=0;
        p=new Vector<Patient>();
    }

    public Doctor(String name, String lastname, int age, int id, int time)
    {
        this.name=name;
        this.lastname=lastname;
        this.age=age;
        this.id=id;
        this.time=time;
        this.p=new Vector<Patient>();
    }

    public void setName(String name) { this.name = name; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setAge(int age) { this.age = age; }
    public void setId(int id) { this.id = id; }
    public void setTime(int time){this.time=time;}
    public void addPatient(Patient pat){this.p.add(pat);}

    public String getName() { return name; }
    public String getLastname() { return lastname; }
    public int getAge() { return age; }
    public int getId() { return id; }
    public int getTime(){return time;}
    public Vector<Patient> getPatients(){return p;}
    public Patient getPatient(int i){return p.get(i);}
    public int getNumberofPatients(){return p.size();}


    @Override
    public String toString()
    {
        String s="";
        s+=id+" "+name+" "+lastname+" "+age;
        return s;
    }
}
