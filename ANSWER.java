
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

/**
 *
 * @author kushagra
 */
public class ANSWER {

    public static class student implements Comparable
    {
        String name;
        float cgpa;
        int tok;
        public student(String n1,int a,float mk)
        {
            this.name=new String(n1);
            this.tok=a;
            this.cgpa=mk;
            
        }
        public int compareTo(Object obj)
        {
            if (obj instanceof student) 
            {
                student st = (student) obj;
                if(this.cgpa>st.cgpa)
                {
                    return -1;
                }
                else if(this.cgpa<st.cgpa)
                {
                    return +1;
                }
                else
                {
                    if(this.name.compareTo(st.name)!=0)
                        return this.name.compareTo(st.name);
                    else
                    {
                        if(this.tok>st.tok)
                            return -1;
                        else if(this.tok>st.tok)
                            return 1;
                        else
                            return 0;
                    }
                }
            } 
            return 0;
        }
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String[] in=br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        PriorityQueue<student> map=new PriorityQueue<student>();
        for(int i=0;i<n;i++)
        {
            in=br.readLine().split(" ");
            if(in[0].compareToIgnoreCase("ENTER")==0)
            {
                String nm=in[1];
                float y=Float.parseFloat(in[2]);
                int d=Integer.parseInt(in[3]);
                map.add(new student(nm,d,y));
            }
            else if(in[0].compareToIgnoreCase("SERVED")==0)
            {
                map.poll();
            }
            else
                i--;
        }
        if(map.peek()==null)
            System.out.println("EMPTY");
        else
        {
            while(map.peek()!=null)
            {
                student st=map.poll();
                System.out.println(st.name);
            }
        }
        wr.close();
        br.close();
    }

}
