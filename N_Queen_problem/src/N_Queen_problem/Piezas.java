package N_Queen_problem;

public class Piezas {
    public static Piezas p=new Piezas();
    
    public String getClase(){
        return this.getClase();
    }
    public void setPosicion(int i, int j){
         this.setPosicion(i, j);
    }
    public int [] getPos(){
        return this.getPos();
    }
    
    public class Vacia extends Piezas{
        private final String clase=" ";
        private int[] pos=new int [2];
        private boolean quieto=false;
        
        public Vacia(int i, int j) {
            pos[0]=i;
            pos[1]=j;
        }
        @Override
        public String getClase(){
        return clase;
       
        }
        @Override
        public void setPosicion(int i, int j) {
            this.pos[0]=i;
            this.pos[1]=j;
        }
        @Override
        public int[] getPos() {
            return pos;
        }        
    }
    public class Dama extends Piezas{
        private final String clase="D";
        private int[] pos=new int [2];
        private boolean quieto=true;

        public Dama(int i, int j) {
            pos[0]=i;
            pos[1]=j;
        }
        @Override
        public String getClase(){
        return clase;
        }
        @Override
        public void setPosicion(int i, int j) {
            this.pos[0]=i;
            this.pos[1]=j;
        }
        @Override
        public int[] getPos() {
            return pos;
        }
    }  

}
