import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Formutama {

	private JFrame frame;
	private JTextField name;
	private JTextField id;
	private JTextField jumlah;
	private JTable table;
	
	int row;
	ArrayList<pemaingamemobile>pemaingamemobileList;
	DefaultTableModel dtm;
	String header[]= new String[] {"Nama Pemain Game Mobile","ID Pemain","Jumlah Akun"};
	private Image GM = new ImageIcon(Formutama.class.getResource("gambar/joystick.png")).getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formutama window = new Formutama();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void displaypemaingamemobileDetails() {
		dtm.setRowCount(0);
		for(int i=0; i<pemaingamemobileList.size();i++) {
			Object[] obj={pemaingamemobileList.get(i).name,pemaingamemobileList.get(i).id,pemaingamemobileList.get(i).jumlah};
			dtm.addRow(obj);
		}
	}

	/**
	 * Create the application.
	 */
	public Formutama() {
		initialize();
		pemaingamemobileList=new ArrayList<>();
		dtm=new DefaultTableModel(header,0);
		table.setModel(dtm);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 246, 131, 100);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_1.setIcon(new ImageIcon(GM));
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("List Data Pemain Game Mobile");
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 700, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nama Pemain Game Mobile");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(131, 261, 192, 17);
		frame.getContentPane().add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(357, 261, 202, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblIdPemainGame = new JLabel("ID Pemain Game Mobile");
		lblIdPemainGame.setForeground(Color.BLUE);
		lblIdPemainGame.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdPemainGame.setBounds(131, 292, 192, 17);
		frame.getContentPane().add(lblIdPemainGame);
		
		id = new JTextField();
		id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char cr = e.getKeyChar();
				if ((((cr < '0') || (cr > '9')) && (cr != '\b'))) {
					e.consume();
				}
			}
		});
		id.setColumns(10);
		id.setBounds(357, 292, 202, 20);
		frame.getContentPane().add(id);
		
		JLabel lblJumlahAkunPemain = new JLabel("Jumlah Akun Pemain");
		lblJumlahAkunPemain.setForeground(Color.BLUE);
		lblJumlahAkunPemain.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJumlahAkunPemain.setBounds(131, 326, 192, 17);
		frame.getContentPane().add(lblJumlahAkunPemain);
		
		jumlah = new JTextField();
		jumlah.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if ((((car < '0') || (car > '9')) && (car != '\b'))) {
					e.consume();
			}
			}
		});
		jumlah.setColumns(10);
		jumlah.setBounds(357, 326, 202, 20);
		frame.getContentPane().add(jumlah);
		
		JButton btninput = new JButton("Input");
		btninput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pemaingamemobile data=new pemaingamemobile(name.getText(),id.getText(),jumlah.getText());
				pemaingamemobileList.add(data);
				displaypemaingamemobileDetails();
			}
		});
		btninput.setFont(new Font("Tahoma", Font.BOLD, 12));
		btninput.setBounds(20, 391, 89, 23);
		frame.getContentPane().add(btninput);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choice=JOptionPane.showConfirmDialog(null, "Delete this data?", "Delete",JOptionPane.YES_NO_OPTION);
				if(choice==0) {
					dtm.removeRow(row);
					pemaingamemobileList.remove(row);
					displaypemaingamemobileDetails();
				}
				
			}
		});
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btndelete.setBounds(139, 391, 89, 23);
		frame.getContentPane().add(btndelete);
		
		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				id.setText("");
				jumlah.setText("");

			}
		});
		btnreset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnreset.setBounds(266, 391, 89, 23);
		frame.getContentPane().add(btnreset);
		
		JButton btnupdate = new JButton("Update");
		btnupdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pemaingamemobileList.get(row).name=name.getText();
				pemaingamemobileList.get(row).id=id.getText();
				pemaingamemobileList.get(row).jumlah=jumlah.getText();
				displaypemaingamemobileDetails();
			}
		});
		btnupdate.setBounds(394, 391, 89, 23);
		frame.getContentPane().add(btnupdate);
		
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		btnexit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnexit.setBounds(511, 391, 89, 23);
		frame.getContentPane().add(btnexit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 664, 211);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(152, 251, 152));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row=table.getSelectedRow();
				
				name.setText(dtm.getValueAt(row, 0).toString());
				id.setText(dtm.getValueAt(row, 1).toString());
				jumlah.setText(dtm.getValueAt(row, 2).toString());
			}
		});
		scrollPane.setViewportView(table);
	}
}
