package N_Queen_problem;
import java.util.*;
import java.util.Random;
import java.util.HashMap;
import java.util.stream.IntStream;


/*Class containing the population and the methods intrinsic to it, such as Next Generation*/
public class Population {
    public  static int size;            //Population's size.
    public static  int numberOfQueens;
    public double Pmut1,Pmut2;          //probabilities of mutation.
    public  Candidate [] Population=new Candidate [size];//An array containing the 
                                                        //individuals of the population.
    
    /*The following methods create the individuals in the population and allow 
    the evolution of the population. These methods use a subclass called Candidates,
    which is the individual itself.*/
    
    // Set the global class variables.
    public static void setVars(int siz, int queens){
        size=siz;
        numberOfQueens =queens;
        System.out.println("Queen Number = "+ Integer.toString(queens));
        System.out.println("Population Size = "+ Integer.toString(siz));
    };
    // Initialize the population by calling the subclass Candidate.
    public void initPopulation(){
        for(int i=0;i<size;i++){
            Population[i]=Population.this.new Candidate();//call to the subclass
        }
    }

    // Returns a new population corresponding to a next generation using the Tournament
    // selection strategy and a more exploitatory option, the elitism.
    public Population nextGenerationTournament(boolean Order,boolean Elitism){
        Population NewPop=new Population(); //next Population
        Random ran=new Random();//instance of new random variable.
        NewPop.Pmut1=this.Pmut1;
        NewPop.Pmut2=this.Pmut2;
        for(int j=0;j<size-1;j+=2){//generates 2 random integers to select a subset of the population.
            int rand1=ran.nextInt(size),rand2=ran.nextInt(size), start, end;
            Candidate [] figth;
            if(rand1<=rand2){
                start=rand1;end=rand2;
                figth=new Candidate[1+end-start];//stores the subset for tournament.
                for(int i=start;i<=end;i++){
                    figth[i-start]=this.Population[i];
                }
            }else{
                start=rand2;end=rand1;
                figth=new Candidate[size-(end-start)];//stores the subset for tournament.
                for(int i=0;i<start;i++){
                    figth[i]=this.Population[i];
                }
                for(int i=end;i<size;i++){
                    figth[start-end+i]=this.Population[i];
                }
            }
            
            Arrays.sort(figth);//the tournament.
            Candidate Parent1=figth[0];//the winner is the 1st parent.
            rand1=ran.nextInt(size);rand2=ran.nextInt(size);//repeating the process for the second parent.
            if(rand1<=rand2){
                start=rand1;end=rand2;
                figth=new Candidate[1+end-start];//stores the subset for tournament.
                for(int i=start;i<=end;i++){
                    figth[i-start]=this.Population[i];
                }
            }else{
                start=rand2;end=rand1;
                figth=new Candidate[size-(end-start)];//stores the subset for tournament.
                for(int i=0;i<start;i++){
                    figth[i]=this.Population[i];
                }
                for(int i=end;i<size;i++){
                    figth[start-end+i]=this.Population[i];
                }
            }
            Arrays.sort(figth);//the tournament.
            Candidate Parent2=figth[0];//the second parent
            Candidate [] children;
            if(Order){
                children=this.orderCrossOver(Parent1, Parent2);//cycleCrossOver to have 2 children.
            }else{
                children=this.cycleCrossOver(Parent1, Parent2);//cycleCrossOver to have 2 children.
            }
            NewPop.Population[j]=children[0];NewPop.Population[j+1]=children[1];
        }
        if(Elitism){
            Population temp=this;
            Arrays.sort(temp.Population);//sort for the elitism if needed.
            NewPop.Population[size-2]=temp.Population[0];NewPop.Population[size-1]=temp.Population[1];
        }
        return NewPop;
    }

    //Order crossOver between 2 individuals.
    public Candidate[] orderCrossOver(Candidate C1,Candidate C2){
        Candidate child1= new Candidate(),child2=new Candidate();//generating two children Candidates
        final int [] genomeP1=C1.getGenome(),genomeP2=C2.getGenome(),//generating some arrays 
                genomeC1=new int [numberOfQueens],  //with the genomes(parents and children)
                genomeC2=new int [numberOfQueens];
        
         Random ran=new Random();//new random variable to select the sizes of the genomes cuts.
         int rand1=ran.nextInt(numberOfQueens),rand2=ran.nextInt(numberOfQueens);
         if(rand1<=rand2){      //divides the problem depending on the randoms, but each part does the same.
             for(int i=rand1;i<=rand2;i++){//copies the selected block to the child in the correct position.
                 genomeC1[i]=genomeP1[i];
                 genomeC2[i]=genomeP2[i];
             }
            for(int i = 0; i< numberOfQueens; i++){//copies the rest of the genome from the other parent following his order.
                if(i<rand1||i>rand2){ //we only need to fill in the gaps in the genome.
                    for(int j = 0; j< numberOfQueens; j++){ //go through all the 2º parent's genome.
                        final int l=genomeP2[j];//needed for the lambda expression.
                        if(!IntStream.of(genomeC1).anyMatch(x -> x==l)){//check if it is in the child's genome
                            genomeC1[i]=genomeP2[j];            //if not, it is added in the corresponding position.
                        }else{
                            continue;
                        } break;
                    }
                    for(int j = 0; j< numberOfQueens; j++){//the same for the second child changing the parent's role.
                        final int l=genomeP1[j];
                        if(!IntStream.of(genomeC2).anyMatch(x -> x==l)){
                            genomeC2[i]=genomeP1[j];
                        }else{
                            continue;
                        }break;
                    }
                    
                }
            }
            
         }else{//the same for the other random situation.
             for(int i = rand1; i< numberOfQueens; i++){
                 genomeC1[i]=genomeP1[i];
                 genomeC2[i]=genomeP2[i];
             }
             for(int i=0;i<=rand2;i++){
                 genomeC1[i]=genomeP1[i];
                 genomeC2[i]=genomeP2[i];
             }
             for(int i = 0; i< numberOfQueens; i++){
                if(i>rand2 && i<rand1){
                    for(int j = 0; j< numberOfQueens; j++){
                        final int l=genomeP2[j];
                        if(!IntStream.of(genomeC1).anyMatch(x -> x==l)){
                            genomeC1[i]=genomeP2[j];
                        }else{
                            continue;
                        }break;
                    }
                    for(int j = 0; j< numberOfQueens; j++){
                        final int l=genomeP1[j];
                        if(!IntStream.of(genomeC2).anyMatch(x -> x==l)){
                            genomeC2[i]=genomeP1[j];
                        }else{
                            continue;
                        }break;
                    }
                }
            }
         }
        
        child1.setGenome(genomeC1);//sets the child's genome
        child2.setGenome(genomeC2);
        child1.Pmut1=this.Pmut1;child2.Pmut1=this.Pmut1;
        child1.Pmut2=this.Pmut2;child2.Pmut2=this.Pmut2;
        child1.mutate();child2.mutate();//possible mutation of the children's genome.
        Candidate[] children={child1,child2};
        return children;
    }

    //Cycle crossOver between 2 individuals.
    public Candidate[] cycleCrossOver(Candidate C1,Candidate C2){
        Candidate child1= new Candidate(),child2=new Candidate();//generating two children Candidates
        final int [] genomeP1=C1.getGenome(),genomeP2=C2.getGenome(),//generating some arrays 
                genomeC1=new int [numberOfQueens],  //with the genomes(parents and children)
                genomeC2=new int [numberOfQueens];
        Map<Integer,Integer> P1copy=new HashMap<>(),P2copy=new HashMap<>(),
                copyP1=new HashMap<>(), copyP2=new HashMap<>();
        for(int i = 0; i< numberOfQueens; i++){
            P1copy.put(i, genomeP1[i]);
            P2copy.put(i, genomeP2[i]);
            copyP1.put(genomeP1[i],i);
            copyP2.put(genomeP2[i],i);
        }
        Random ran=new Random();
        int ran1,ran2;
        Integer [] keys;
        while(!P1copy.isEmpty()){
            ran2=ran.nextInt(2);
            if(ran2==0){
                keys = P1copy.keySet().toArray(new Integer[P1copy.size()]);
                ran1=ran.nextInt(keys.length);
                int newVal,pos=keys[ran1];
                do{
                    genomeC1[pos]=P1copy.get(pos);
                    newVal=P2copy.get(pos);
                    P1copy.remove(pos);
                    P2copy.remove(pos);
                    pos=copyP1.get(newVal);
                    
                }while(genomeP1[keys[ran1]]!=newVal);
            }if(ran2==1){
                keys = P2copy.keySet().toArray(new Integer[P2copy.size()]);
                ran1=ran.nextInt(keys.length);
                int newVal,pos=keys[ran1];
                do{
                    genomeC1[pos]=P2copy.get(pos);
                    newVal=P1copy.get(pos);
                    P2copy.remove(pos);
                    P1copy.remove(pos);
                    pos=copyP2.get(newVal);
                }while(genomeP2[keys[ran1]]!=newVal);
            }
        }
        for(int i = 0; i< numberOfQueens; i++){
            P1copy.put(i, genomeP1[i]);
            P2copy.put(i, genomeP2[i]);
        }
        while(!P2copy.isEmpty()){
            ran2=ran.nextInt(2);
            if(ran2==0){
                keys = P1copy.keySet().toArray(new Integer[P1copy.size()]);
                ran1=ran.nextInt(keys.length); int newVal,pos=keys[ran1],control=genomeP1[keys[ran1]];
                do{
                    genomeC2[pos]=P1copy.get(pos);
                    newVal=P2copy.get(pos);
                    P1copy.remove(pos);
                    P2copy.remove(pos);
                    pos=copyP1.get(newVal);
                }while(control!=newVal);
            }if(ran2==1){
                keys = P2copy.keySet().toArray(new Integer[P2copy.size()]);
                ran1=ran.nextInt(keys.length);
                int newVal,pos=keys[ran1],control=genomeP2[keys[ran1]];
                do{
                    genomeC2[pos]=P2copy.get(pos);
                    newVal=P1copy.get(pos);
                    P2copy.remove(pos);
                    P1copy.remove(pos);
                    pos=copyP2.get(newVal);
                }while(control!=newVal);
            }
        }
        child1.setGenome(genomeC1);//sets the child's genome
        child2.setGenome(genomeC2);
        child1.Pmut1=this.Pmut1;child2.Pmut1=this.Pmut1;
        child1.Pmut2=this.Pmut2;child2.Pmut2=this.Pmut2;
        child1.mutate();child2.mutate();//possible mutation of the children's genome.
        Candidate[] children={child1,child2};
        return children;
    }
    
    //Compute the mean fitness of the population.
    public double mean(){
        double mean=0.0;
        Candidate []copi=this.Population;
        for(int i=0;i<size;i++){
            mean+=copi[i].fitness;
        }
        return mean/(size);
    }

    //To print on the screen the fitness of the population individuals.
    @Override
    public String toString() {
        String sr="";
        for(int i=0;i<size-1;i++){
            sr= sr+ Population[i].fitness+"-->";
        }sr= sr+ Population[size-1].fitness;
        return sr;
    }

    /*Subclass that represents the individual belonging to the population*/
    public class Candidate extends Population implements Comparable <Candidate>{
        private int[] genome=new int[numberOfQueens];//array with the genome
        public int fitness;//fitness of the individual.
        public String name;
           
        /*Methods that create the individuals and allow the mutation of the
        corresponding individual’s genome.*/
              
        //Instance of the object, generating his genome randomly.
        public Candidate() {
            List<Integer> numbers = new ArrayList<>(numberOfQueens);//needed to shuffle.
            for (int i = 0; i< numberOfQueens; i++){//sorted array.
                   numbers.add(i);
            }
            Collections.shuffle(numbers);//shuffle.
            int j=0;
            for (int i:numbers){//generating the genome.
                this.genome[j++]=i;
            }
            fitness=this.fitness();
            this.setName();
        }

        //Calculates the fitness of the individual.
        private int fitness(){
            int t=0;//to storage the fitness.
            int [] f1=new int [numberOfQueens],f2=new int [numberOfQueens];//to store the altered genome.
            
            for(int i = 0; i< numberOfQueens; i++){//stores the  genome considering only diagonals.
                f1[i]=this.genome[i]-i;//forward
                f2[i]= numberOfQueens -this.genome[i]-i;//backward
            }
            Arrays.sort(f1);//sort
            Arrays.sort(f2);
            for(int i = 1; i< numberOfQueens; i++){//computes the fitness.
                if(f1[i]==f1[i-1]){
                    t+=2;
                }if(f2[i]==f2[i-1]){
                    t+=2;
                }
            }
         return t;   
        }

        //Mutate the individual genomes.
        public void mutate(){
            Random ran=new Random();//random to select 2 genes from the genome and if the mutation happens.
            if(ran.nextDouble()<=Pmut1){//single mutation probability.
                int rand1=ran.nextInt(numberOfQueens),rand2=ran.nextInt(numberOfQueens);
                int val1=genome[rand1],val2=genome[rand2];
                genome[rand1]=val2;genome[rand2]=val1;  //interchanging genes.
            }
            if(ran.nextDouble()<=Pmut2){//double mutation probability.
                    int rand1=ran.nextInt(numberOfQueens),rand2=ran.nextInt(numberOfQueens);
                    int val1=genome[rand1], val2=genome[rand2];
                    genome[rand1]=val2;genome[rand2]=val1;//interchanging genes.
                }
            fitness=this.fitness();//recalculates the fitness after the mutation.
            this.setName();//recalculates the name
        }

        //Sets the genome of the individual.
        public void setGenome(int[] genome) {
            this.genome = genome;//sets the genome.
            fitness=this.fitness();//recalculates the fitness.
            this.setName();//recalculates the name
        }

        //Return the genome.
        public int[] getGenome() {
            return genome;
        }

        //Sets the name of the genome.
        private void setName(){
            name="";
            for(int i:this.genome){
                name+=i+";";
            }
        }

        //To print in the screen.
        @Override
        public String toString() {
            String sr="";
            for(int i:this.genome){
                sr+= i+", ";
            }
            return "Genome = " + sr;
        }

        // To be able to compare these objects(Candidate)(allows the usage of the sort function.)
        @Override
        public int compareTo(Candidate t) {
            if(this.fitness>t.fitness){
                return 1;
            }
            if(this.fitness<t.fitness){
                return -1;
            }
            return 0;
         }
        
    }
}
