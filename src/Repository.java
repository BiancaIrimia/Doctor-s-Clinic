import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Repository {
    private Vector<Doctor> doctors=new Vector<Doctor>(8);//vectorul in care vor fi stocati doctorii
    private Vector<Patient> patients=new Vector<Patient>(100);//vectorul in care vor fi stocati pacientii
    private Vector<Consultation> consultations=new Vector<Consultation>(3);//vectorul in care vor fi stocate tipurile de consultatii si detaliile acestora

    public Repository(){}

    //functie care creeaza vectorul de consultatii cu cele 3 tipuri
    public void createVofConsultations()
    {
        Consultation c=new Consultation("consultation", 30, 50);
        Consultation p=new Consultation("prescription", 20, 20);
        Consultation t=new Consultation("treatment", 40, 35);
        consultations.add(c);
        consultations.add(p);
        consultations.add(t);
    }
    //setteri si getteri
    public int getDoctorsize(){return doctors.size();}
    public int getPatientsize(){return patients.size();}
    public Doctor getDoctor(int i){return doctors.get(i);}
    public Patient getPatient(int i){return patients.get(i);}
    public int getNumberofPatients(int i){return doctors.get(i).getNumberofPatients();}
    public int getFee(int i, int j){return doctors.get(i).getPatient(j).getFee();}
    public int getTime(int i, int j){return doctors.get(i).getPatient(j).getTime();}
    public String getName(int i){return doctors.get(i).getName();}
    public String getLastName(int i){return doctors.get(i).getLastname();}
    public int getId(int i){return doctors.get(i).getId();}
    public String getPName(int i){return patients.get(i).getName();}
    public String getPLastName(int i){return patients.get(i).getLastname();}
    public int getPAge(int i){return patients.get(i).getAge();}
    public String getReason(int i){return patients.get(i).getReason();}

    //functie care verifica daca id-ul unui doctor este unic
    public boolean validateId(int id){
        for(int i=0; i<doctors.size(); i++)
            if(doctors.get(i).getId()==id)
            {  return false;
            }
        return true;
    }

    //functia care genereaza lista de doctori cu ajutorul clasei RandomString
    public void generateDoctors(int n)
    {
        for(int i=0; i<n; i++)
        { RandomString r=new RandomString();
          String name= r.generateName(3);
          String lastname=r.generateName(2);
          int age=Integer.parseInt(r.generateDoctorsAge());
          int id=Integer.parseInt(r.generateId());
          if(validateId(id)==false)
            id=Integer.parseInt(r.generateId());

          Doctor d=new Doctor(name, lastname, age, id, 0);
         doctors.add(d);
        }
    }

    //functia care genereaza lista de pacienti cu ajutorul clasei RandomString
    public void generatePatients()
    {
        createVofConsultations();
        for(int i=0; i<100; i++)
        {
            RandomString r=new RandomString();
        String name= r.generateName(5);
        String lastname=r.generateName(4);
        int age=Integer.parseInt(r.generatePatientsAge());
        String ageCat="";
        if(age>=0 && age<=1) ageCat="children";
        if(age>1 && age<=7) ageCat="pupil";
        if(age>7 && age<=18) ageCat="student";
        if(age>18) ageCat="adult";

        Random random=new Random();
        String options="123";
        int s=random.nextInt(options.length());
        Consultation con=consultations.get(s);

        Patient p=new Patient(name, lastname, age, ageCat, con, false);
        patients.add(p);
        }
    }

    //functie care scrie in fisier lista de doctori
    public void writeDoctorstoFile() {
        try{
            File file=new File("Doctors.txt");
            if(!file.exists())
                file.createNewFile();

            PrintWriter pw=new PrintWriter(file);
            for(int i=0; i<doctors.size(); i++)
                pw.print(doctors.get(i)+"\n");
            pw.println();
            pw.close();
            System.out.println("done printing the doctors");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //functie care scrie in fisier lista de pacienti
    public void writePatientstoFile() {
        try{
            File file=new File("Patients.txt");
            if(!file.exists())
                file.createNewFile();

            PrintWriter pw=new PrintWriter(file);
            for(int i=0; i<100; i++)
                 pw.print(patients.get(i)+"\n");
            pw.println();
            pw.close();
            System.out.println("done printing the patients");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //functie care citeste de la tastatura un numar intreg
    public int citireIntreg(String sir){
        try{
            System.out.print(sir);
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            return n;
        }
        catch(Exception exp){	//cautam erori si apelam recursiv
            System.out.print("This is not an integer... \n");
            return citireIntreg(sir);
        }
    }

    //functie care transforma lista de doctori intr-un string pentru afisare
    public String toStringDoctors()
    {   String s="";
        for(int i=0; i<doctors.size(); i++)
            s+=doctors.get(i)+"\n";

        return s;
    }

    //functie care transforma lista de pacienti intr-un string pentru afisare
    public String toStringPatients()
    {   String s="";
        for(int i=0; i<patients.size(); i++)
            s+=patients.get(i)+"\n";

        return s;
    }


}
