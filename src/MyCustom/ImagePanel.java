package MyCustom;

import javax.swing.*;
import java.awt.*;
//Lớp này được taọ ra để tạo ra một panel có thể hiển thị một hình ảnh 
public class ImagePanel extends JPanel {

    private Image img;//Hình ảnh sẽ được hiển thị trên panel 

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }
    //Nhận đường dẫn của hình ảnh , tạo đối tượng ImageIcon từ đường dẫn 
    //Lấy hình ảnh từ ImageIcon 

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        //Tạo một đối tượng Dimension với chiều rộng và chiều cao dựa trên kích thướt của hình ảnh 
        this.setPreferredSize(size);
        //Thiết lập kích thướt ưu tiên của ImagePanel
        //Kích thướt ưu tiên : Kích thướt muốn có khi được đặt trong một container 
        this.setMinimumSize(size);
        //Thiết lập kích thướt tối thiểu 
        //Kích thướt tối thiểu : Kích thướt nhỏ nhất mà ImageJPanel có thể có , ngăn không cho container nhỏ hơn kích thướt này 
        this.setMaximumSize(size);
        //Thiết lập kích thướt tối đa 
        this.setSize(size);
        //Thiết lập kích thướt thực tế của ImagePanel thành size
        this.setLayout(null);
    }
    //Nhận đối tượng hình ảnh và gán cho thuộc tính omg 
    //Cài đặt kích thướt panel dựa trên kích thướt hình ảnh 

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
    // Phương thức này được ghi đè từ lớp JPanel 
    //Dùng để vẽ hình ảnh lên panel 
    // Hình ảnh được vẽ tại (0,0) của panel bằng cách sử dụng đối tượng Graphics 
}
