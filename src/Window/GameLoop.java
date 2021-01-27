/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Window;

import static Window.KFrame.kpanel;
import javax.swing.JPanel;

/**
 *
 * @author KirrNguyen
 */
public class GameLoop extends JPanel implements Runnable{
    //  nanogiây    1.000.000.000
    //  microgiây   1.000.000
    //  miligiây    1.000
    //  giây        1
    
    private int FPS = 100;                      // 100 frame / giây
    private long Time = 1000*1000000/FPS;       // chu kì ( nano giây ) / FPS 
    private boolean isRunning;      // biến running
    public static long DELTA_TIME; // lấy thời gian delta liên tục để update
    Thread thread;
    public GameLoop(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run(){
        long beginTime;
        long deltaTime;
        long sleepTime;
        int a = 0;
        kpanel.init();
        while(isRunning){
            // lấy time tại thời điểm       
            beginTime = System.nanoTime();
            // chạy các hàm update-render ở đây
            // DELTA_TIME chạy milisecond
            DELTA_TIME = System.currentTimeMillis();
            
            kpanel.update();
            kpanel.render();
            kpanel.draw();
            
            // END
            // repaint theo FPS 
            // lấy ra thời gian hệ thống sau khi thực hiện update-render
            // đơn vị nanosecond
            deltaTime = System.nanoTime() - beginTime;
            // tính thời gian ngủ theo chu kì
            // đơn vị milisecond
            sleepTime = Time - deltaTime;
            // đổi nano ra mili
            try {
                if(sleepTime > 0){
                    Thread.sleep(sleepTime/1000000);
                }else{
                    Thread.sleep(Time/1000000);
                }
            } catch (InterruptedException ex) {
                System.out.println("sleep");       
            }
        }
    }
}
