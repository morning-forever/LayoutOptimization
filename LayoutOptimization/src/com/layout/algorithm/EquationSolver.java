package com.layout.algorithm;



public class EquationSolver {  
  
    /** 
     * @����Ԫ��˹��ȥ�� 
     */  
    static double a[][];  
    static double b[];  
    static double x[];  
    static int n;  
    static int n2; //��¼���еĴ���  
    public static void Elimination(){  //��Ԫ  
        PrintA();  
        for(int k=0;k<n;k++)  
        {  
            Wrap(k);  
            for(int i=k+1;i<n;i++)  
            {  
                double l=a[i][k]/a[k][k];  
                a[i][k]=0.0;  
                for(int j=k+1;j<n;j++)  
                    a[i][j]=a[i][j]-l*a[k][j];  
                b[i]=b[i]-l*b[k];  
            }  
            System.out.println("��"+k+"����Ԫ��");  
            PrintA();  
        }  
                  
    }  
    public static void Back()//�ش�  
    {  
        x[n-1]=b[n-1]/a[n-1][n-1];  
        for(int i=n-2;i>=0;i--)  
            x[i]=(b[i]-jisuan(i))/a[i][i];  
    }  
    public static double jisuan(int i){  
        double he=0.0;  
        for(int j=i;j<=n-1;j++)  
            he=he+x[j]*a[i][j];  
        return he;  
    }  
    public static void Wrap(int k){//����  
        double max=Math.abs(a[k][k]);  
        int n1=k;                   //��סҪ��������  
        for(int i=k+1;i<n;i++)     //�ҵ�Ҫ��������  
        {  
            if(Math.abs(a[i][k])>max){  
                n1=i;  
                max=Math.abs(a[i][k]);  
            }  
        }  
        if(n1!=k)  
        {  
            n2++;  
        System.out.println("��k="+k+"ʱ,Ҫ���������ǣ�"+k+"��"+n1);  
        for(int j=k;j<n;j++)  //����a����  
        {  
            double x1;  
            x1=a[k][j];  
            a[k][j]=a[n1][j];  
            a[n1][j]=x1;  
        }  
        double b1;   //����b����  
        b1=b[k];  
        b[k]=b[n1];  
        b[n1]=b1;  
        System.out.println("������");  
        PrintA();  
        }  
    }  
    public static void Determinant(){//������ʽ  
        double DM=1.0;  
        for(int i=0;i<n;i++)  
        {  
            double a2=a[i][i];  
            DM=DM*a2;  
        }  
        double n3=(double)n2;  
        DM=DM*Math.pow(-1.0, n3);  
        System.out.println("�÷������ϵ������ʽ��det A = "+DM);  
    }  
    public static void PrintA(){//����������  
        System.out.println("�������Ϊ��");  
        for(int i=0;i<n;i++)  
        {  
            for(int j=0;j<n;j++)  
                System.out.print(a[i][j]+"    ");  
            System.out.print(b[i]+"    ");  
            System.out.print("\n");  
        }  
    }  
    public static void Print(){//������̵ĸ�  
        System.out.println("������ĸ�Ϊ��");  
        for(int i=0;i<n;i++)  
            System.out.println("x"+i+" = "+x[i]);  
    }  
    public static void main(String[] args) {  
        //Scanner as=new Scanner(System.in);  
        System.out.println("���뷽�����Ԫ����");  
        //n=as.nextInt();  
        n=2;  
        a=new double[n][n];  
        b=new double[n];  
        x=new double[n];  
          
        double inputA[][] = {{1,1},{1,-1}};  
        a = inputA;  
          
        double inputB[] = {2,0};  
        b = inputB;  
          
          
        System.out.println("���뷽�����ϵ������a��");  
//        for(int i=1;i<=n;i++)  
//          for(int j=1;j<=n;j++)  
//              a[i][j]=as.nextDouble();  
        System.out.println("���뷽�������b��");  
//        for(int i=1;i<=n;i++)  
//          b[i]=as.nextDouble();  
        Elimination();  
        Back();  
        Print();  
        Determinant();  
    }  
}  

