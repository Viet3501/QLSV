package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.xml.xpath.XPathEvaluationResult;

import Model.ThiSinh;
import Model.Tinh;
import View.QLSVView;

public class QLSVController implements ActionListener {
	public QLSVView view;

	public QLSVController(QLSVView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
//		JOptionPane.showConfirmDialog(view, "Bạn vừa nhấn vào: " + actionCommand);
		if (actionCommand.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		} else if (actionCommand.equals("Lưu")) {
			try {
				this.view.thucHienThem();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		} else if (actionCommand.equals("Xóa")) {
			this.view.thucHienXoa();
		} else if (actionCommand.equals("Cập nhật")) {
			this.view.hienThiThongTinThiSinhDaChon();

		} else if (actionCommand.equals("Hủy")) {
			this.view.xoaForm();
		}else if (actionCommand.equals("Tìm")) {
			this.view.thucHienTimKiem();
		}else if (actionCommand.equals("Hủy tìm")) {
			this.view.thucHienHuyTimKiem();
		}
	}

}
