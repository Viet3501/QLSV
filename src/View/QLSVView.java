package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.QLSVModel;
import Model.ThiSinh;
import Model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.QLSVController;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	private JTextField textField_MaThiSinh_TimKiem;
	private JTable table;
	public JTextField textField_ID;
	public JTextField textField_HoTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Diem1;
	public JTextField textField_Diem2;
	public JTextField textField_Diem3;
	public JLabel label_QueQuan2;
	public JComboBox comboBox_QueQuan_1;
	public ButtonGroup btn_gioiTinh;
	public JRadioButton RadioButton_Nu;
	public JRadioButton RadioButton_Nam;
	public JComboBox comboBox_QueQuan;

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
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 760);

		ActionListener action = new QLSVController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Dialog", Font.PLAIN, 16));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuFile.add(menuOpen);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuClose = new JMenuItem("Close");
		menuClose.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuFile.add(menuClose);

		JSeparator separator_1 = new JSeparator();
		menuFile.add(separator_1);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Dialog", Font.PLAIN, 16));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_QueQuan1 = new JLabel("Quê quán");
		label_QueQuan1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_QueQuan1.setBounds(10, 16, 66, 24);
		contentPane.add(label_QueQuan1);

		JLabel label_MaThiSinh1 = new JLabel("Mã thí sinh");
		label_MaThiSinh1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_MaThiSinh1.setBounds(293, 16, 72, 24);
		contentPane.add(label_MaThiSinh1);

		textField_MaThiSinh_TimKiem = new JTextField();
		textField_MaThiSinh_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MaThiSinh_TimKiem.setColumns(10);
		textField_MaThiSinh_TimKiem.setBounds(375, 8, 149, 41);
		contentPane.add(textField_MaThiSinh_TimKiem);

		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(action);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTim.setBounds(550, 8, 119, 38);
		contentPane.add(btnTim);

		comboBox_QueQuan = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_QueQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan.addItem(tinh.getTenTinh());
		}
		comboBox_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_QueQuan.setBounds(86, 8, 186, 41);
		contentPane.add(comboBox_QueQuan);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 60, 794, 7);
		contentPane.add(separator_2);

		JLabel label_DanhSachThiSinh = new JLabel("Danh sách thí sinh");
		label_DanhSachThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_DanhSachThiSinh.setBounds(10, 60, 133, 24);
		contentPane.add(label_DanhSachThiSinh);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Gi\u1EDBi t\u00EDnh",
						"Ng\u00E0y sinh", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2",
						"\u0110i\u1EC3m m\u00F4n 3" }));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 98, 795, 265);
		contentPane.add(scrollPane);

		JLabel label_ThongTin = new JLabel("Thông tin thí sinh");
		label_ThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_ThongTin.setBounds(10, 369, 133, 24);
		contentPane.add(label_ThongTin);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 369, 794, 7);
		contentPane.add(separator_2_1);

		JLabel label_ID = new JLabel("Mã thí sinh");
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_ID.setBounds(10, 404, 133, 24);
		contentPane.add(label_ID);

		JLabel label_HoTen = new JLabel("Họ tên");
		label_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_HoTen.setBounds(10, 439, 133, 39);
		contentPane.add(label_HoTen);

		label_QueQuan2 = new JLabel("Quê quán");
		label_QueQuan2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_QueQuan2.setBounds(10, 489, 133, 24);
		contentPane.add(label_QueQuan2);

		JLabel label_NgaySinh = new JLabel("Ngày sinh");
		label_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_NgaySinh.setBounds(10, 535, 133, 24);
		contentPane.add(label_NgaySinh);

		textField_ID = new JTextField();
		textField_ID.setBounds(153, 403, 192, 30);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);

		textField_HoTen = new JTextField();
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(153, 445, 192, 30);
		contentPane.add(textField_HoTen);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(153, 534, 192, 30);
		contentPane.add(textField_NgaySinh);

		JLabel label_GioiTinh = new JLabel("Giới tính");
		label_GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_GioiTinh.setBounds(10, 580, 133, 24);
		contentPane.add(label_GioiTinh);

		JLabel label_Diem1 = new JLabel("Điểm môn 1");
		label_Diem1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Diem1.setBounds(488, 404, 81, 24);
		contentPane.add(label_Diem1);

		JLabel label_Diem2 = new JLabel("Điểm môn 2");
		label_Diem2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Diem2.setBounds(488, 446, 81, 24);
		contentPane.add(label_Diem2);

		JLabel label_Diem3 = new JLabel("Điểm môn 3");
		label_Diem3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Diem3.setBounds(488, 489, 81, 24);
		contentPane.add(label_Diem3);

		textField_Diem1 = new JTextField();
		textField_Diem1.setColumns(10);
		textField_Diem1.setBounds(592, 403, 192, 30);
		contentPane.add(textField_Diem1);

		textField_Diem2 = new JTextField();
		textField_Diem2.setColumns(10);
		textField_Diem2.setBounds(592, 445, 192, 30);
		contentPane.add(textField_Diem2);

		textField_Diem3 = new JTextField();
		textField_Diem3.setColumns(10);
		textField_Diem3.setBounds(592, 488, 192, 30);
		contentPane.add(textField_Diem3);

		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setBounds(10, 615, 794, 7);
		contentPane.add(separator_2_1_1);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBounds(10, 633, 125, 38);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setBounds(181, 633, 125, 38);
		contentPane.add(btnXoa);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhat.setBounds(352, 633, 125, 38);
		contentPane.add(btnCapNhat);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLuu.setBounds(522, 633, 125, 38);
		contentPane.add(btnLuu);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(action);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuy.setBounds(679, 633, 125, 38);
		contentPane.add(btnHuy);

		RadioButton_Nam = new JRadioButton("Nam");
		RadioButton_Nam.setBounds(152, 583, 66, 23);
		contentPane.add(RadioButton_Nam);

		RadioButton_Nu = new JRadioButton("Nữ");
		RadioButton_Nu.setBounds(245, 583, 60, 23);
		contentPane.add(RadioButton_Nu);

		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(RadioButton_Nam);
		btn_gioiTinh.add(RadioButton_Nu);

		comboBox_QueQuan_1 = new JComboBox();
		ArrayList<Tinh> listTinhThongTin = Tinh.getDSTinh();
		comboBox_QueQuan_1.addItem("");
		for (Tinh tinh : listTinhThongTin) {
			comboBox_QueQuan_1.addItem(tinh.getTenTinh());
		}

		comboBox_QueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_QueQuan_1.setBounds(153, 489, 192, 34);
		contentPane.add(comboBox_QueQuan_1);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyTim.setBounds(685, 8, 119, 38);
		contentPane.add(btnHuyTim);

		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoTen.setText("");
		comboBox_QueQuan_1.setSelectedItem("");
		textField_NgaySinh.setText("");
		btn_gioiTinh.clearSelection();
		textField_Diem1.setText("");
		textField_Diem2.setText("");
		textField_Diem3.setText("");
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);

			model_table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh() + "",
					ts.getQueQuan().getTenTinh() + "", ts.isGioiTinh() ? "Nam" : "Nữ",
					ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900),
					ts.getDiemMon1() + "", ts.getDiemMon2() + "", ts.getDiemMon3() + "" });
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(ts.isGioiTinh() ? "Nam" : "Nữ" + "", i, 3);
					model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900) + "", i, 4);
					model_table.setValueAt(ts.getDiemMon1() + "", i, 5);
					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);
				}
			}
		}
	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String textGioiTinh = model_table.getValueAt(i_row, 3) + "";
		String s_ngaySinh = model_table.getValueAt(i_row, 4) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();
		this.textField_ID.setText(ts.getMaThiSinh() + "");
		this.textField_HoTen.setText(ts.getTenThiSinh() + "");
		this.comboBox_QueQuan_1.setSelectedItem(ts.getQueQuan().getTenTinh());
		if (ts.isGioiTinh()) {
			RadioButton_Nam.setSelected(true);
		} else {
			RadioButton_Nu.setSelected(true);
		}
		String s_ngaySinh = ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
				+ (ts.getNgaySinh().getYear() + 1900);
		this.textField_NgaySinh.setText(s_ngaySinh + "");
		this.textField_Diem1.setText(ts.getDiemMon1() + "");
		this.textField_Diem2.setText(ts.getDiemMon2() + "");
		this.textField_Diem3.setText(ts.getDiemMon3() + "");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn?");
		if (luaChon == JOptionPane.YES_OPTION) {
			System.out.println("helo");
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}

	}

	public void thucHienThem() {
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_HoTen.getText();
		int queQuan = this.comboBox_QueQuan_1.getSelectedIndex();
		Tinh tinh = Tinh.getById(queQuan);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		boolean gioiTinh = true;
		String chonGioiTinh = this.btn_gioiTinh.getSelection() + "";
		if (this.RadioButton_Nam.isSelected()) {
			gioiTinh = true;
		} else if (this.RadioButton_Nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_Diem1.getText());
		float diemMon2 = Float.valueOf(this.textField_Diem2.getText());
		float diemMon3 = Float.valueOf(this.textField_Diem3.getText());
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);

		this.themHoacCapNhatThiSinh(ts);

	}

	public void thucHienTimKiem() {
		try {
			int queQuan = this.comboBox_QueQuan.getSelectedIndex();
			String maThiSinhTimKiem = this.textField_MaThiSinh_TimKiem.getText();
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
			if(queQuan == 0) {
				thucHienHuyTimKiem();
			}
			if (queQuan > 0) {
				Tinh tinhDaChon = Tinh.getById(queQuan);
				for (int i = 0; i < soLuongDong; i++) {
					String tenTinh = model_table.getValueAt(i, 2) + "";
					String id = model_table.getValueAt(i, 0) + "";
					if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
						idCuaThiSinhCanXoa.add(Integer.valueOf(id));
					}
				}
			}

			if (maThiSinhTimKiem.length() > 0) {
				System.out.println(maThiSinhTimKiem);
				for (int i = 0; i < soLuongDong; i++) {
					String id = model_table.getValueAt(i, 0) + "";
					if (!id.equals(maThiSinhTimKiem)) {
						idCuaThiSinhCanXoa.add(Integer.valueOf(id));
					}
				}
			}
			for (Integer idCanXoa : idCuaThiSinhCanXoa) {
				System.out.println(idCanXoa);
				soLuongDong = model_table.getRowCount();
				for (int i = 0; i < soLuongDong; i++) {
					String idTrongTable = model_table.getValueAt(i, 0) + "";
					if (idTrongTable.equals(idCanXoa.toString())) {
						try {
							model_table.removeRow(i);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void thucHienHuyTimKiem() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		for (int i = 0; i < model_table.getRowCount(); i++) {
			model_table.removeRow(i);
		}
		for (ThiSinh ts : model.getDsThiSinh()) {
			model_table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh() + "",
					ts.getQueQuan().getTenTinh() + "", ts.isGioiTinh() ? "Nam" : "Nữ",
					ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900),
					ts.getDiemMon1() + "", ts.getDiemMon2() + "", ts.getDiemMon3() + "" });
		}
	}
}
