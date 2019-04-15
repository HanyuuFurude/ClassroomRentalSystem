import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch8_toolbar.BEToolBarUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

public class SwingTest3 {
    private JFrame f = null;
    private JTextField username = new JTextField(10);
    private JPasswordField password = new JPasswordField(10);
    private JLabel user = null;
    private JLabel pwd = null;
    private JButton login = null;
    private JButton reset = null;
    private JCheckBox bas = null;
    private JCheckBox foot = null;
    private JMenuBar menuBar = null;

    public SwingTest3(){
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            f = new JFrame("Swing登录界面");
            menuBar = createMenus();
            f.setJMenuBar(menuBar);
            user = new JLabel("用户名：");
            pwd = new JLabel("密  码：");
            bas = new JCheckBox("篮球");
            foot = new JCheckBox("足球");
            login = new JButton("登录");
            reset = new JButton("重置");
            login.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
            login.setForeground(Color.white);
            reset.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
            reset.setForeground(Color.white);
            login.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(null == username.getText() || "".equals(username.getText())) {
                        JOptionPane.showMessageDialog(null, "用户名不能为空");
                        return;
                    }
                    if(null == password.getText() || "".equals(password.getText())) {
                        JOptionPane.showMessageDialog(null, "密码不能为空");
                        return;
                    }
                    if(null != username.getText() && "wbb".equals(username.getText()) && null != password.getText() && "123".equals(password.getText())) {
                        JOptionPane.showMessageDialog(null, "登录成功，欢迎您：" + username.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "用户名密码错误，请重新输入");
                    }
                }
                @Override
                public void mousePressed(MouseEvent e) { }
                @Override
                public void mouseReleased(MouseEvent e) { }
                @Override
                public void mouseEntered(MouseEvent e) { }
                @Override
                public void mouseExited(MouseEvent e) { }
            });
            reset.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    username.setText("");
                    password.setText("");
                }
                @Override
                public void mousePressed(MouseEvent e) { }
                @Override
                public void mouseReleased(MouseEvent e) { }
                @Override
                public void mouseEntered(MouseEvent e) { }
                @Override
                public void mouseExited(MouseEvent e) { }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        //条件
        JPanel p = new JPanel();
        //按钮
        JPanel bt = new JPanel();

        //设置行列
        p.setLayout(new GridLayout(3, 2));
        bt.setLayout(new GridLayout(1, 2));

        p.add(user);
        p.add(username);
        p.add(pwd);
        p.add(password);
        p.add(bas);
        p.add(foot);

        bt.add(login);
        bt.add(reset);

        f.add(p, BorderLayout.NORTH);
        f.add(bt, BorderLayout.SOUTH);
//        调置窗体背景全透明并完全隐藏一个窗体的标题栏
//        f.setUndecorated(true);
//        AWTUtilities.setWindowOpaque(f, false);
//        f.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        f.setVisible(true);
        f.setBounds(800, 300, 400, 400);
        f.pack();
    }

    public JMenuBar createMenus() {
        JMenuItem mi;
        // ***** create the menubar ****
        JMenuBar menuBar = new JMenuBar();
        menuBar.getAccessibleContext().setAccessibleName("工具栏");

        // ***** create File menu
        JMenu fileMenu = (JMenu) menuBar.add(new JMenu("文件"));
        createMenuItem(fileMenu, "新建", "FileMenu.about_mnemonic", "新建文件",null);
        createMenuItem(fileMenu, "保存", "FileMenu.about_mnemonic", "保存文件",null);
        createMenuItem(fileMenu, "删除", "FileMenu.about_mnemonic", "删除文件",null);
        createMenuItem(fileMenu, "另存为...", "FileMenu.about_mnemonic", "另存为...",null);
        fileMenu.addSeparator();
        JMenu editMenu = (JMenu) menuBar.add(new JMenu("编辑"));
        createMenuItem(editMenu, "字体大小", "FileMenu.about_mnemonic", "字体大小",null);
        createMenuItem(editMenu, "颜色", "FileMenu.about_mnemonic", "颜色",null);
        createMenuItem(editMenu, "格式", "FileMenu.about_mnemonic", "格式",null);
        fileMenu.addSeparator();
        editMenu.addSeparator();
        return menuBar;
    }

    public JMenuItem createMenuItem(JMenu menu, String label, String mnemonic,
                                    String accessibleDescription, Action action) {
        JMenuItem mi = (JMenuItem) menu.add(new JMenuItem(label));

//		mi.setBorder(BorderFactory.createEmptyBorder());
        mi.setMnemonic(mnemonic.charAt(0));
        mi.getAccessibleContext().setAccessibleDescription(accessibleDescription);
        mi.addActionListener(action);
        if(action == null) {
            mi.setEnabled(false);
        }
        return mi;
    }

    public static void main(String[] args) {
        //隐藏设置按钮
        UIManager.put("RootPane.setupButtonVisible",false);
//        //定义border颜色
//        Border bd = new BEToolBarUI.ToolBarBorder(
//                UIManager.getColor(Color.green),//Floatable时触点的颜色
//                UIManager.getColor(Color.yellow),//Floatable时触点的阴影颜色
//                new Insets(6,0,11,0)                    //border的默认insets
//        );
//        UIManager.put("ToolBar.border",new BorderUIResource(bd));
        new SwingTest3();
    }
}