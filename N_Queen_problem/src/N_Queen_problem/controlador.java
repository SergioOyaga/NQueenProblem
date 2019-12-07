package N_Queen_problem;
import javax.swing.*;
import static N_Queen_problem.controlador.Tablero;

public class controlador{
    public static Piezas [][] Tablero;
    private tablero tb;
    private static final String Dama_blanca="/ajedrez/Imagenes/Dama_blanco.png";
    
    //Set the queens in the board.
    public controlador(tablero tb, int [] posiciones) {
        this.tb=tb;
        Tablero = new Piezas[Population.n][Population.n];
        for (int i=0;i<Population.n;i++){
            for(int j=0;j<Population.n;j++){
                Tablero[i][j]=Piezas.p.new Vacia(i,j); 
            }
        }
       for(int i=0;i<Population.n;i++){
       Tablero[i][posiciones[i]]=Piezas.p.new Dama(i,posiciones[i]);
       }
       this.setTablero(tb);
      }
    
    //Methods that works over the gui.
    private  void setTablero(tablero t){
        ImageIcon icon;
        icon = new javax.swing.ImageIcon(getClass().getResource(Dama_blanca));
       for(int i=0;i<Population.n;i++){
            for(int j=0;j<Population.n;j++){
               if ("D".equals(Tablero[i][j].getClase())){
                   t.setIcono(t.getJ(i,j),icon );
               }else{
                   t.setIcono(t.getJ(i,j),new ImageIcon("") );
                }
            }
       }
       if ("D".equals(Tablero[0][0].getClase())){
                   t.setIcono(t.getJ(0,0),icon );
               }else{
                   t.setIcono(t.getJ(0,0),new ImageIcon("") );
                }
      t.setVisible(true);
    }
     
}
