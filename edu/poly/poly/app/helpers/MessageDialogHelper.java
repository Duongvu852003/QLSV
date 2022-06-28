package edu.poly.poly.app.helpers;

import java.awt.Component;
import javax.swing.JOptionPane;
// cho phép định nghĩa và sử dụng các phương thức để hiển thị ra các hộp thoại trong ứng dụng


public class MessageDialogHelper {

    public static void showMessageDialog(Component parent, String content, String title) {
        JOptionPane.showConfirmDialog(parent, title, content, JOptionPane.INFORMATION_MESSAGE);
    }

    // hiển thị thông báo lỗi
    public static void showErorDialog(Component parent, String content, String title) {
        JOptionPane.showConfirmDialog(parent, title, content, JOptionPane.ERROR_MESSAGE);
    }

    public static int showConfirmDialog(Component parent, String content, String title) {
        int choose = JOptionPane.showConfirmDialog(parent, title, content, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose;
    }
}
