package N_Queen_problem;

import java.awt.Color;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Sergio Oyaga
 */
public class N_Queen_problem {
     public int cicles, queens, popul;
     public double Pm1o, Pm2o,Pm1c,Pm2c,Pm1eo,Pm2eo,Pm1ec,Pm2ec;
     public static void main(String args[]) throws IOException {
         //try for the look and feel.
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               Setting seting= new Setting();
               seting.setVisible(true);
                
            }
        });

     }
     public static void runGenetic(int cicles,double P1o, double P2o, double P1c, double P2c,double P1eo, double P2eo,
             double P1ec, double P2ec) throws IOException{
         
        //Creating two files for Write a csv to be able to make fancy plots in R
        FileWriter fw = new FileWriter("./archivo.csv");
        fw.append("Type of crossover,Generation,Mean,Best \n");
        FileWriter fw2 = new FileWriter("./archivo1.csv");
        fw2.append("Type of crossover,name,fitness \n");
        
        //Initialising the objects
        Population p=new Population(); //first population
        p.initPopulation();
        System.out.println("Cicles until stop = "+ cicles);
        
        Population pant,pnew=p, pnew1=p,pnew2=p,pnew3=p; //two more populations without initialise
        
        String [] list=new String [cicles],//some strings to store the csv information
                 write=new String [cicles+1],
                 write2={"","","",""};
        for(int i=0;i<write.length;i++){
            write[i]="";
        }
        
        /*Central cycle where the evolution takes place. */
        for(int i=0;i<cicles;i++){
            //order method
            pnew.Pmut1=P1o;//mutation probabilities
            pnew.Pmut2=P2o;
            if(i==0){//write the type of cross, the generationn number, the mean and the best individual
              write[i]="Order Crossover,"+Integer.toString(i)+","+Double.toString(pnew.mean())+","+pnew.Population[0].fitness+"\n";  
            }
            pnew=pnew.nextGenerationTournament(true,false);//obtains the next generation (order,no elitism)
            write[i+1]="Order Crossover,"+Integer.toString(i+1)+","+Double.toString(pnew.mean())+","+pnew.Population[0].fitness+"\n";
            
            //cycle method
            pnew1.Pmut1=P1c;//mutation probabilities
            pnew1.Pmut2=P2c;
            if(i==0){//write the type of cross, the generationn number, the mean and the best individual
              write[i]+="Cycle Crossover,"+Integer.toString(i)+","+Double.toString(pnew1.mean())+","+pnew1.Population[0].fitness+"\n";  
            }
            pnew1=pnew1.nextGenerationTournament(false,false);//obtains the next generation (cycle,no elitism)
            write[i+1]+="Cycle Crossover,"+Integer.toString(i+1)+","+Double.toString(pnew1.mean())+","+pnew1.Population[0].fitness+"\n";
            
            //elitism order method
            pnew2.Pmut1=P1eo;//mutation probabilities
            pnew2.Pmut2=P2eo;
            if(i==0){//write the type of cross, the generationn number, the mean and the best individual
              write[i]+="Elitism Order Crossover,"+Integer.toString(i)+","+Double.toString(pnew2.mean())+","+pnew2.Population[0].fitness+"\n";  
            }
            pnew2=pnew2.nextGenerationTournament(true,true);//obtains the next generation (order,elitism)
            write[i+1]+="Elitism Order Crossover,"+Integer.toString(i+1)+","+Double.toString(pnew2.mean())+","+pnew2.Population[0].fitness+"\n";
        
            //elitism cycle method
            pnew3.Pmut1=P1ec;//mutation probabilities
            pnew3.Pmut2=P2ec;
            if(i==0){//write the type of cross, the generationn number, the mean and the best individual
              write[i]+="Elitism Cycle Crossover,"+Integer.toString(i)+","+Double.toString(pnew3.mean())+","+pnew3.Population[0].fitness+"\n";  
            }
            pnew3=pnew3.nextGenerationTournament(false,true);//obtains the next generation (cycle,elitism)
            write[i+1]+="Elitism Cycle Crossover,"+Integer.toString(i+1)+","+Double.toString(pnew3.mean())+","+pnew3.Population[0].fitness+"\n";
        
            
            /*This part stores all the diferent solutions obtained in one of the other methods and plot them.
            to select the method we have to  choose the pnew(*) number. nothing order ,1 cycle, 2 elit order, 3 elit cycle, 
            to enable this part, remove the commentaries marks -> /* code */
            
            /* remove this
            pant=pnew;
            //pant=pnew1;
            //pant=pnew2;
            //pant=pnew3;
            Arrays.sort(pant.Population);
            if(pant.Population[0].fitness==0 ){
                boolean esta=false;
                for(String sr:list){
                    if(sr == null ? pant.Population[0].name == null : sr.equals(pant.Population[0].name)){
                        esta=true;
                        break;
                    }
                }
                if(!esta){
                    list[i]=pant.Population[0].name;
                    tablero t= new tablero();
                    controlador con= new controlador(t,pant.Population[0].getGenome());
                }

            }
            */ //remove this
        }
        //write the last population calculated in each method.
        for(int i=0;i<Population.size;i++){
            write2[0]+="Order Crossover,"+pnew.Population[i].name+","+Integer.toString(pnew.Population[i].fitness)+"\n";
            write2[1]+="Cycle Crossover,"+pnew1.Population[i].name+","+Integer.toString(pnew1.Population[i].fitness)+"\n";
            write2[2]+="Elitism Order Crossover,"+pnew2.Population[i].name+","+Integer.toString(pnew2.Population[i].fitness)+"\n";
            write2[3]+="Elitism Cycle Crossover,"+pnew3.Population[i].name+","+Integer.toString(pnew3.Population[i].fitness)+"\n";
        }
        
        //These populations sorts are done only for interpreting the results.  
        Arrays.sort(pnew.Population);
        Arrays.sort(pnew1.Population);
        Arrays.sort(pnew2.Population);
        Arrays.sort(pnew3.Population);
        
        //Print the results order.
        System.out.println("Order Crossover");
        System.out.println("Mutation probabilities = ("+pnew.Pmut1+","+pnew.Pmut2+")");
        System.out.println("Population fitness"+pnew);
        tablero torder= new tablero();
        if (pnew.Population[0].fitness==0){torder.setTitle("Order");}
        else{torder.setTitle("Order didn't find an optimal solution.");}
        controlador conorder= new controlador(torder,pnew.Population[0].getGenome());
        for(Population.Candidate c:pnew.Population){
            if(c.fitness==0){
                System.out.print( c.name+ "->");
            }
        }
        System.out.println("\n &&&&&&&&&&&&&\n");
        
        //Print the results cycle.
        System.out.println("Cycle Crossover");
        System.out.println("Mutation probabilities = ("+pnew1.Pmut1+","+pnew1.Pmut2+")");
        System.out.println("Population fitness"+pnew1);
        tablero tcycle= new tablero();
        if (pnew.Population[0].fitness==0){tcycle.setTitle("Cycle");}
        else{tcycle.setTitle("Cycle didn't find an optimal solution.");}
        
        controlador concyce= new controlador(tcycle,pnew1.Population[0].getGenome());
        for(Population.Candidate c:pnew1.Population){
            if(c.fitness==0){
                System.out.print( c.name+ "->");
            }
        }
        System.out.println("\n &&&&&&&&&&&&&\n");
        
        //Print the results elite order.
        System.out.println("Elite order Crossover");
        System.out.println("Mutation probabilities = ("+pnew2.Pmut1+","+pnew2.Pmut2+")");
        System.out.println("Population fitness"+pnew2);
        tablero torderelit= new tablero();
        if (pnew.Population[0].fitness==0){torderelit.setTitle("Elite Order");}
        else{torderelit.setTitle("Elite order didn't find an optimal solution.");}
        
        controlador conorderelit= new controlador(torderelit,pnew2.Population[0].getGenome());
        for(Population.Candidate c:pnew2.Population){
            if(c.fitness==0){
                System.out.print( c.name+ "->");
            }
        }
        System.out.println("\n &&&&&&&&&&&&&\n");
        
        //Print the results elite cycle.
        System.out.println("Elite cycle Crossover");
        System.out.println("Mutation probabilities = ("+pnew3.Pmut1+","+pnew3.Pmut2+")");
        System.out.println("Population fitness"+pnew3);
        tablero tcycleelit= new tablero();
        if (pnew.Population[0].fitness==0){tcycleelit.setTitle("Elite Cycle");}
        else{tcycleelit.setTitle("Elite cycle didn't find an optimal solution.");}
        
        controlador concyceelit= new controlador(tcycleelit,pnew3.Population[0].getGenome());
        for(Population.Candidate c:pnew3.Population){
            if(c.fitness==0){
                System.out.print( c.name+ "->");
            }
        }
        System.out.println("\n &&&&&&&&&&&&&\n");
        
        //writing and closing the files
        for(String sr:write){
            fw.append(sr);
        }for(String sr:write2){
            fw2.append(sr);
        }
        fw.flush();fw.close();fw2.flush();fw2.close();
     };
}
