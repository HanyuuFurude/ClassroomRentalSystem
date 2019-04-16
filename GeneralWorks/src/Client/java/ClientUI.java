import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ClientUI {

    private JFrame frame;
    private JTextField textField;
    /**
     * @Author: Hanyuu
     * @Description: 重构：将临时变量划归到类变量中以便调用
     * @Date: 2019/4/15
     */
    private JPanel[] JPlpanel;
    /**
     * @Author: Hanyuu
     * @Description: 重构：将游离的temp变量划归到类变量中
     * @Date: 2019/4/15
     */
    public   JPanel Jplcanvas;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientUI window = new ClientUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ClientUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setEnabled(false);
        frame.setBounds(100, 100, 700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome\uFF01+Status");
        lblWelcome.setBounds(27, 62, 99, 15);
        frame.getContentPane().add(lblWelcome);

        //Login点击事件
        JLabel lblLogin = new JLabel("Login");
        lblLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginFrame loginframe = new LoginFrame();
                loginframe.setVisible(true);

            }
        });

        lblLogin.setBounds(521, 62, 58, 15);
        frame.getContentPane().add(lblLogin);

        JLabel lblLogout = new JLabel("Logout");
        lblLogout.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //update(); 有坑 要以visitor的身份调用update @Override
            }
        });
        lblLogout.setBounds(578, 62, 58, 15);
        frame.getContentPane().add(lblLogout);

        JLabel label = new JLabel("\u6559\u5BA4\u79DF\u501F\u7CFB\u7EDF");
        label.setBounds(279, 10, 88, 15);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("\u6D45\u84DD\u8272\u8868\u793A\u53EF\u501F\uFF0C\u6D45\u7D2B\u8272\u8868\u793A\u5DF2\u51FA\u501F");
        label_1.setBounds(224, 35, 233, 23);
        frame.getContentPane().add(label_1);

        /**
         * 初始化row，col
         */
        int row = 15;
        int col = 13;


        /**
         * 生成最上面一行的时间textField
         */
        JTextField[] time_textField = new JTextField[col + 1];
        for (int j = 1; j < col; j++) {

            time_textField[j] = new JTextField();

            time_textField[j].setDisabledTextColor(new Color(0, 0, 0));
            time_textField[j].setForeground(new Color(0, 0, 0));
            time_textField[j].setFont(new Font("黑体", Font.PLAIN, 10));
            time_textField[j].setHorizontalAlignment(SwingConstants.CENTER);

            time_textField[j].setText((j + 7) + ":00");
            time_textField[j].setBackground(new Color(245, 245, 245));
            time_textField[j].setEnabled(false);
            time_textField[j].setBounds(j * 40 + 60, 100, 40, 30);
            frame.getContentPane().add(time_textField[j]);
            time_textField[j].setColumns(10);
        }

        textField = new JTextField();
        textField.setDisabledTextColor(new Color(0, 0, 0));
        textField.setForeground(new Color(0, 0, 0));
        textField.setFont(new Font("黑体", Font.PLAIN, 10));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setText("ClassRoom");
        textField.setBackground(new Color(245, 245, 245));
        textField.setEnabled(false);
        textField.setBounds(40, 100, 60, 30);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        /**
         * 生成最左侧一行的教室textField
         */
        JTextField[] class_textField = new JTextField[row + 1];
        for (int i = 1; i < row; i++) {

            class_textField[i] = new JTextField();
            class_textField[i].setHorizontalAlignment(SwingConstants.CENTER);

            //缺少class_textField.setText(...);+一个调用classlist显示在文本框内的函数
            class_textField[i].setDisabledTextColor(new Color(0, 0, 0));
            class_textField[i].setForeground(new Color(0, 0, 0));
            class_textField[i].setFont(new Font("黑体", Font.PLAIN, 10));
            class_textField[i].setBackground(new Color(245, 245, 245));
            class_textField[i].setEnabled(false);

            class_textField[i].setBounds(40, i * 30 + 100, 60, 30);
            frame.getContentPane().add(class_textField[i]);
            class_textField[i].setColumns(10);
        }

        //class_textField[10].setText(time_textField[5].getText()); 测试代码，开始时间=j+7
        /**
         * 绘制row*col表格
         */
        /**
         * @Author: Hanyuu
         * @Description:重构：将临时变量划归到类变量中以便调用
         * @Date: 2019/4/15
         */
        //JPanel[] panel = new JPanel[211];
        this.JPlpanel = new JPanel[211];

        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++) {
                /**
                 * @Author: Hanyuu
                 * @Description:重构：将游离的temp变量划归到类变量中
                 * @Date: 2019/4/15
                 */
                //JPanel temp;
                Jplcanvas = new JPanel();
                this.JPlpanel[i * 14 - 14 + j] = new JPanel();
//                temp = this.JPlpanel[i * 14 - 14 + j];
//
//                temp.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.window, SystemColor.window, SystemColor.window, SystemColor.window));
//                temp.setBackground((new Color(176, 224, 230)));
//                temp.setBounds((j * 40 + 60), (i * 30 + 100), 40, 30);
                Jplcanvas = this.JPlpanel[i * 14 - 14 + j];
                Jplcanvas.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.window, SystemColor.window, SystemColor.window, SystemColor.window));
                Jplcanvas.setBackground((new Color(176, 224, 230)));
                Jplcanvas.setBounds((j * 40 + 60), (i * 30 + 100), 40, 30);

                String classroom_name = class_textField[i].getText();
                //上一步获取了教室名称(String类型),下一步要传起止时间，考虑通过j坐标获取，需要具体格式要求
                //需要更改 把点击事件改为判断用户状态是否登录 如果未登录需发送登录请求，如果登录且点击时间段未出借可出借，否则弹出不可出借的提示框
                //或者考虑点击之后弹框要求输入起止时间，同样需要客户输入的时间格式要求，以及通过textField获取到的应该是一个String类型的起止时间，存疑
                /**
                 * @Author: Hanyuu
                 * @Description:重构：将游离的temp变量划归到类变量中
                 * @Date: 2019/4/15
                 */
//                temp.addMouseListener(new MouseAdapter() {
                Jplcanvas.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        e.getSource();
                        //传递的参数  classroom_name(已有获取方式) 起止时间(有获取String类型和int类型的方式，需要转化)
                        //缺少一个发送订单的函数 根据返回的statuscode调用info，以及比对返回值确认是否改色(更新)
//                        temp.setBackground(new Color(216, 191, 216));
                        ((JPanel)e.getSource()).setBackground(new Color(216, 191, 216));
                    }
                });
                frame.getContentPane().add(this.JPlpanel[i * 14 - 14 + j]);


            }


    }
}
