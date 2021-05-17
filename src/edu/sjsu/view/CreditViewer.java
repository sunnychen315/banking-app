package edu.sjsu.view;

import edu.sjsu.messages.ConfirmCreditCardPaymentMessage;
import edu.sjsu.messages.Message;
import edu.sjsu.model.Account;
import edu.sjsu.model.Credit;
import edu.sjsu.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * this class lays out the view for the credit card account
 */
public class CreditViewer extends BankViewer {

    User user;
    Credit ccAccount;

    /**
     * constructor that creates the credit card page
     *
     * @param queue blocking queue that holds messages
     * @param user the user to be accessed
     */
    public CreditViewer(BlockingQueue<Message> queue, User user) {
        super(queue);
        this.setTitle("Credit Card Account");
        this.setBackground(new Color(7, 63, 120));
        this.user = user;
        for (Account a : user.getAccounts()) {
            if (a.getClass() == Credit.class) {
                ccAccount = (Credit) a;
            }
        }

        //adds login/logout
        addAccountName();
        //adds action listener to take user back to hope page when click top left
        addHomeActionListener();
        addBalancePanel();
        this.setVisible(true);
    }

    /**
     * Contains code for the balance panel where the user can pay off the credit card balance.
     * Contains action listener for when the pay button is clicked
     */
    public void addBalancePanel() {
        JPanel b = new JPanel();
        b.setBounds(this.getWidth() / 4, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        b.setSize(this.getWidth() / 2, this.getHeight() / 3);
        b.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel balance = new JLabel("Credit Card Balance:");
        balance.setFont(new Font("Sans Serif", Font.BOLD, 20));
        balance.setForeground(Color.WHITE);
        balance.setVerticalAlignment(SwingConstants.TOP);

        JLabel balanceAmount = new JLabel("$" + df.format(ccAccount.getBalance()));
        balanceAmount.setFont(new Font("Sans Serif", Font.BOLD, 30));
        balanceAmount.setForeground(new Color(196, 30, 58));
        balanceAmount.setVisible(true);

        JLabel amountToPay = new JLabel("Enter the amount you would like to pay off");
        amountToPay.setFont(new Font("Sans Serif", Font.BOLD, 15));
        amountToPay.setForeground(Color.WHITE);
        JTextField amount = new JTextField(5);
        JButton confirmPay = new JButton("Pay");

        confirmPay.addActionListener(e -> {
            double payAmount = Double.parseDouble(amount.getText());
            try {
                Message msg = new ConfirmCreditCardPaymentMessage(payAmount);
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
