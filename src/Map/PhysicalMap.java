/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import Window.KPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author KirrNguyen
 */
public class PhysicalMap {
    public static int xMap=0;
    public static int yMap=0;
    public static int size = 24;
    
    private int minx;
    private int miny;
    private int maxx =0;
    private int maxy =0;
    public static int map1[][];
    Image i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,
            i20,i21,i22,i23,i24,i25,i26;

    int sizeheight; // số hàng
    int sizewidth; //số cột
    
    public PhysicalMap(){
        setup();
        LoadingMap("src/Map/map2.txt");
        minx = KPanel.PanelWidth - sizewidth * size;
        miny = KPanel.PanelHeight - sizeheight * size;
    }
    
    // đọc map từ file txt
    public void LoadingMap(String s){
        try{
            BufferedReader  br = new BufferedReader(new FileReader(s));
            
            sizewidth = Integer.parseInt(br.readLine());
            sizeheight = Integer.parseInt(br.readLine());
            map1 = new int[sizeheight][sizewidth];
            
            String delimiter = "\\s+";
            for(int row = 0;row < sizeheight;row++){
                String line = br.readLine();
                String[] tokens = line.split(delimiter);
                for(int col=0;col < sizewidth;col++){
                    map1[row][col] = Integer.parseInt(tokens[col]);
                }
            }
        }
        catch(Exception e){
            System.out.println("not data");
        }
    }

//    public void render(Graphics g2){
//        for(int i = 0;i<50;i++){
//            for(int j = 0; j < 29 ; j++){
//                if(map1[j][i] == 0){
//                    g2.setColor(Color.green);
//                }else if(map1[j][i] == 1){
//                    g2.setColor(Color.blue);
//                }else if(map1[j][i] == 99){
//                    g2.setColor(Color.blue);
//                }else{
//                    g2.setColor(Color.red);
//                }
//                g2.fillRect(xMap+ i*24, yMap+ j*24, 24, 24);
//            }
//        }
//    }
    
    // in mặt phẳng
    public void render_flat(Graphics g2){
        for(int i = 0;i<50;i++){
            for(int j = 0; j < 29 ; j++){
                g2.drawImage(i26,xMap+ i*24,yMap+ j*24, null);
            }
        }
    }
    // in nền
    public void render_background(Graphics g2){
        for(int i = 0;i<50;i++){
            for(int j = 0; j < 29 ; j++){
                if(map1[j][i] == 0){
                    g2.drawImage(i1,xMap+ i*24,yMap+ j*24, null);
                }
            }
        }
    }
    // in trang trí
    public void render_decorate(Graphics g2){
        for(int i = 0;i<50;i++){
            for(int j = 0; j < 29 ; j++){
                if(map1[j][i] == 6){
                    g2.drawImage(i4,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 4){
                    g2.drawImage(i3,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 8){
                    g2.drawImage(i5,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 10){
                    g2.drawImage(i7,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 14){
                    g2.drawImage(i9,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 16){
                    g2.drawImage(i10,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 18){
                    g2.drawImage(i11,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 20){
                    g2.drawImage(i12,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 22){
                    g2.drawImage(i13,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 24){
                    g2.drawImage(i20,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 26){
                    g2.drawImage(i21,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 28){
                    g2.drawImage(i22,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 30){
                    g2.drawImage(i23,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 32){
                    g2.drawImage(i24,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 34){
                    g2.drawImage(i25,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 2){
                    g2.drawImage(i2,xMap+ i*24,yMap+ j*24, null);
                }
                g2.drawRect(xMap+ i*24,yMap+ j*24, 24, 24);
            }
        }
    }
    // in vật thế va chạm
    public void render_object(Graphics g2){
        for(int i = 0;i<50;i++){
            for(int j = 0; j < 29 ; j++){
                if(map1[j][i] == 1){
                    g2.drawImage(i6,xMap+ i*24,yMap+ j*24, null);
                    g2.setColor(Color.red);
                    g2.drawRect(xMap+ i*24,yMap+ j*24, 24, 24);
                }else if(map1[j][i] == 3){
                    g2.drawImage(i14,xMap+ i*24 + 12 - i14.getWidth(null)/2,yMap+ j*24 + 24 - i14.getHeight(null), null);
                }else if(map1[j][i] == 5){
                    g2.drawImage(i15,xMap+ i*24 + 12 - i15.getWidth(null)/2,yMap+ j*24 + 24 - i15.getHeight(null), null);
                }else if(map1[j][i] == 7){
                    g2.drawImage(i16,xMap+ i*24+ 12 - i16.getWidth(null)/2,yMap+ j*24 + 24 - i16.getHeight(null), null);
                }else if(map1[j][i] == 9){
                    g2.drawImage(i17,xMap+ i*24+ 12 - i17.getWidth(null)/2,yMap+ j*24 + 24 - i17.getHeight(null), null);
                }else if(map1[j][i] == 11){
                    g2.drawImage(i18,xMap+ i*24+ 12 - i18.getWidth(null)/2,yMap+ j*24 + 24 - i18.getHeight(null), null);
                }else if(map1[j][i] == 12){
                    g2.drawImage(i8,xMap+ i*24,yMap+ j*24, null);
                }else if(map1[j][i] == 13){
                    g2.drawImage(i19,xMap+ i*24+ 12 - i19.getWidth(null)/2,yMap+ j*24 + 24 - i19.getHeight(null), null);
                }
            }
        }
    }
    
    public void setup(){
        i1 = getImageIcon("f00");
        i2 = getImageIcon("f01");
        i3 = getImageIcon("f02");
        i4 = getImageIcon("f03");
        i5 = getImageIcon("f04");
        i6 = getImageIcon("f05");
        i7 = getImageIcon("f06");
        i8 = getImageIcon("f07");
        i9 = getImageIcon("f08");
        i10 = getImageIcon("f09");
        i11 = getImageIcon("f10");
        i12 = getImageIcon("f11");
        i13 = getImageIcon("f12");
        i14 = getImageIcon("f13");
        i15 = getImageIcon("f14");
        i16 = getImageIcon("f15");
        i17 = getImageIcon("f16");
        i18 = getImageIcon("f17");
        i19 = getImageIcon("f18");
        i20 = getImageIcon("f19");
        i21 = getImageIcon("f20");
        i22 = getImageIcon("f21");
        i23 = getImageIcon("f22");
        i24 = getImageIcon("f23");
        i25 = getImageIcon("f24");
        i26 = getImageIcon("block"); 
    }
    
    private Image getImageIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Assets/Map/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return image;
    }
    public void setxMap(int i) {
        xMap = i;
        if(xMap < minx) xMap = minx;
        if(xMap > maxx) xMap = maxx;
    }
    public void setyMap(int i) {
        yMap = i;
        if(yMap < miny) yMap = miny;
        if(yMap > maxy) yMap = maxy;
    }
    public int getColTile(int x){
        return x/size;
    }
    public int getRowTile(int y){
        return y/size;
    }
    // lấy số nguyên, đổi sang giá trị binary, rồi chia cho 10, nếu số dư = 1 thì không thể di chuyển qua
    // sử lí bitmap , map = 1 là không thể di chuyển qua
    public int binary(int a){
        return Integer.parseInt(Integer.toBinaryString(a))%10;
   }
    public int getTile(int x,int y){
        return binary(map1[x][y]);
    }
}
