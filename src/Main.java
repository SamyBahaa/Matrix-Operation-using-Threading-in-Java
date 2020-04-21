import java.util.Random;

public class Main {
    public  static  void main(String[] args) throws Matrix.MultiplicationException {
        // Declaring all Matrices
        Matrix M1=new Matrix(3,4);
        Matrix M2=new Matrix(4,2);
        Matrix M4=new Matrix(500,500);
        Matrix M5=new Matrix(500,500);

        int[]arr=new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        M1.setnumbers(arr);
        M2.setnumbers(arr);

        MultiplicationThread Thread_1 = new MultiplicationThread(M1,M2);
        MultiplicationThread Thread_2 = new MultiplicationThread(M1,M2);

        Thread_1.setName("1");
        Thread_2.setName("2");

        //we will use nanoseconds and milliseconds to show the difference
        long Time_Before_MS=System.currentTimeMillis();
        long Time_Before_NS=System.nanoTime();

        Thread_1.Run();
        Thread_2.Run();

        long Time_After_MS=System.currentTimeMillis();
        long Time_After_NS=System.nanoTime();

        System.out.println("we will use nanoseconds and milliseconds to show the difference");
        System.out.println("The time needed is "+ (Time_After_MS-Time_Before_MS)+ " Milli seconds.");
        System.out.println("The time needed is "+ (Time_After_NS-Time_Before_NS)+ " Nano seconds.");

        System.out.println("-----------------The second 2 Matrix M4 and M5-----------------");

        Random rd = new Random();
        int[]arr2=new int[250000];
        for(int i=0;i<250000;i++)
        {
            arr2[i]=rd.nextInt();
        }

        M4.setnumbers(arr2);
        M5.setnumbers(arr2);

        Time_Before_MS=System.currentTimeMillis();
        Time_Before_NS=System.nanoTime();


        Thread_1.Run();
        Thread_2.Run();

        Time_After_MS=System.currentTimeMillis();
        Time_After_NS=System.nanoTime();

        System.out.println("The time needed is "+ (Time_After_MS-Time_Before_MS)+ " Milli seconds.");
        System.out.println("The time needed is "+ (Time_After_NS-Time_Before_NS)+ " Nano seconds.");



    }
}
