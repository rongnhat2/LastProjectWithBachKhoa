/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.awt.Graphics;

/**
 *
 * @author Kirrnguyen
 */
public class PlayerInterface {
    // Tương tác với bản đồ
    int direction;              // xác định hướng của nhân vật -> 1: trên , 2: phải  , 3: dưới  , 4: trái 
    int speed;                  // tốc độ chạy
    
    // Chi tiết đối tượng
    int attackSpeed;            // tốc độ tấn công
    int attackPhysicalPoint;    // điểm tấn công
    int attackMagicPoint;       // điểm tấn công
    int TrueDamePoint;          // điểm Sát thương chuẩn
    int absorbPoint;            // điểm Hút máu
    int counterPoint;           // điểm Phản đòn
    int defensePhysicalPoint;   // điểm phòng thủ Vật lí
    int defenseMagicPoint;      // điểm phòng thủ Phép thuật
    int cooldownPoint;          // điểm hồi chiêu
    int healthPoint;            // điểm máu
    int manaPoint;              // điểm mana
    
    // thuộc tính khác
    int level;                  // cấp độ
    int status;                 // trạng thái biến hình
    
    // đối tượng hiển thị
    double x;                   // tọa độ X
    double y;                   // tọa độ Y
    double dx,dy;               // độ chênh lệch di chuyển
    int width;                  // Chiều rộng
    int height;                 // Chiều cao
    boolean up;                 // lên
    boolean down;               // xuống
    boolean left;               // sang trái
    boolean right;              // sang phải
    public PlayerInterface(){ }
    public void update(){ }
    public void render(Graphics g2){ }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }
    
}
