package edu.sjsu.view;

import edu.sjsu.assets.StylishButton;
import edu.sjsu.messages.ConfirmCreditCardPaymentMessage;
import edu.sjsu.messages.Message;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class CreditViewer extends BankViewer {

    public CreditViewer(BlockingQueue<Message> queue) {
        super(queue);
        this.setTitle("Credit Card Account");
        this.setBackground(new Color(7, 63, 120));

        //adds login/logout
        addAccountName();
        //adds action listener to take user back to hope page when click top left
        addHomeActionListener();
        addBalancePanel();
        this.setVisible(true);
    }

    public void addBalancePanel() {
        JPanel b = new JPanel();
        b.setBounds(this.getWidth() / 4, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        b.setSize(this.getWidth() / 2, this.getHeight() / 3);
        b.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel balance = new JLabel("Credit Card Balance:");
        balance.setFont(new Font("Sans Serif", Font.BOLD, 20));
        balance.setForeground(Color.WHITE);
        balance.setVerticalAlignment(SwingConstants.TOP);

        JLabel balanceAmount = new JLabel("$500");
        balanceAmount.setFont(new Font("Sans Serif", Font.BOLD, 30));
        balanceAmount.setForeground(Color.RED);
        balanceAmount.setVisible(true);

        JLabel amountToPay = new JLabel("Enter the amount you would like to pay off");
        JTextField amount = new JTextField(5);
        StylishButton confirmPay = new StylishButton("Pay");

        confirmPay.addActionListener(e -> {
            double payAmmount = Double.parseDouble(amount.getText());
            try {
                Message msg = new ConfirmCreditCardPaymentMessage(payAmmount);
                queue.put(msg);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        b.setLayout(new BoxLayout(b, BoxLayout.Y_AXIS));
        b.add(balance);
        b.add(Box.createRigidArea(new Dimension(0, 30)));
        b.add(balanceAmount);
        b.add(Box.createRigidArea(new Dimension(0, 30)));
        b.add(amountToPay);
        b.add(amount);
        b.add(Box.createRigidArea(new Dimension(0, 30)));
        b.add(confirmPay);
        b.setBackground(new Color(160, 212, 226));
        b.setVisible(true);
        this.add(b);

    }
}
