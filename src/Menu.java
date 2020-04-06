public class Menu {
    private Controller c=new Controller();

    //functie care genereaza listele
    public void generate(int n)
    {
        c.generateDoctors(n);
        c.generatePatients();
    }

    //functie care scrie in fisier
    public void writetoFile()
    {
        c.writeDoctorstoFile();
        c.writePatientstoFile();
    }

    //meniul
    public void menu()
    {
        System.out.println("1. Generate a list of doctors and one of patients;\n"+"2. Print the list of doctors;\n"+"3. Print the list of patients; \n"+"4. Write the list to files; \n"+"5. Summary of patients by age;\n"+"6. Get patients consulted;"+"7. Summary of doctors, the number of patients consulted and the total bill;\n"+"8. List of Patients that were not consulted;\n"+"9. Clear screen\n"+"0. Exit \n");
    }

    public void run()
    {
        int option=-1;
        while(option!=0)
        {   menu();
            option=c.readNumber("Your option:");
            if(option==1)
            {   //verificam daca numarul introdus pentru generarea listei de doctori este mai mare sau egal cu 8
                int n=c.readNumber("Give a number higher than 7: ");
                if(n>=8)
                    generate(n);
                else {
                    System.out.println("The number has to be grater than 7!");
                    while(n<8)
                    {
                        n=c.readNumber("Give a number higher than 7: ");
                    }
                    generate(n);
                    }
            }
            if(option==2)
            {
             System.out.println(c.toStringDoctors());
            }
            if(option==3)
            {
                System.out.println(c.toStringPatients());
            }
            if(option==4)
            {
                writetoFile();
            }
            if(option==5)
            {
                System.out.println(c.summary());
            }
            if(option==6)
            {
                c.giveDoctorsProgram();
                c.giveDoctorsPatients();
                System.out.println("done! :)");
            }
            if(option==7)
            {
                System.out.println(c.summary2());
            }
            if(option==8)
            {
                System.out.println(c.summary3());
            }
            if(option<0 || option>9)
                System.out.println("This is not a valid option");
            if(option==0)
                System.out.println("Bye, bye");
        }
    }


    public static void main(String[] args)
    {
        Menu menu=new Menu();
        menu.run();

    }
}
