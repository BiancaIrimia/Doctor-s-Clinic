import java.util.Random;
public class Controller {
    private Repository repo=new Repository();

    public Controller(){}

    public void generateDoctors(int n){repo.generateDoctors(n);}
    public void generatePatients(){repo.generatePatients();}
    public void writeDoctorstoFile(){repo.writeDoctorstoFile();}
    public void writePatientstoFile(){repo.writePatientstoFile();}
    public int  readNumber(String s){return repo.citireIntreg(s);}
    public String toStringDoctors(){return repo.toStringDoctors();}
    public String toStringPatients(){return repo.toStringPatients();}

    //functie care face sumarul pacientilor in fucntie de varsta
   public String summary()
   {
       String st=""; int c=0, s=0, a=0, p=0;
       for(int i=0; i<repo.getPatientsize(); i++)
       {   String ag=repo.getPatient(i).getAgeGroup();
           if(ag=="children") c++;
           if(ag=="pupil") p++;
           if(ag=="student") s++;
           if(ag=="adult") a++;
       }
       st+="Children (0-1): "+c+" patients\n"+"Pupils (1-7): "+p+" patients\n"+"Students (7-18): "+s+" patients\n"+"Adults (>18): "+a+" patients\n";
       return st;
   }

   //functie care atribuie fiecarui doctor un numar random de minute care vor fi lucrate, avand in vedere numarul maxim de minute care pot fi lucrate intr-o zi
   public void giveDoctorsProgram()
   {   int timeperday=(12*4)*60; //4 cabinete ori 12 ore de lucru ori 60=total minute pe zi=2880 min

       for(int i=0; i<repo.getDoctorsize(); i++)
       {
           if(timeperday!=0)
             {
                    Random random=new Random();
                    String options="1234567"; //un doctor poate lucra maxim 7 ore pe zi
                    int s=random.nextInt(options.length()+1);
                    if(s==0)
                        s=random.nextInt(options.length()+1);
                    if(s!=0)
                        repo.getDoctor(i).setTime(s*60);
                    timeperday-=s*60;
             }

       }
   }

   //functie care calculeaza si atribuie fiecarui doctor un numar de pacienti; timpul petrecut consultandu-i nu
   // depaseste numarul de minute pe care il are doctorul atribuit din functia de mai sus
   public void giveDoctorsPatients()
   {
       int j=0;
       for(int i=0; i<repo.getDoctorsize(); i++)
       {
           int time=repo.getDoctor(i).getTime();
           int time2=0;

              while ((time2 < time) && (j<repo.getPatientsize()))
              {
                  Patient pa = repo.getPatient(j);
                  if (pa.getIfConsulted() == false)
                  {
                      time2 += pa.getTime();
                      repo.getDoctor(i).addPatient(new Patient(pa.getName(), pa.getLastname(), pa.getAge(), pa.getAgeGroup(), new Consultation(pa.getReason(),pa.getTime(), pa.getFee()), true));
                  }
                  j++;
              }
       }
   }

   //functie care face sumarul doctorilor care au consultat pacienti: cati pacienti si suma totala castigata
   public String summary2()
   {
       String st="";
       for(int i=0; i<repo.getDoctorsize(); i++)
       {
           int sum=0, time=0;
           for(int j=0; j<repo.getNumberofPatients(i); j++)
           {
               sum+=repo.getFee(i, j);
               time+=repo.getTime(i, j);
           }
           st+=repo.getName(i)+", "+repo.getLastName(i)+" - "+repo.getId(i)+": "+repo.getNumberofPatients(i)+" patients,"+time+" minutes, "+sum+" RON\n";
       }
       return st;
   }

   //functie care face sumarul pacientilor care nu au fost consultati
   public String summary3()
   {
       String st="";
       for(int i=0; i<repo.getPatientsize(); i++)
       {
           if(repo.getPatient(i).getIfConsulted()==false)
           {
               st+=repo.getPName(i)+", "+repo.getPLastName(i)+", "+repo.getPAge(i)+", "+repo.getReason(i)+"\n";
           }
       }
       return st;
   }

}
