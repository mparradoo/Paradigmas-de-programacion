class MiHilo Thread extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("Hilo extendiendo Thread: ejecutando...");
            try {
                Thread.sleep(500);}
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}