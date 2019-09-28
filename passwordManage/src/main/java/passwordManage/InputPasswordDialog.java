package passwordManage;

import lombok.Getter;
import passwordManage.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.concurrent.Semaphore;


public class InputPasswordDialog extends JDialog {
    @Getter
    private String userName;
    @Getter
    private String password;
    @Getter
    private List<User> users;

    private JTextField nameTxt;
    private JTextField pwdTxt;
    private Semaphore semaphore;

    protected InputPasswordDialog(Frame owner, String userName, Semaphore semaphore) {
        super(owner, "请输入密码");
        this.semaphore = semaphore;
        JPanel[] jPanel = new JPanel[3];
        for (int i = 0; i < jPanel.length; i++) {
            jPanel[i] = new JPanel();
            jPanel[i].setSize(280, 35);
        }
        setLayout(new GridLayout(5, 1));
        setBounds(400, 300, 300, 230);
        nameTxt = new JTextField(12);
        nameTxt.setText(userName);
        pwdTxt = new JPasswordField(12);

        JLabel l1=new JLabel("用户名：");
        l1.setPreferredSize(new Dimension(60,30));
        l1.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel l2=new JLabel("密   码：");
        l2.setPreferredSize(new Dimension(60,30));
        l2.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton okBtn = new JButton("确定");
        JButton cancelBin = new JButton("取消");
        okBtn.addActionListener(e -> btnClick(e));
        cancelBin.addActionListener(e -> btnClick(e));

        jPanel[0].add(l1);
        jPanel[0].add(nameTxt);
        jPanel[1].add(l2);
        jPanel[1].add(pwdTxt);
        jPanel[2].add(okBtn);
        jPanel[2].add(cancelBin);
        add(new Label());
        for (int i = 0; i < jPanel.length; i++) {
            add(jPanel[i]);
        }

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                btnClick(new ActionEvent(new Button(), 0, "close"));
            }
        });
        this.setVisible(true);
    }

    private void btnClick(ActionEvent e) {
        if ("确定".equals(e.getActionCommand())) {
            userName=nameTxt.getText();
            password = "1111";
            // TODO: 2019/9/20
        } else {
            password = null;
        }
        this.dispose();
        semaphore.release();
    }
}
