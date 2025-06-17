# Warehouse Management System

## 📋 Tổng quan

Warehouse Management System là một ứng dụng desktop được phát triển bằng Java Swing, cung cấp giải pháp quản lý kho hàng toàn diện. Hệ thống cho phép quản lý hiệu quả các hoạt động nhập xuất kho, theo dõi hàng tồn kho, quản lý khách hàng, nhà cung cấp và người dùng.

## 🎯 Tính năng chính

### 🔐 Xác thực & Phân quyền
- **Đăng nhập/Đăng ký**: Hệ thống bảo mật với mã hóa BCrypt
- **Quên mật khẩu**: Gửi OTP qua email để khôi phục
- **Phân quyền**: Vai trò USER và ADMIN với quyền hạn khác nhau
- **Quản lý phiên**: Session management an toàn

### 📊 Dashboard & Thống kê
- **Biểu đồ tổng quan**: Hiển thị thống kê bằng bar chart trực quan
- **Metrics realtime**: Theo dõi Users, Products, Customers, Suppliers, Imports, Exports, Categories
- **Giao diện dashboard**: Charts và metrics được cập nhật theo thời gian thực

### 📦 Quản lý Sản phẩm
- **CRUD Operations**: Thêm, sửa, xóa, tìm kiếm sản phẩm
- **Tìm kiếm thông minh**: Tìm kiếm theo tên, category, giá cả
- **Phân loại sản phẩm**: Quản lý categories với tìm kiếm
- **Thông tin chi tiết**: Tên, giá, số lượng tồn kho, mô tả
- **Theo dõi inventory**: Cập nhật tự động khi nhập/xuất

### 📥 Quản lý Nhập kho
- **Tạo phiếu nhập**: Ghi nhận hàng hóa nhập vào kho
- **Tìm kiếm phiếu nhập**: Tìm kiếm theo ngày, nhà cung cấp, sản phẩm
- **Chi tiết nhập kho**: Sản phẩm, số lượng, giá nhập, ngày nhập
- **Liên kết nhà cung cấp**: Tracking nguồn gốc hàng hóa
- **Cập nhật tồn kho**: Tự động cập nhật số lượng sau khi nhập

### 📤 Quản lý Xuất kho
- **Tạo phiếu xuất**: Ghi nhận hàng hóa xuất khỏi kho
- **Tìm kiếm phiếu xuất**: Tìm kiếm theo ngày, khách hàng, sản phẩm
- **Chi tiết xuất kho**: Sản phẩm, số lượng, giá bán, ngày xuất
- **Liên kết khách hàng**: Tracking đơn hàng và giao dịch
- **Kiểm tra tồn kho**: Validation số lượng trước khi xuất

### 👥 Quản lý Khách hàng
- **CRUD Operations**: Quản lý thông tin khách hàng
- **Tìm kiếm khách hàng**: Tìm kiếm theo tên, email, số điện thoại
- **Thông tin liên hệ**: Tên, email, số điện thoại, địa chỉ
- **Lịch sử giao dịch**: Theo dõi các đơn hàng đã mua

### 🏢 Quản lý Nhà cung cấp
- **CRUD Operations**: Quản lý thông tin nhà cung cấp
- **Tìm kiếm nhà cung cấp**: Tìm kiếm theo tên, email, địa chỉ
- **Thông tin liên hệ**: Tên công ty, email, số điện thoại, địa chỉ
- **Lịch sử cung cấp**: Tracking các lô hàng đã nhập

### 👤 Quản lý Người dùng
- **Quản lý user** (Admin): Thêm, sửa, xóa người dùng
- **Tìm kiếm người dùng**: Tìm kiếm theo username, email, role
- **Phân quyền**: Gán roles USER/ADMIN
- **My Account**: User tự quản lý thông tin cá nhân
- **Profile management**: Cập nhật thông tin, đổi mật khẩu

### 🔍 Tính năng Tìm kiếm
- **Tìm kiếm toàn diện**: Tất cả các module đều có chức năng tìm kiếm
- **Real-time search**: Kết quả hiển thị ngay khi nhập
- **Multi-field search**: Tìm kiếm theo nhiều trường khác nhau
- **Case-insensitive**: Không phân biệt chữ hoa/thường
- **Partial matching**: Tìm kiếm theo từ khóa một phần

**Các module có tìm kiếm:**
- **Products**: Tìm theo tên, category, giá
- **Users**: Tìm theo username, email, full name
- **Customers**: Tìm theo tên, email, số điện thoại
- **Suppliers**: Tìm theo tên công ty, email, địa chỉ
- **Import Products**: Tìm theo ngày, nhà cung cấp
- **Export Products**: Tìm theo ngày, khách hàng
- **Categories**: Tìm theo tên category

## 🛠️ Công nghệ sử dụng

### Backend
- **Java 22** - Ngôn ngữ lập trình chính
- **Hibernate 6.5.3** - ORM Framework
- **MySQL 8** - Database
- **JPA/Jakarta Persistence** - Data persistence
- **BCrypt** - Password encryption
- **Apache POI** - Excel import/export
- **Spring Boot Mail** - Email service

### Frontend
- **Java Swing** - Desktop GUI
- **MigLayout** - Advanced layout manager
- **JFreeChart** - Charts và graphs
- **Custom UI Components** - Giao diện tùy chỉnh

### Build Tools
- **Maven** - Dependency management
- **Lombok** - Code generation

## 🏗️ Kiến trúc hệ thống

```
src/main/java/org/example/
├── WarehouseManagementSystem.java    # Main application entry point
├── constant/                         # Constants và messages
│   ├── CommonMessage.java
│   └── ErrorMessage.java
├── controller/                       # Controllers (MVC)
│   ├── LoginController.java
│   ├── UserController.java
│   ├── ProductController.java
│   ├── ImportProductController.java
│   ├── ExportProductController.java
│   ├── CategoryController.java
│   ├── CustomerController.java
│   └── SupplierController.java
├── domain/model/                     # Entity models
│   ├── UserModel.java
│   ├── ProductModel.java
│   ├── CategoryModel.java
│   ├── ImportProductModel.java
│   ├── ExportProductModel.java
│   ├── CustomerModel.java
│   ├── SupplierModel.java
│   └── ...
├── repository/                       # Data Access Objects
│   ├── UserDAO.java
│   ├── ProductDAO.java
│   ├── CategoryDAO.java
│   └── ...
├── service/                         # Business logic interfaces
│   ├── UserService.java
│   ├── ProductService.java
│   ├── DashboardService.java
│   └── impl/                       # Service implementations
│       ├── UserServiceImpl.java
│       ├── ProductServiceImpl.java
│       └── ...
├── utils/                          # Utility classes
│   ├── DatabaseUtil.java
│   ├── HibernateUtils.java
│   ├── PasswordEncoder.java
│   ├── SessionManager.java
│   └── ValidateUtil.java
└── view/                           # UI Components
    ├── Login.java
    ├── Register.java
    ├── MainDashboard.java
    └── component/
        ├── SidebarMenu.java
        ├── DashboardComponent/
        ├── ProductComponent/
        ├── UserComponent/
        └── ...
```

## 🚀 Cài đặt và chạy

### Yêu cầu hệ thống
- **Java 22** hoặc cao hơn
- **MySQL 8.0** hoặc cao hơn
- **Maven 3.6** hoặc cao hơn

### Cài đặt

1. **Clone repository**
```bash
git clone <repository-url>
cd warehouse-management
```

2. **Cấu hình database**
```sql
-- Tạo database MySQL
CREATE DATABASE warehouse_database;
```

3. **Cập nhật thông tin database** trong `src/main/resources/META-INF/persistence.xml`:
```xml
<property name="hibernate.connection.url" value="jdbc:mysql://localhost:3306/warehouse_database?createDatabaseIfNotExist=true" />
<property name="hibernate.connection.username" value="root" />
<property name="hibernate.connection.password" value="your_password" />
```

4. **Khởi tạo database** (chỉ chạy lần đầu):
   - Mở file `WarehouseManagementSystem.java`
   - Uncomment dòng: `DatabaseUtil.regenerateDatabase();`
   - Chạy ứng dụng một lần để tạo tables
   - Comment lại dòng đó sau khi chạy xong

5. **Build và chạy**
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="org.example.WarehouseManagementSystem"
```

### Chạy bằng IDE
1. Import project vào IDE (IntelliJ IDEA, Eclipse, NetBeans)
2. Cấu hình Maven project
3. Run `WarehouseManagementSystem.java`
