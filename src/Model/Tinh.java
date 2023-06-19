package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Tinh {
    private int maTinh;
    private String tenTinh;

    public Tinh(int maTinh, String tenTinh) {
        this.maTinh = maTinh;
        this.tenTinh = tenTinh;
    }

    public int getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(int maTinh) {
        this.maTinh = maTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }

    

    @Override
	public int hashCode() {
		return Objects.hash(maTinh, tenTinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tinh other = (Tinh) obj;
		return maTinh == other.maTinh && Objects.equals(tenTinh, other.tenTinh);
	}

	@Override
    public String toString() {
        return "Tinh{" +
                "maTinh=" + maTinh +
                ", tenTinh='" + tenTinh + '\'' +
                '}';
    }
	public static ArrayList<Tinh> getDSTinh(){
		String[] arr_tinh = {"An Giang",
				"Bà Rịa-Vũng Tàu",
				"Bạc Liêu",
				"Bắc Kạn",
				"Bắc Giang",
				"Bắc Ninh",
				"Bến Tre",
				"Bình Dương",
				"Bình Định",
				"Bình Phước",
				"Bình Thuận",
				"Cà Mau",
				"Cao Bằng",
				"Thành phố Cần Thơ",
				"Thành phố Đà Nẵng",
				"Đắk Lắk",
				"Đắk Nông",
				"Điện Biên",
				"Đồng Nai",
				"Đồng Tháp",
				"Gia Lai",
				"Hà Giang",
				"Hà Nam",
				"Thành phố Hà Nội (Thủ đô)",
				"Hà Tây (đã sáp nhập)",
				"Hà Tĩnh",
				"Hải Dương",
				"Thành phố Hải Phòng",
				"Hòa Bình",
				"Thành phố Hồ Chí Minh",
				"Hậu Giang",
				"Hưng Yên",
				"Khánh Hòa",
				"Kiên Giang",
				"Kon Tum",
				"Lai Châu",
				"Lào Cai",
				"Lạng Sơn",
				"Lâm Đồng",
				"Long An",
				"Nam Định",
				"Nghệ An",
				"Ninh Bình",
				"Ninh Thuận",
				"Phú Thọ",
				"Phú Yên",
				"Quảng Bình",
				"Quảng Nam",
				"Quảng Ngãi",
				"Quảng Ninh",
				"Quảng Trị",
				"Sóc Trăng",
				"Sơn La",
				"Tây Ninh",
				"Thái Bình",
				"Thái Nguyên",
				"Thanh Hóa",
				"Thừa Thiên Huế",
				"Tiền Giang",
				"Trà Vinh",
				"Tuyên Quang",
				"Vĩnh Long",
				"Vĩnh Phúc",
				"Yên Bái"
};
		int i = 0;
		ArrayList<Tinh> listTinh = new ArrayList<Tinh>();
		for (String tenTinh : arr_tinh) {
			Tinh t = new Tinh(i,tenTinh);
			listTinh.add(t);
		}
		return listTinh;
		
	}

	public static Tinh getById(int queQuan) {
		return Tinh.getDSTinh().get(queQuan-1);
	}

	public static Tinh getTinhByTen(String tenTinh) {
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		for (Tinh tinh : listTinh) {
			if(tinh.tenTinh.equals(tenTinh)) {
				return tinh;
			}
			return null;
		}
		return null;
	}
}
