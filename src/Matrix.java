public class Matrix  {
        public int n;  //# of rows
        public int m; //# of colums
        int[][] numbers;

        Matrix(int N,int M)
        {
            this.n=N;
            this.m=M;
            numbers=new int[n][m] ;

        }


        public void print()
        {
            for (int i=0;i<n;i++)
            {
                for (int k=0;k<m;k++)
                {
                    System.out.print(numbers[i][k]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }

        public boolean setnumbers(int []arr)
        {
            int j=0;
            if(arr.length==(m*n))
            {
                for (int i=0;i<n;i++)
                {
                    for (int k=0;k<m;k++)
                    {
                        numbers[i][k]= arr[j];
                        j++;
                    }
                }
                return true;
            }
            else
                return false;
        }


        public void transpose()
        {
            int[][] tnumbers=new int[m][n] ;
            for (int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    tnumbers[i][j]=numbers[j][i];
                }
            }
            numbers=tnumbers;
            Swap(n,m);
        }

        private void Swap(int n, int m) {
            this.n=m;
            this.m=n;
        }




        public Matrix multiply(Matrix B) throws MultiplicationException{
            if(m!=B.n)
            {
                throw new MultiplicationException("Error during Multiplication","the inner dimensions of the matrix must be equal");
            }
            Matrix Multi_Ans =new Matrix(n,B.m) ;
            for(int j=0;j<B.m;j++){
                for (int i=0;i<n;i++){
                    int x=0,temp=0;
                    while (x<m){
                        temp=temp+numbers[i][x]*B.numbers[x][j];
                        x++;
                    }
                    Multi_Ans.numbers[i][j]=temp;
                }

            }
            return Multi_Ans;
        }


        static final class MultiplicationException extends Exception  {
            public String errorMessage;

            public MultiplicationException(String message, String errorMessage) {
                super(message);
                this.errorMessage = errorMessage;
                message();
            }
            public void message(){
                System.out.println(errorMessage);
            }
        }

    }

