public class Personagem {
   
    private String nome; 
    private int energia = 10;
    private int fome; 
    private int sono = 0;

    
    final static int LIMITE_SUPERIOR = 10;
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    public Personagem(int energia, int fome, int sono){
        if(energia >= 0 && energia <=10)
            this.energia = energia;
        if(fome >=0 && fome <=10)
            this.fome = fome;
        if(sono >= 0 && sono <=10)
            this.sono = sono;
    }
    public Personagem(String nome, int energia, int fome, int sono){
      
        this(energia,fome,sono);
        this.nome = nome;
        
    }

    void informarStatus(){
        System.out.printf("Status de %s:\nEnergia: %s - Sono: %s - Fome: %s\n", 
        this.nome,
        this.energia, 
        this.sono, 
        this.fome);
    }

    void cacar(){
       
        if(this.energia >= 2){
            System.out.println(this.nome + " caçando...");
            this.energia-=2;
            informarStatus();
        }
        else{
            System.out.println(this.nome + " sem energia para caçar...");
            informarStatus();
        }
        this.fome = Math.min(this.fome + 1, LIMITE_SUPERIOR);
        this.sono = Math.min(this.sono + 1,LIMITE_SUPERIOR);
    }
    void cacar(int n){
        
            System.out.println(this.nome + " caçando...");
            this.energia = this.energia - n >= 0 ? this.energia - n : 0;
            informarStatus();
        }
        else{
            System.out.println(this.nome + " sem energia para caçar...");
            informarStatus();
        }
        this.fome = Math.min(this.fome + n, LIMITE_SUPERIOR);
        this.sono = Math.min(this.sono + 1,LIMITE_SUPERIOR);
    }

    void comer(){
        if(this.fome >=1){
            System.out.printf("%s comendo...\n",this.nome);
            this.fome-=1;
         
            this.energia = this.energia +1 <= LIMITE_SUPERIOR ? this.energia+=1 : this.energia;
            informarStatus();
        }
        else{
            System.out.printf("%s sem fome...\n", this.nome);
            informarStatus();
        }
    }
    void comer(int n){
        if(this.fome >=1){
            System.out.printf("%s comendo...\n",this.nome);
            this.fome= this.fome - n >=0? this.fome - n :0;
            this.energia = this.energia +n <= LIMITE_SUPERIOR ? this.energia+=n : this.energia;
            informarStatus();
        }
        else{
            System.out.printf("Impressionante!. %s está sem fome...\n", this.nome);
            informarStatus();
        }
    }

    //Método dormir
    void dormir(){
        if(this.sono >= 1){
            System.out.println(String.format("%s dormindo...", this.nome));
            this.sono -=1;
            this.energia = this.energia + 1 <= LIMITE_SUPERIOR ? this.energia +1 : this.energia;
            informarStatus();
        }
        else{
            System.out.println(this.nome + " sem sono...");
            informarStatus();
        }
      
    }
    
}