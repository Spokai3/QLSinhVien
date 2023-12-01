package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JRadioButton;

import controller.QLSVController;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_IDTim;
	public JTable table;
	public JTextField textField_IDThem;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public JComboBox comboBox_QueQuanTim;
	public JComboBox comboBox_QueQuanThem;
	public ButtonGroup btn_gioiTinh;
	public JRadioButton radioBtn_Nam;
	public JRadioButton radioBtn_Nu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		setTitle("Quản Lý Sinh Viên");
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 645);
		
		ActionListener action = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_QueQuan = new JLabel("Quê Quán");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_QueQuan.setBounds(28, 11, 114, 26);
		contentPane.add(label_QueQuan);
		
		JLabel lblMThSinh = new JLabel("Mã thí sinh");
		lblMThSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMThSinh.setBounds(343, 11, 114, 26);
		contentPane.add(lblMThSinh);
		
		textField_IDTim = new JTextField();
		textField_IDTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_IDTim.setColumns(10);
		textField_IDTim.setBounds(457, 11, 180, 26);
		contentPane.add(textField_IDTim);
		
		JButton btn_HuyTim = new JButton("Hủy Tìm");
		btn_HuyTim.addActionListener(action);
		btn_HuyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_HuyTim.setBounds(771, 11, 106, 26);
		contentPane.add(btn_HuyTim);
		
		comboBox_QueQuanTim = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_QueQuanTim.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuanTim.addItem(tinh.getTenTinh());
		}
		comboBox_QueQuanTim.setBounds(131, 11, 180, 26);
		contentPane.add(comboBox_QueQuanTim);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 48, 878, 2);
		contentPane.add(separator_1);
		
		JLabel label_QueQuan_2 = new JLabel("Danh sách thí sinh");
		label_QueQuan_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_QueQuan_2.setBounds(10, 61, 160, 26);
		contentPane.add(label_QueQuan_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3"
			}
		));
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 98, 878, 214);
		contentPane.add(scrollPane);
		
		JLabel lblThngTinTh = new JLabel("Thông tin thí sinh");
		lblThngTinTh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThngTinTh.setBounds(10, 336, 160, 26);
		contentPane.add(lblThngTinTh);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 323, 878, 2);
		contentPane.add(separator_1_1);
		
		JLabel lblMThSinh_1 = new JLabel("Mã thí sinh");
		lblMThSinh_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMThSinh_1.setBounds(10, 373, 114, 26);
		contentPane.add(lblMThSinh_1);
		
		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHVTn.setBounds(10, 410, 114, 26);
		contentPane.add(lblHVTn);
		
		JLabel lblQuQun = new JLabel("Quê quán");
		lblQuQun.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuQun.setBounds(10, 447, 114, 26);
		contentPane.add(lblQuQun);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgySinh.setBounds(10, 484, 114, 26);
		contentPane.add(lblNgySinh);
		
		textField_IDThem = new JTextField();
		textField_IDThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_IDThem.setColumns(10);
		textField_IDThem.setBounds(118, 373, 229, 26);
		contentPane.add(textField_IDThem);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(118, 410, 229, 26);
		contentPane.add(textField_HoVaTen);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(118, 484, 229, 26);
		contentPane.add(textField_NgaySinh);
		
		comboBox_QueQuanThem = new JComboBox();			
		comboBox_QueQuanThem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuanThem.addItem(tinh.getTenTinh());
		}
		comboBox_QueQuanThem.setBounds(118, 447, 229, 26);
		contentPane.add(comboBox_QueQuanThem);
		
		JLabel lblMThSinh_1_1 = new JLabel("Giới tính");
		lblMThSinh_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMThSinh_1_1.setBounds(442, 373, 114, 26);
		contentPane.add(lblMThSinh_1_1);
		
		radioBtn_Nam = new JRadioButton("Nam");
		radioBtn_Nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioBtn_Nam.setBounds(562, 375, 75, 23);
		contentPane.add(radioBtn_Nam);
		
		radioBtn_Nu = new JRadioButton("Nữ");
		radioBtn_Nu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioBtn_Nu.setBounds(656, 375, 94, 23);
		contentPane.add(radioBtn_Nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioBtn_Nam);
		btn_gioiTinh.add(radioBtn_Nu);
		
		JLabel lblMThSinh_1_1_1 = new JLabel("Môn 1");
		lblMThSinh_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMThSinh_1_1_1.setBounds(442, 410, 114, 26);
		contentPane.add(lblMThSinh_1_1_1);
		
		JLabel lblMThSinh_1_1_2 = new JLabel("Môn 2");
		lblMThSinh_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMThSinh_1_1_2.setBounds(442, 447, 114, 26);
		contentPane.add(lblMThSinh_1_1_2);
		
		JLabel lblMThSinh_1_1_3 = new JLabel("Môn 3");
		lblMThSinh_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMThSinh_1_1_3.setBounds(442, 484, 114, 26);
		contentPane.add(lblMThSinh_1_1_3);
		
		textField_Mon1 = new JTextField();
		textField_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(521, 410, 229, 26);
		contentPane.add(textField_Mon1);
		
		textField_Mon2 = new JTextField();
		textField_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(521, 447, 229, 26);
		contentPane.add(textField_Mon2);
		
		textField_Mon3 = new JTextField();
		textField_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(521, 484, 229, 26);
		contentPane.add(textField_Mon3);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBounds(128, 530, 96, 32);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setBounds(251, 530, 96, 32);
		contentPane.add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhat.setBounds(374, 530, 120, 32);
		contentPane.add(btnCapNhat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLuu.setBounds(521, 530, 96, 32);
		contentPane.add(btnLuu);
		
		JButton btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyBo.setBounds(644, 530, 96, 32);
		contentPane.add(btnHuyBo);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 521, 878, 2);
		contentPane.add(separator_1_1_1);
		
		JButton Button_Tim_1 = new JButton("Tìm");
		Button_Tim_1.addActionListener(action);
		Button_Tim_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button_Tim_1.setBounds(656, 11, 94, 26);
		contentPane.add(Button_Tim_1);

		this.setVisible(true);
	}

	public void xoaForm() {
		textField_IDThem.setText("");
		textField_HoVaTen.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_QueQuanThem.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();		
	}
	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[]{
				ts.getMaThiSinh()+"", 
				ts.getTenThiSinh(),
				ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900),
				(ts.isGioiTinh()?"Nam":"Nữ"),
				ts.getDiemMon1()+"",
				ts.getDiemMon2()+"",
				ts.getDiemMon3()+""});
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();					
		if (!this.model.kiemTraTonTai(ts)) {					
			this.model.insert(ts);
			this.themThiSinhVaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(id.equals(ts.getMaThiSinh()+"")) {
					model_table.setValueAt(ts.getMaThiSinh()+"",i,0);
					model_table.setValueAt(ts.getTenThiSinh()+"",i,1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh()+"",i,2);
					model_table.setValueAt(ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900),i,3);
					model_table.setValueAt((ts.isGioiTinh()?"Nam":"Nữ"),i,4);
					model_table.setValueAt(ts.getDiemMon1()+"",i,5);
					model_table.setValueAt(ts.getDiemMon2()+"",i,6);
					model_table.setValueAt(ts.getDiemMon3()+"",i,7);					
				}
			}
			
		}
	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenThiSinh = model_table.getValueAt(i_row, 1)+"";		
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String s_ngaySinh = model_table.getValueAt(i_row, 3)+"";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4)+""; 
		Boolean gioiTinh = textGioiTinh.equals("Nam");		
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7)+"");
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}
	public void hienThiThongTinThiSinhDaChon() {		
		ThiSinh ts = getThiSinhDangChon();				
		
		this.textField_IDThem.setText(ts.getMaThiSinh()+"");
		this.textField_HoVaTen.setText(ts.getTenThiSinh()+"");
		this.comboBox_QueQuanThem.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900);
		this.textField_NgaySinh.setText(s_ngaySinh);
		if (ts.isGioiTinh()) {
			radioBtn_Nam.setSelected(true);
		} else {
			radioBtn_Nu.setSelected(true);
		}
		this.textField_Mon1.setText(ts.getDiemMon1()+"");
		this.textField_Mon2.setText(ts.getDiemMon2()+"");
		this.textField_Mon3.setText(ts.getDiemMon3()+"");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn?","Xóa Thí Sinh",JOptionPane.YES_NO_OPTION);
		if(luaChon==JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
	}

	public void thuHienThemThiSinh() {
		int maThiSinh = Integer.valueOf(this.textField_IDThem.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_QueQuanThem.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		Boolean gioiTinh = true;
		String chonGioiTinh = this.btn_gioiTinh.getSelection()+"";
		if(this.radioBtn_Nam.isSelected()) {
			gioiTinh = true;
		} else if (this.radioBtn_Nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_Mon3.getText());
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		
		if (this.model.getLuaChon().equals("") || this.model.getLuaChon().equals("Thêm"))
			this.themHoacCapNhatThiSinh(ts);	
		
	}

	public void thucHienTim() {
		// Gọi hàm hủy tìm kiếm		
		this.thucHienTaiLaiDuLieu();
		// Thực hiện tìm kiếm
		int queQuan = this.comboBox_QueQuanTim.getSelectedIndex()-1;
		String maThiSinhTimKiem = this.textField_IDTim.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if(queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i =0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2)+"";
				String id = model_table.getValueAt(i, 0)+"";
				if (!tenTinh.equals(tinhDaChon)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		} 
		if (maThiSinhTimKiem.length()>0) {
			for (int i =0; i < soLuongDong; i++) {				
				String id = model_table.getValueAt(i, 0)+"";
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		} 
		for (Integer idCanXoa :idCuaThiSinhCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i =0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0)+"";				
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	
	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();			
			if (soLuongDong == 0 ) 
				break;
			else 
				model_table.removeRow(0);
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh v1.0!");
		
	}

	public void thoatKhoiChuongTrinh() {		
		int luaChon = JOptionPane.showConfirmDialog(this, "Thoát khỏi chương trình?","Exit",JOptionPane.YES_NO_OPTION);
		if(luaChon==JOptionPane.YES_OPTION) {
			System.exit(0);		
		}
		
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void thucHienSaveFile() {
		if (this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal  == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}
	
	private void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
		
			ThiSinh ts = null ;
			while((ts =(ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}			
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		this.model.setDsThiSinh(ds);
		
	}

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal  == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		}
	}

	
}
