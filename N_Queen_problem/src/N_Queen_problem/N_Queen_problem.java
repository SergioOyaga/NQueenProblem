package N_Queen_problem;

import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Sergio Oyaga
 */
public class N_Queen_problem {

     public static void main(String args[]) {
        //try for the look and feel.
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               Setting setting= new Setting();
               setting.setVisible(true);
                
            }
        });

     }
     public static void runGenetic(int cycles,double P1o, double P2o, double P1c, double P2c,double P1eo, double P2eo,
             double P1ec, double P2ec) throws IOException{
         
        //Creating two files for Write a csv to be able to make fancy plots in R
        FileWriter fw = new FileWriter("./file.csv");
        fw.append("Type of crossover,Generation,Mean,Best \n");
        FileWriter fw2 = new FileWriter("./file1.csv");
        fw2.append("Type of crossover,name,fitness \n");
        
        //Initialising the objects
        Population population=new Population(); //first population
        population.initPopulation();
        System.out.println("Cycles until stop = "+ cycles + "\n");
        
        Population previousPopulation = population, populationOrder=population, populationCycle=population,populationOrderElitism=population,
                populationCycleElitism=population; //Initialize new populations for each optimization type
        
        String [] listPreviousSolutions=new String [cycles],    // array of previous solutions.
                write=new String [cycles+1],                    // Array of string to store the output
                 write2={"","","",""};
        for(int i=0;i<write.length;i++){                        //Fill with ""
            write[i]="";
        }
        
        /*Principal cycle where the evolution takes place. */
        for(int i=0;i<cycles;i++){
            //order method
            populationOrder.Pmut1=P1o;//mutation probabilities
            populationOrder.Pmut2=P2o;
            if(i==0){//write the type of cross, the generation number, the mean and the best individual
              write[i]="Order Crossover,"+Integer.toString(i)+","+Double.toString(populationOrder.mean())+","+populationOrder.Population[0].fitness+"\n";
            }
            populationOrder=populationOrder.nextGenerationTournament(true,false);//obtains the next generation (order,no elitism)
            write[i+1]="Order Crossover,"+Integer.toString(i+1)+","+Double.toString(populationOrder.mean())+","+populationOrder.Population[0].fitness+"\n";
            
            //cycle method
            populationCycle.Pmut1=P1c;//mutation probabilities
            populationCycle.Pmut2=P2c;
            if(i==0){//write the type of cross, the generation number, the mean and the best individual
              write[i]+="Cycle Crossover,"+Integer.toString(i)+","+Double.toString(populationCycle.mean())+","+populationCycle.Population[0].fitness+"\n";
            }
            populationCycle=populationCycle.nextGenerationTournament(false,false);//obtains the next generation (cycle,no elitism)
            write[i+1]+="Cycle Crossover,"+Integer.toString(i+1)+","+Double.toString(populationCycle.mean())+","+populationCycle.Population[0].fitness+"\n";
            
            //elitism order method
            populationOrderElitism.Pmut1=P1eo;//mutation probabilities
            populationOrderElitism.Pmut2=P2eo;
            if(i==0){//write the type of cross, the generation number, the mean and the best individual
              write[i]+="Elitism Order Crossover,"+Integer.toString(i)+","+Double.toString(populationOrderElitism.mean())+","+populationOrderElitism.Population[0].fitness+"\n";
            }
            populationOrderElitism=populationOrderElitism.nextGenerationTournament(true,true);//obtains the next generation (order,elitism)
            write[i+1]+="Elitism Order Crossover,"+Integer.toString(i+1)+","+Double.toString(populationOrderElitism.mean())+","+populationOrderElitism.Population[0].fitness+"\n";
        
            //elitism cycle method
            populationCycleElitism.Pmut1=P1ec;//mutation probabilities
            populationCycleElitism.Pmut2=P2ec;
            if(i==0){//write the type of cross, the generation number, the mean and the best individual
              write[i]+="Elitism Cycle Crossover,"+Integer.toString(i)+","+Double.toString(populationCycleElitism.mean())+","+populationCycleElitism.Population[0].fitness+"\n";
            }
            populationCycleElitism=populationCycleElitism.nextGenerationTournament(false,true);//obtains the next generation (cycle,elitism)
            write[i+1]+="Elitism Cycle Crossover,"+Integer.toString(i+1)+","+Double.toString(populationCycleElitism.mean())+","+populationCycleElitism.Population[0].fitness+"\n";
        
            
            /*This part stores all the different solutions obtained in one of the other methods and plot them.
            to select the method we have to  choose the populationOrder(*) number. nothing order ,1 cycle, 2 elit order, 3 elit cycle,
            to enable this part, remove the commentaries marks -> /* code */
            
            /* //remove this
            previousPopulation=populationOrder;
            //previousPopulation=populationCycle;
            //previousPopulation=populationOrderElitism;
            //previousPopulation=populationCycleElitism;
            Arrays.sort(previousPopulation.Population);
            if(previousPopulation.Population[0].fitness==0 ){
                boolean isInPrevious=false;
                for(String sr:listPreviousSolutions){
                    if(sr == null ? previousPopulation.Population[0].name == null : sr.equals(previousPopulation.Population[0].name)){
                        isInPrevious=true;
                        break;
                    }
                }
                if(!isInPrevious){
                    listPreviousSolutions[i]=previousPopulation.Population[0].name;
                    new Controller(new Board(),previousPopulation.Population[0].getGenome());
                }
            }
            */ //remove this
        }

        //write the last population calculated in each method.
        for(int i=0;i<Population.size;i++){
            write2[0]+="Order Crossover,"+populationOrder.Population[i].name+","+Integer.toString(populationOrder.Population[i].fitness)+"\n";
            write2[1]+="Cycle Crossover,"+populationCycle.Population[i].name+","+Integer.toString(populationCycle.Population[i].fitness)+"\n";
            write2[2]+="Elitism Order Crossover,"+populationOrderElitism.Population[i].name+","+Integer.toString(populationOrderElitism.Population[i].fitness)+"\n";
            write2[3]+="Elitism Cycle Crossover,"+populationCycleElitism.Population[i].name+","+Integer.toString(populationCycleElitism.Population[i].fitness)+"\n";
        }
        
        //These populations sorts are done only for interpreting the results.  
        Arrays.sort(populationOrder.Population);
        Arrays.sort(populationCycle.Population);
        Arrays.sort(populationOrderElitism.Population);
        Arrays.sort(populationCycleElitism.Population);
        
        //Print the results order.
        System.out.println("Order Crossover");
        System.out.println("Mutation probabilities = ("+populationOrder.Pmut1+","+populationOrder.Pmut2+")");
        System.out.println("Population fitness:  "+populationOrder);
        Board torder= new Board();
        if (populationOrder.Population[0].fitness==0){torder.setTitle("Order");}
        else{torder.setTitle("Order didn't find an optimal solution.");}
        new Controller(torder,populationOrder.Population[0].getGenome());
        for(Population.Candidate c:populationOrder.Population){
            if(c.fitness==0){
                System.out.print( c.name+ "->");
            }
        }
        System.out.println("\n &&&&&&&&&&&&&\n");
        
        //Print the results cycle.
        System.out.println("Cycle Crossover");
        System.out.println("Mutation probabilities = ("+populationCycle.Pmut1+","+populationCycle.Pmut2+")");
        System.out.println("Population fitness:  "+populationCycle);
        Board tcycle= new Board();
        if (populationCycle.Population[0].fitness==0){tcycle.setTitle("Cycle");}
        else{tcycle.setTitle("Cycle didn't find an optimal solution.");}
        
        new Controller(tcycle,populationCycle.Population[0].getGenome());
        for(Population.Candidate c:populationCycle.Population){
            if(c.fitness==0){
                System.out.print( c.name+ "->");
            }
        }
        System.out.println("\n &&&&&&&&&&&&&\n");
        
        //Print the results elite order.
        System.out.println("Elite order Crossover");
        System.out.println("Mutation probabilities = ("+populationOrderElitism.Pmut1+","+populationOrderElitism.Pmut2+")");
        System.out.println("Population fitness:  "+populationOrderElitism);
        Board torderelit= new Board();
        if (populationOrderElitism.Population[0].fitness==0){torderelit.setTitle("Elite Order");}
        else{torderelit.setTitle("Elite order didn't find an optimal solution.");}
        
        new Controller(torderelit,populationOrderElitism.Population[0].getGenome());
        for(Population.Candidate c:populationOrderElitism.Population){
            if(c.fitness==0){
                System.out.print( c.name+ "->");
            }
        }
        System.out.println("\n &&&&&&&&&&&&&\n");
        
        //Print the results elite cycle.
        System.out.println("Elite cycle Crossover");
        System.out.println("Mutation probabilities = ("+populationCycleElitism.Pmut1+","+populationCycleElitism.Pmut2+")");
        System.out.println("Population fitness: "+populationCycleElitism);
        Board tcycleelit= new Board();
        if (populationCycleElitism.Population[0].fitness==0){tcycleelit.setTitle("Elite Cycle");}
        else{tcycleelit.setTitle("Elite cycle didn't find an optimal solution.");}
        
        new Controller(tcycleelit,populationCycleElitism.Population[0].getGenome());
        for(Population.Candidate c:populationCycleElitism.Population){
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
