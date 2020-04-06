import java.util.Random;

public class RandomString {

    private String characters1="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String characters2="abcdefghijklmnopqrstuvwxyz";
    private String idcharacters="0123456789";
    private String randomstr="";
    private int length;
    private Random rand=new Random();
    private char[] text;

    public RandomString(){this.length=2; this.text=new char[length];}
    public RandomString(int length){this.length=length; this.text=new char[length];}

    public String generateName(int length){ this.length=length; this.text=new char[length]; randomstr="";
        text[0]=characters1.charAt(rand.nextInt(characters1.length()));
        for(int i=1; i<this.length; i++)
        {
            text[i]=characters2.charAt(rand.nextInt(characters2.length()));
        }
        for(int i=0; i<text.length; i++){
            randomstr+=text[i];
        }
        return randomstr;

    }

    public String generateId(){ this.text=new char[4]; randomstr="";
        text[0]=idcharacters.charAt(rand.nextInt(idcharacters.length()));

        while(text[0]=='0')
        {text[0]=idcharacters.charAt(rand.nextInt(idcharacters.length()));}

        for(int i=1; i<4; i++)
        {
            text[i]=idcharacters.charAt(rand.nextInt(idcharacters.length()));
        }

        for(int i=0; i<text.length; i++){
            randomstr+=text[i];
        }
        return randomstr;
    }

    public String generateDoctorsAge(){this.text=new char[2]; randomstr="";
        text[0]=idcharacters.charAt(rand.nextInt(idcharacters.length()));
        while(text[0]<'3' || text[0]>='7'){text[0]=idcharacters.charAt(rand.nextInt(idcharacters.length())); }
       // while(text[0]>='7'){text[0]=idcharacters.charAt(rand.nextInt(idcharacters.length())); System.out.println("2222");}
        text[1]=idcharacters.charAt(rand.nextInt(idcharacters.length()));
        if(text[0]=='6' && text[1]>5)
                {text[1]='4'; }
        for(int i=0; i<text.length; i++){
            randomstr+=text[i];
        }
        return randomstr;

    }

    public String generatePatientsAge(){this.text=new char[2]; randomstr="";
        text[0]=idcharacters.charAt(rand.nextInt(idcharacters.length()));
        while(text[0]=='9'){text[0]=idcharacters.charAt(rand.nextInt(idcharacters.length()));}


        text[1]=idcharacters.charAt(rand.nextInt(idcharacters.length()));
        if(text[0]=='8'&& text[1]>5){text[1]='4';}
        if(text[0]=='0') {randomstr+=text[1]; return randomstr;}
        for(int i=0; i<text.length; i++){
            randomstr+=text[i];

        }
        return randomstr;

    }


    @Override
    public String toString()
    {
        for(int i=0; i<text.length; i++){
            randomstr+=text[i];
        }

        return randomstr;
    }
}
