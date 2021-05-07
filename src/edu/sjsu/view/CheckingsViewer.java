package edu.sjsu.view;

import edu.sjsu.messages.ConfirmDepositMessage;
import edu.sjsu.messages.ConfirmWithdrawMessage;
import edu.sjsu.messages.Message;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class CheckingsViewer extends BankViewer {
    JLabel depositAmount;
    JLabel withdrawAmount;
    JLabel balanceAmount;

    public CheckingsViewer(BlockingQueue<Message> queue) {
        super(queue);
        this.setTitle("Checkings Account");
        this.setBackground(new Color(7, 63, 120));
        this.setVisible(true);
        addDepositPanel();
        addWithdrawPanel();
        addBalancePanel();

    }

    public void addDepositPanel() {
        JPanel deposit = new JPanel();
        deposit.setBounds(this.getWidth() / 16, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        deposit.setSize(this.getWidth() / 4, this.getHeight() / 3);

        deposit.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel depositText = new JLabel("Deposit");
        depositText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        depositText.setForeground(Color.WHITE);
        depositText.setVerticalAlignment(SwingConstants.TOP);
        depositAmount = new JLabel("Amount to Deposit:");
        depositAmount.setFont(new Font("Sans Serif", Font.BOLD, 15));
        depositAmount.setForeground(Color.WHITE);
        depositAmount.setVisible(true);
        JTextField amount = new JTextField(5);
        JButton confirm = new JButton("Confirm");

        confirm.addActionListener(e -> {
            double depositAmount = Double.parseDouble(amount.getText());
            try {
                Message msg = new ConfirmDepositMessage(depositAmount);
                queue.put(msg);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        deposit.setLayout(new BoxLayout(deposit, BoxLayout.Y_AXIS));
        deposit.add(depositText);
        deposit.add(Box.createRigidArea(new Dimension(0, 60)));
        deposit.add(depositAmount);
        deposit.add(amount);
        deposit.add(Box.createRigidArea(new Dimension(0, 100)));
        deposit.add(confirm);
        deposit.setBackground(new Color(160, 212, 226));
        deposit.setVisible(true);
        this.add(deposit);
    }

    public void addWithdrawPanel() {
        JPanel withdraw = new JPanel();
        withdraw.setBounds(6 * (this.getWidth() / 16), 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        withdraw.setSize(this.getWidth() / 4, this.getHeight() / 3);
        withdraw.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel withdrawText = new JLabel("Withdraw");
        withdrawText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        withdrawText.setForeground(Color.WHITE);
        withdrawText.setVerticalAlignment(SwingConstants.TOP);
        withdrawAmount = new JLabel("Amount to Withdraw:");
        withdrawAmount.setFont(new Font("Sans Serif", Font.BOLD, 15));
        withdrawAmount.setForeground(Color.WHITE);
        withdrawAmount.setVisible(true);
        JTextField amount = new JTextField(5);
        JButton confirm = new JButton("Confirm");

        confirm.addActionListener(e -> {
            double withdrawAmount = Double.parseDouble(amount.getText());
            try {
                Message msg = new ConfirmWithdrawMessage(withdrawAmount);
                queue.put(msg);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });


        withdraw.setLayout(new BoxLayout(withdraw, BoxLayout.Y_AXIS));
        withdraw.add(withdrawText);
        withdraw.add(Box.createRigidArea(new Dimension(0, 60)));
        withdraw.add(withdrawAmount);
        withdraw.add(amount);
        withdraw.add(Box.createRigidArea(new Dimension(0, 100)));
        withdraw.add(confirm);
        withdraw.setBackground(new Color(160, 212, 226));
        withdraw.setVisible(true);
        this.add(withdraw);
    }

    public void addBalancePanel() {
        JPanel balance = new JPanel();
        balance.setBounds(11 * (this.getWidth() / 16), 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        balance.setSize(this.getWidth() / 4, this.getHeight() / 3);
        balance.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel withdrawText = new JLabel("Balance");
        withdrawText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        withdrawText.setForeground(Color.WHITE);
        withdrawText.setVerticalAlignment(SwingConstants.TOP);
        balanceAmount = new JLabel("Checking's Balance:");
        balanceAmount.setFont(new Font("Sans Serif", Font.BOLD, 15));
        balanceAmount.setForeground(Color.WHITE);
        balanceAmount.setVisible(true);
        JLabel amount = new JLabel("insert total amount here");


        balance.setLayout(new BoxLayout(balance, BoxLayout.Y_AXIS));
        balance.add(withdrawText);
        balance.add(Box.createRigidArea(new Dimension(0, 60)));
        balance.add(balanceAmount);
        balance.add(amount);
        balance.add(Box.createRigidArea(new Dimension(0, 110)));
        balance.setBackground(new Color(160, 212, 226));
        balance.setVisible(true);
        this.add(balance);
    }


}
