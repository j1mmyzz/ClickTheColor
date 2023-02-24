public class Timer implements Runnable{
    public static int minute = 60;

    @Override
    public void run() {
        for(int i = minute; i>=0; i--){
            try {
                Thread.sleep(1000);
                minute--;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {
        new Thread(new Timer()).start();
    }




}
