package CuoiKi;

import java.awt.EventQueue;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import com.toedter.calendar.JDayChooser;

import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class GiaoDien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fnTxtField;
	private JTextField lnTxtField;
	private JTextField phoneTxtField;
	private JTable table;
	private DefaultTableModel model;
	private JTextField searchTxtField;
	private static String item;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien frame = new GiaoDien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GiaoDien() {
		setResizable(false);
		Connect();
		initialize();
		table_load();
		
				
		 if (con != null) {
		        System.out.println("Connection successful!");
		    } else {
		        System.out.println("Connection failed!");
		    }
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/qldv");
		}
		catch (ClassNotFoundException e) {
	        e.printStackTrace();

		}
		catch (SQLException ex) {
	        ex.printStackTrace();

		}
	}
		
	public void table_load() {
		
		try {
			pst = con.prepareStatement("SELECT * FROM records");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
				
	}
		
	private void initialize() {
			
		ImageIcon image = new ImageIcon("R.png");
		setIconImage(getToolkit().getImage("C:\\Users\\Lenovo\\Downloads\\R.jpg"));
				
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setTitle("Doan Vien Information Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		exitButton.setForeground(Color.WHITE);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		exitButton.setBackground(new Color(91, 91, 91));
		exitButton.setBounds(1066, 561, 119, 51);
		contentPane.add(exitButton);
		
		JLabel titleLabel = new JLabel("Doan Vien Information Management");
		titleLabel.setBounds(141, 27, 999, 61);
		titleLabel.setFont(new Font("Stencil", Font.BOLD, 50));
		contentPane.add(titleLabel);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		inputPanel.setBounds(23, 115, 480, 420);
		contentPane.add(inputPanel);
		inputPanel.setLayout(null);
		
		JLabel fnLabel = new JLabel("First Name");
		fnLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		fnLabel.setBounds(24, 29, 141, 56);
		inputPanel.add(fnLabel);
		
		fnTxtField = new JTextField();
		fnTxtField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fnTxtField.setBounds(185, 32, 251, 46);
		inputPanel.add(fnTxtField);
		fnTxtField.setColumns(10);
		
		lnTxtField = new JTextField();
		lnTxtField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lnTxtField.setColumns(10);
		lnTxtField.setBounds(185, 112, 251, 46);
		inputPanel.add(lnTxtField);
		
		JLabel lnLabel = new JLabel("Last Name");
		lnLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lnLabel.setBounds(24, 109, 141, 56);
		inputPanel.add(lnLabel);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		genderLabel.setBounds(45, 184, 141, 56);
		inputPanel.add(genderLabel);
		
		phoneTxtField = new JTextField();
		phoneTxtField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phoneTxtField.setColumns(10);
		phoneTxtField.setBounds(185, 269, 251, 46);
		inputPanel.add(phoneTxtField);
		
		JLabel phoneLabel = new JLabel("Phone");
		phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		phoneLabel.setBounds(45, 265, 141, 56);
		inputPanel.add(phoneLabel);
		
		JLabel dateLabel = new JLabel("Join Date");
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		dateLabel.setBounds(30, 342, 141, 56);
		inputPanel.add(dateLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		dateChooser.setBounds(185, 342, 251, 45);
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		inputPanel.add(dateChooser);
		
		JRadioButton maleRB = new JRadioButton("Male");
		maleRB.setFont(new Font("Tahoma", Font.BOLD, 19));
		maleRB.setBounds(192, 191, 103, 44);
		inputPanel.add(maleRB);
		
		JRadioButton femaleRB = new JRadioButton("Female");
		femaleRB.setFont(new Font("Tahoma", Font.BOLD, 19));
		femaleRB.setBounds(325, 191, 103, 45);
		inputPanel.add(femaleRB);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname, lname, gender = null, phone, jdate;
				
				fname = fnTxtField.getText();
				lname = lnTxtField.getText();
				
				if (maleRB.isSelected() && femaleRB.isSelected()) {
					
			    JOptionPane.showMessageDialog(null, "Please select only one gender!", "Error", JOptionPane.ERROR_MESSAGE);
			    throw new IllegalArgumentException("Can not select both Male and Female at the same time!");
			    
				} else if (maleRB.isSelected()) {
				    gender = "Male";
				} else if (femaleRB.isSelected()) {
				    gender = "Female";
				}
		
				phone = phoneTxtField.getText();
				jdate = sdf.format(dateChooser.getDate());
				
				if (con != null) {

				try {
					pst = con.prepareStatement("INSERT INTO records(fname, lname, gender, phone, jdate) VALUES(?,?,?,?,?)");
					pst .setString(1, fname);
					pst .setString(2, lname);
					pst .setString(3, gender);
					pst .setString(4, phone);
					pst .setString(5, jdate);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Added!");
                    table_load();
                    
                    fnTxtField.setText("");
                    lnTxtField.setText("");
                    maleRB.setSelected(false);
                    femaleRB.setSelected(false);
                    phoneTxtField.setText("");
                    dateChooser.setDate(null);
                    
                    fnTxtField.requestFocus();

				}
				
				catch (SQLException e1) {
					
			        JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
			    JOptionPane.showMessageDialog(null, "Error: Connection is not initialized!", "Error", JOptionPane.ERROR_MESSAGE);

			    }
				
			}
			
		});
		
		submitButton.setForeground(new Color(255, 255, 255));
		submitButton.setBackground(new Color(91, 91, 91));
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		submitButton.setBounds(34, 561, 126, 51);
		contentPane.add(submitButton);
				
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedIndex = table.getSelectedRow();

		        if (selectedIndex != -1) {
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            String idString = model.getValueAt(selectedIndex, 0).toString();
		            int id = Integer.parseInt(idString);

		            if (con != null) {
		                try {
		                    int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
		                    
		                    if (option == JOptionPane.YES_OPTION) {
		                        pst = con.prepareStatement("DELETE FROM records WHERE id=?");
		                        pst.setInt(1, id);
		                        pst.executeUpdate();
		                        JOptionPane.showMessageDialog(null, "Record Deleted!");
		                        table_load();

		                        
		                        fnTxtField.setText("");
		                        lnTxtField.setText("");
		                        maleRB.setSelected(false);
		                        femaleRB.setSelected(false);
		                        phoneTxtField.setText("");
		                        dateChooser.setDate(null);
		                        fnTxtField.requestFocus();
		                    }
		                } catch (SQLException e1) {
		                    JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Error: Connection is not initialized!", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		deleteButton.setBackground(new Color(91, 91, 91));
		deleteButton.setBounds(365, 561, 126, 51);
		contentPane.add(deleteButton);
		model = new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; 
		    }
		};
		Object[] column = {"ID", "First Name", "Last Name", "Gender", "Phone", "Join Date"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(527, 115, 681, 420);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	int viewIndex = table.getSelectedRow();

		        if (viewIndex != -1) {
		            int modelIndex = table.convertRowIndexToModel(viewIndex);
		            DefaultTableModel model = (DefaultTableModel) table.getModel();

		            fnTxtField.setText(model.getValueAt(modelIndex, 1).toString());
		            lnTxtField.setText(model.getValueAt(modelIndex, 2).toString());

		            String gender = model.getValueAt(modelIndex, 3).toString();
		            if ("Male".equals(gender)) {
		                maleRB.setSelected(true);
		                femaleRB.setSelected(false);
		            } else if ("Female".equals(gender)) {
		                maleRB.setSelected(false);
		                femaleRB.setSelected(true);
		            }

		            phoneTxtField.setText(model.getValueAt(modelIndex, 4).toString());

		            try {
		                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(modelIndex, 5).toString());
		                dateChooser.setDate(date);
		            } catch (ParseException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		});

		scrollPane.setViewportView(table);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));	
		table.setModel(model);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		searchPanel.setBounds(572, 551, 422, 61);
		contentPane.add(searchPanel);
		searchPanel.setLayout(null);
		
		JLabel searchLabel = new JLabel("Search by ID");
		searchLabel.setBounds(21, 7, 183, 45);
		searchPanel.add(searchLabel);
		searchLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		searchTxtField = new JTextField();
		searchTxtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
				    String id = searchTxtField.getText();
				    pst = con.prepareStatement("SELECT id, fname, lname, gender, phone, jdate FROM records WHERE id=?");
				    pst.setString(1, id);
				    ResultSet rs = pst.executeQuery();

				    if (rs.next()) {
				        String recordId = rs.getString(1);
				        String fname = rs.getString(2);
				        String lname = rs.getString(3);
				        String gender = rs.getString(4);
				        String phone = rs.getString(5);
				        Date jdate = rs.getDate(6);

				        DefaultTableModel model = (DefaultTableModel) table.getModel();
				        model.setRowCount(0); 			       
				        model.addRow(new Object[]{recordId, fname, lname, gender, phone, jdate});

				        fnTxtField.setText(fname);
				        lnTxtField.setText(lname);
				        if (gender.equals("Male")) {
				            maleRB.setSelected(true);
				            femaleRB.setSelected(false);
				        } else if (gender.equals("Female")) {
				            maleRB.setSelected(false);
				            femaleRB.setSelected(true);
				        }
				        phoneTxtField.setText(phone);
				        dateChooser.setDate(jdate);
				    } else {
				        
				        DefaultTableModel model = (DefaultTableModel) table.getModel();
				        table_load();
				        model.setRowCount(0);
				        fnTxtField.setText("");
				        lnTxtField.setText("");
				        maleRB.setSelected(false);
				        femaleRB.setSelected(false);
				        phoneTxtField.setText("");
				        dateChooser.setDate(null);
				    }
				} catch (SQLException e1) {
				    e1.printStackTrace();
				}
				
			}
		});
		
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            int selectedIndex = table.getSelectedRow();

		            if (selectedIndex != -1) {
		                DefaultTableModel model = (DefaultTableModel) table.getModel();
		                int idFromTable = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
		                String idFromSearchField = searchTxtField.getText();
		                String fname, lname, gender = null, phone, jdate;

		                fname = fnTxtField.getText();
		                lname = lnTxtField.getText();
		                if (maleRB.isSelected() && femaleRB.isSelected()) {
		                    JOptionPane.showMessageDialog(null, "Please select only one gender!", "Error", JOptionPane.ERROR_MESSAGE);
		                    throw new IllegalArgumentException("Can not select both Male and Female at the same time!");
		                } else if (maleRB.isSelected()) {
		                    gender = "Male";
		                } else if (femaleRB.isSelected()) {
		                    gender = "Female";
		                }

		                phone = phoneTxtField.getText();
		                jdate = sdf.format(dateChooser.getDate());

		                pst = con.prepareStatement("UPDATE records SET fname=?, lname=?, gender=?, phone=?, jdate=? WHERE id=?");
	              
		                if (!idFromSearchField.isEmpty()) {
		                    pst.setString(6, idFromSearchField);
		                } else {
		                    pst.setInt(6, idFromTable);
		                }

		                pst.setString(1, fname);
		                pst.setString(2, lname);
		                pst.setString(3, gender);
		                pst.setString(4, phone);
		                pst.setString(5, jdate);

		                pst.executeUpdate();
		                JOptionPane.showMessageDialog(null, "Record Edited!");
		                table_load();

		                fnTxtField.setText("");
		                lnTxtField.setText("");
		                maleRB.setSelected(false);
		                femaleRB.setSelected(false);
		                phoneTxtField.setText("");
		                dateChooser.setDate(null);

		                fnTxtField.requestFocus();
		            } else {
		                JOptionPane.showMessageDialog(null, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException e1) {
		            JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }

			}
										
		});
		editButton.setForeground(Color.WHITE);
		editButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		editButton.setBackground(new Color(91, 91, 91));
		editButton.setBounds(201, 561, 126, 51);
		contentPane.add(editButton);
		
		
		searchTxtField.setBounds(208, 10, 204, 43);
		searchPanel.add(searchTxtField);
		searchTxtField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchTxtField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Downloads\\background-doan-thanh-nien-dep-nhat_093953826.png"));
		lblNewLabel.setBounds(0, 0, 1236, 644);
		contentPane.add(lblNewLabel);
		
	}
}
