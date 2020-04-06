public class Consultation {
    private String name;
    private int time;
    private int fee;

    public Consultation(){
        this.name="";
        this.time=0;
        this.fee=0;
    }

    public Consultation(String name, int time, int fee)
    {
        this.name=name;
        this.time=time;
        this.fee=fee;
    }

    public void setName(String name){this.name=name;}
    public void setTime(int time){this.time=time;}
    public void setFee(int fee){this.fee=fee;}

    public String getName(){return name;}
    public int getTime(){return time;}
    public int getFee(){return fee;}

    @Override
    public String toString()
    {
        String st="";
        st+=name+" "+time+" "+fee;
        return st;
    }
}
