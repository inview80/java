package passwordManage;

import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.Semaphore;

/**
 * Hello world!
 *
 * @author inview
 */
public class MyWindow {
    private JFrame jframe;
    private JButton addButton;
    private JButton delButton;
    private Semaphore semaphore = new Semaphore(0);
    private String userName;
    private String password;

    public static void main(String[] args) {
        new MyWindow();
    }

    protected MyWindow() {
        jframe = new JFrame("我的密码管理系统");
        jframe.setLayout(new BorderLayout());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(800, 600);
        JTable table = new JTable();
        jframe.add(table, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("   增  加   ");
        delButton = new JButton("   删  除   ");
        addButton.addActionListener(this::buttonClick);
        delButton.addActionListener(this::buttonClick);
        buttonPanel.add(addButton);
        buttonPanel.add(delButton);
        jframe.add(buttonPanel, BorderLayout.SOUTH);
        InputPasswordDialog ipd = new InputPasswordDialog(this.jframe, "inview",semaphore);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(StringUtils.isBlank(ipd.getPassword())){
            jframe.dispose();
            System.exit(0);
        }else {
            this.userName=ipd.getUserName();
            this.password=ipd.getPassword();
        }
        jframe.setVisible(true);
    }

    private void buttonClick(ActionEvent o) {
        if (o.getSource() == delButton) {
            showMessage("取消");
        } else {
            showMessage("确定");
        }
    }

    private void showMessage(String value) {showMessage("消息", value);
    }

    private void showMessage(String title, String value) {
        JDialog jd = new JDialog(this.jframe, title, false);
        jd.setLayout(new BorderLayout());
        jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jd.setLocation(400, 300);
        jd.setBounds(400, 300, 200, 150);
        JLabel jLabel = new JLabel(value);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JButton button = new JButton("  确  定  ");
        button.addActionListener(e -> jd.dispose());
        jd.add(jLabel, BorderLayout.CENTER);
        jd.add(button, BorderLayout.SOUTH);
        jd.setVisible(true);
    }
}
