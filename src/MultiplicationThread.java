public class MultiplicationThread  extends Thread implements Runnable {
    private Matrix A;
    private Matrix B;
    public Matrix Ans_M;
    MultiplicationThread(Matrix M1,Matrix M2) throws Matrix.MultiplicationException
    {
        this.A=M1;
        this.B=M2;
        Ans_M=new Matrix(A.n,B.m);
    }

    void Run()
    {
        Matrix Multi_Ans= new Matrix(A.n,B.m);

        if(Integer.parseInt(getName())==1)
        {
            for(int j=0;j<B.m;j++){
                for (int i=0;i<A.n/2;i++){
                    int x=0,temp=0;
                    while (x<A.m){
                        temp=temp+A.numbers[i][x]*B.numbers[x][j];
                        x++;
                    }
                    Multi_Ans.numbers[i][j]=temp;
                }
            }
        }

        if(Integer.parseInt(getName())==2)
        {
            for(int j=0;j<B.m;j++){
                for (int i=A.n/2;i<A.n;i++){
                    int x=0,temp=0;
                    while (x<A.m){
                        temp=temp+A.numbers[i][x]*B.numbers[x][j];
                        x++;
                    }
                    Multi_Ans.numbers[i][j]=temp;
                }
            }
        }
        Ans_M=Multi_Ans;
    }
}
