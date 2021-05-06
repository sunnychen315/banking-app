package edu.sjsu.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckingsViewer extends BankViewer {
    JLabel depositamount;
    JLabel withdrawamount;
    JLabel balanceamount;

    public CheckingsViewer() {
        super();
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
        depositamount = new JLabel("Amount to Deposit:");
        depositamount.setFont(new Font("Sans Serif", Font.BOLD, 15));
        depositamount.setForeground(Color.WHITE);
        depositamount.setVisible(true);
        JTextField amount = new JTextField(5);
        JButton confirm = new JButton("Confirm");

        deposit.setLayout(new BoxLayout(deposit, BoxLayout.Y_AXIS));
        deposit.add(depositText);
        deposit.add(Box.createRigidArea(new Dimension(0, 60)));
        deposit.add(depositamount);
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
        withdrawamount = new JLabel("Amount to Withdraw:");
        withdrawamount.setFont(new Font("Sans Serif", Font.BOLD, 15));
        withdrawamount.setForeground(Color.WHITE);
        withdrawamount.setVisible(true);
        JTextField amount = new JTextField(5);
        JButton confirm = new JButton("Confirm");

        withdraw.setLayout(new BoxLayout(withdraw, BoxLayout.Y_AXIS));
        withdraw.add(withdrawText);
        withdraw.add(Box.createRigidArea(new Dimension(0, 60)));
        withdraw.add(withdrawamount);
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
        balanceamount = new JLabel("Checking's Balance:");
        balanceamount.setFont(new Font("Sans Serif", Font.BOLD, 15));
        balanceamount.setForeground(Color.WHITE);
        balanceamount.setVisible(true);
        JLabel amount = new JLabel("insert total amount here");


        balance.setLayout(new BoxLayout(balance, BoxLayout.Y_AXIS));
        balance.add(withdrawText);
        balance.add(Box.createRigidArea(new Dimension(0, 60)));
        balance.add(balanceamount);
        balance.add(amount);
        balance.add(Box.createRigidArea(new Dimension(0, 110)));
        balance.setBackground(new Color(160, 212, 226));
        balance.setVisible(true);
        this.add(balance);
    }


}
